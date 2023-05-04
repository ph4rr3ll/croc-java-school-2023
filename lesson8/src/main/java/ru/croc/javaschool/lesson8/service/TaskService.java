package ru.croc.javaschool.lesson8.service;

import ru.croc.javaschool.lesson8.model.Task;
import ru.croc.javaschool.lesson8.repository.TaskRepository;

public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createNewTask(String title) {
        var creatingTask = new Task();
        creatingTask.setTitle(title);
        return taskRepository.create(creatingTask);
    }
}
