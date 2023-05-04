package ru.croc.javaschool.lesson8.repository.impl;

import ru.croc.javaschool.lesson8.model.Task;
import ru.croc.javaschool.lesson8.repository.TaskRepository;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

/**
 * Реализация репозитория задач для Derby.
 */
public class DerbyTaskRepository implements TaskRepository {

    private final DataSource dataSource;

    public DerbyTaskRepository(DataSource dataSource) {
        this.dataSource = dataSource;
        initTable();
    }

    @Override
    public void initTable() {
        System.out.println("Инициализация таблицы: " + Task.TABLE_NAME);
        try (var connection = dataSource.getConnection();
             var statement = connection.createStatement()) {
            var databaseMetadata = connection.getMetaData();
            var resultSet = databaseMetadata.getTables(
                    null,
                    null,
                    // Несмотря на то, что мы создаем таблицу в нижнем регистре (и дальше к ней так же обращаемся),
                    // поиск мы осуществляем в верхнем. Такие вот приколы
                    Task.TABLE_NAME.toUpperCase(),
                    new String[]{"TABLE"});
            if (resultSet.next()) {
                System.out.println("Таблица уже существует");
            } else {
                statement.executeUpdate(
                        "CREATE TABLE "
                                + Task.TABLE_NAME
                                + " ("
                                + "id VARCHAR(36) PRIMARY KEY, "
                                + "title VARCHAR(255)"
                                + ")");
                System.out.println("Таблица успешно создана");
            }
        } catch (SQLException e) {
            System.out.println("Возникла ошибка при создании таблицы: " + e.getMessage());
        } finally {
            System.out.println("=========================");
        }
    }

    @Override
    public Task create(Task task) {
        var query = "INSERT INTO " + Task.TABLE_NAME + " VALUES (?, ?)";
        var entityId = UUID.randomUUID();

        try (var connection = dataSource.getConnection();
             var statement = connection.prepareStatement(query)) {
            statement.setString(
                    1,
                    entityId.toString());
            statement.setString(
                    2,
                    task.getTitle());
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Возникла ошибка выполнения запроса (создание): " + e.getMessage());
            return null;
        }

        return findById(entityId);
    }

    @Override
    public List<Task> findAll() {
        return null;
    }

    @Override
    public Task findById(UUID id) {
        var task = (Task) null;
        var query = String.format(
                "SELECT id, title FROM %s WHERE id = '%s'",
                Task.TABLE_NAME,
                id);

        try (var connection = dataSource.getConnection();
             var statement = connection.createStatement();
             var resultSet = statement.executeQuery(query)) {
            if (resultSet.next()) {
                task = new Task(
                        UUID.fromString(
                                resultSet.getString("id")),
                        resultSet.getString("title"));
            }
        } catch (SQLException e) {
            System.out.println("Возникла ошибка выполнения запроса (поиск): " + e.getMessage());
        }

        return task;
    }
}
