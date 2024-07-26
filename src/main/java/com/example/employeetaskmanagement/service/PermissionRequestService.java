package com.example.employeetaskmanagement.service;
import com.example.employeetaskmanagement.model.PermissionRequest;
public interface PermissionRequestService {
    PermissionRequest savePermissionRequest(PermissionRequest permissionRequest);
    PermissionRequest getPermissionRequestById(String id);
    void approvePermission(String id);
    void rejectPermission(String id);
}