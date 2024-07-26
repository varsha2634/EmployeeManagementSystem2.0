package com.example.employeetaskmanagement.repository;

import com.example.employeetaskmanagement.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task, String> {
}
