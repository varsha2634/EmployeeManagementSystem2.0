package com.example.employeetaskmanagement.service;

import com.example.employeetaskmanagement.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<Task> getAllTasks();
    Optional<Task> getTaskById(String id);
    Task saveTask(Task task);
    void deleteTask(String id);
}
