package com.example.employeetaskmanagement.service;
import com.example.employeetaskmanagement.model.PermissionRequest;
import com.example.employeetaskmanagement.repository.PermissionRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PermissionRequestServiceImpl implements PermissionRequestService {
    @Autowired
    private PermissionRequestRepository permissionRequestRepository;
    @Override
    public PermissionRequest savePermissionRequest(PermissionRequest permissionRequest) {
        return permissionRequestRepository.save(permissionRequest);
    }
    @Override
    public PermissionRequest getPermissionRequestById(String id) {
        return permissionRequestRepository.findById(id).orElse(null);
    }
    @Override
    public void approvePermission(String id) {
        PermissionRequest permission =
                permissionRequestRepository.findById(id).orElse(null);
        if (permission != null) {
            permission.setStatus("Approved");
            permissionRequestRepository.save(permission);
        }
    }
    @Override
    public void rejectPermission(String id) {
        PermissionRequest permission =
                permissionRequestRepository.findById(id).orElse(null);
        if (permission != null) {
            permission.setStatus("Rejected");
            permissionRequestRepository.save(permission);
        }
    }
}