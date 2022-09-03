package com.makson.SqlExample.service;

import com.makson.SqlExample.model.Department;
import com.makson.SqlExample.model.Professor;
import com.makson.SqlExample.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    public List<String> getDepartmentByLead(String name) {
        return departmentRepository.findAll()
                .stream().filter(Department -> Department.getLead().getName().equals(name))
                .map(Department::getName).collect(Collectors.toList());
    }

    public List<String> getProfessorsByDepartment(String departmentName) {
        return departmentRepository.findByName(departmentName).getStaff()
                .stream().map(Professor::getName).collect(Collectors.toList());
    }
}
