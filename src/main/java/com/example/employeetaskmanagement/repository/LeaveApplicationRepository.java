package com.example.employeetaskmanagement.repository;
import com.example.employeetaskmanagement.model.LeaveApplication;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface LeaveApplicationRepository extends MongoRepository<LeaveApplication,
        String> {
}
