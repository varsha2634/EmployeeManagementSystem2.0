package com.example.employeetaskmanagement.repository;

import com.example.employeetaskmanagement.model.Task;
import com.example.employeetaskmanagement.model.TaskStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@DataMongoTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TaskRepositoryTests {

    @Autowired
    private TaskRepository taskRepository;

    @BeforeEach
    public void setUp() {
        taskRepository.deleteAll();

        Task task1 = new Task();
        task1.setTitle("Complete project report");
        task1.setDescription("Write and submit the final project report.");
        task1.setDeadline(LocalDate.of(2023, 7, 31));
        task1.setStatus(TaskStatus.PENDING);

        Task task2 = new Task();
        task2.setTitle("Prepare presentation");
        task2.setDescription("Create slides for the project presentation.");
        task2.setDeadline(LocalDate.of(2023, 8, 15));
        task2.setStatus(TaskStatus.IN_PROGRESS);

        taskRepository.save(task1);
        taskRepository.save(task2);
    }

    @Test
    public void testFindAll() {
        List<Task> tasks = taskRepository.findAll();
        Assertions.assertEquals(2, tasks.size());
    }

    @Test
    public void testFindById() {
        Task task = taskRepository.findAll().get(0);
        Optional<Task> foundTask = taskRepository.findById(task.getId());
        Assertions.assertTrue(foundTask.isPresent());
        Assertions.assertEquals(task.getTitle(), foundTask.get().getTitle());
    }

    @Test
    public void testSave() {
        Task task = new Task();
        task.setTitle("Review code");
        task.setDescription("Review the code for the new feature.");
        task.setDeadline(LocalDate.of(2023, 8, 25));
        task.setStatus(TaskStatus.PENDING);

        Task savedTask = taskRepository.save(task);
        Assertions.assertNotNull(savedTask.getId());
        Assertions.assertEquals("Review code", savedTask.getTitle());
    }

    @Test
    public void testDeleteById() {
        Task task = taskRepository.findAll().get(0);
        taskRepository.deleteById(task.getId());

        Optional<Task> deletedTask = taskRepository.findById(task.getId());
        Assertions.assertFalse(deletedTask.isPresent());
    }
}
