package com.example.employeetaskmanagement.service;
import com.example.employeetaskmanagement.model.LeaveApplication;
import com.example.employeetaskmanagement.repository.LeaveApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class LeaveApplicationServiceImpl implements LeaveApplicationService {
    @Autowired
    private LeaveApplicationRepository leaveApplicationRepository;
    @Override
    public LeaveApplication saveLeaveApplication(LeaveApplication leaveApplication) {
        return leaveApplicationRepository.save(leaveApplication);
    }
    @Override
    public LeaveApplication getLeaveApplicationById(String id) {
        return leaveApplicationRepository.findById(id).orElse(null);
    }
    @Override
    public void approveLeave(String id) {
        LeaveApplication leave = leaveApplicationRepository.findById(id).orElse(null);
        if (leave != null){
            leave.setStatus("Approved");
        leaveApplicationRepository.save(leave);
    }
}
@Override
public void rejectLeave(String id) {
    LeaveApplication leave = leaveApplicationRepository.findById(id).orElse(null);
    if (leave != null) {
        leave.setStatus("Rejected");
        leaveApplicationRepository.save(leave);
    }
}
}