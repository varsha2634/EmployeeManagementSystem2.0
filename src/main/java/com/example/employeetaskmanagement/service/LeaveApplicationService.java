package com.example.employeetaskmanagement.service;
import com.example.employeetaskmanagement.model.LeaveApplication;
public interface LeaveApplicationService {
    LeaveApplication saveLeaveApplication(LeaveApplication leaveApplication);
    LeaveApplication getLeaveApplicationById(String id);
    void approveLeave(String id);
    void rejectLeave(String id);
}