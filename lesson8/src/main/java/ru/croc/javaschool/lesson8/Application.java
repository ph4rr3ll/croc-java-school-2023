package ru.croc.javaschool.lesson8;

import ru.croc.javaschool.lesson8.dsprovider.DerbyDataSourceProvider;
import ru.croc.javaschool.lesson8.property.PropertyContainer;
import ru.croc.javaschool.lesson8.repository.impl.DerbyTaskRepository;
import ru.croc.javaschool.lesson8.service.TaskService;

import java.io.IOException;

/**
 * Основной класс приложения.
 */
public class Application {

    public static void main(String[] args) throws IOException {
        PropertyContainer.loadProperties();

        var dataSourceProvider = new DerbyDataSourceProvider();
        var taskRepository = new DerbyTaskRepository(
                dataSourceProvider.getDataSource());
        var taskService = new TaskService(taskRepository);

        var task = taskService.createNewTask("Не идти работать в *ндекс");
        System.out.printf(
                "Создана задача: id = %s, наименование = %s%n",
                task.getId(),
                task.getTitle());
    }
}
