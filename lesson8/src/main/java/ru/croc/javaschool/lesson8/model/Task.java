package ru.croc.javaschool.lesson8.model;

import java.util.UUID;

/**
 * Задача.
 */
public class Task {

    public static final String TABLE_NAME = "task";

    private UUID id;

    private String title;

    public Task() {
    }

    public Task(UUID id, String title) {
        this.id = id;
        this.title = title;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
