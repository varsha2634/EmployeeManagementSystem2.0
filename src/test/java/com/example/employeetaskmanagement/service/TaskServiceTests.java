package com.example.employeetaskmanagement.service;

import com.example.employeetaskmanagement.model.Task;
import com.example.employeetaskmanagement.model.TaskStatus;
import com.example.employeetaskmanagement.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TaskServiceTests {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskServiceImpl taskService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAllTasks() {
        Task task1 = new Task();
        task1.setId("1");
        task1.setTitle("Task 1");

        Task task2 = new Task();
        task2.setId("2");
        task2.setTitle("Task 2");

        when(taskRepository.findAll()).thenReturn(Arrays.asList(task1, task2));

        List<Task> tasks = taskService.findAllTasks();
        assertEquals(2, tasks.size());
        verify(taskRepository, times(1)).findAll();
    }

    @Test
    public void testFindTaskById() {
        Task task = new Task();
        task.setId("1");
        task.setTitle("Task 1");

        when(taskRepository.findById("1")).thenReturn(Optional.of(task));

        Optional<Task> foundTask = taskService.findTaskById("1");
        assertTrue(foundTask.isPresent());
        assertEquals("Task 1", foundTask.get().getTitle());
        verify(taskRepository, times(1)).findById("1");
    }

    @Test
    public void testSaveTask() {
        Task task = new Task();
        task.setTitle("Task 1");
        task.setDescription("Description 1");
        task.setDeadline(LocalDate.now());
        task.setStatus(TaskStatus.PENDING);

        when(taskRepository.save(any(Task.class))).thenReturn(task);

        Task savedTask = taskService.saveTask(task);
        assertNotNull(savedTask);
        assertEquals("Task 1", savedTask.getTitle());
        verify(taskRepository, times(1)).save(task);
    }

    @Test
    public void testDeleteTask() {
        String taskId = "1";
        doNothing().when(taskRepository).deleteById(taskId);

        taskService.deleteTask(taskId);
        verify(taskRepository, times(1)).deleteById(taskId);
    }
}
