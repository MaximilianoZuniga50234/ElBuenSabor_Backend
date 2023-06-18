package com.example.elbuensaborbackend.services.Implementation;

import com.example.elbuensaborbackend.entities.Department;
import com.example.elbuensaborbackend.repositories.BaseRepository;
import com.example.elbuensaborbackend.repositories.DepartmentRepository;
import com.example.elbuensaborbackend.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;

public class DepartmentServiceImpl extends BaseServiceImpl<Department, Long> implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(BaseRepository<Department, Long> departmentRepository) {
        super(departmentRepository);
    }
}
