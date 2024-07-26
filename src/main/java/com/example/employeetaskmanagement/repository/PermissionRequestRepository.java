package com.example.employeetaskmanagement.repository;
import com.example.employeetaskmanagement.model.PermissionRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface PermissionRequestRepository extends MongoRepository<PermissionRequest,
        String> {
}