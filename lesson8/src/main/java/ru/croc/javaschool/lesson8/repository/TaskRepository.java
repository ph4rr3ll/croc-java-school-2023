package ru.croc.javaschool.lesson8.repository;

import ru.croc.javaschool.lesson8.model.Task;

import java.util.List;
import java.util.UUID;

/**
 * Интерфейс репозитория задач.
 */
public interface TaskRepository {

    /**
     * Метод инициализации таблицы.
     */
    void initTable();

    /**
     * Метод создания новой записи.
     */
    Task create(Task task);

    /**
     * Метод получения всех записей из таблицы&
     *
     * @return список записей
     */
    List<Task> findAll();

    /**
     * Метод поиска задачи по ее идентификатору.
     *
     * @param id идентификатор задачи
     * @return искомая задача
     */
    Task findById(UUID id);
}
