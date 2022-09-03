package com.makson.SqlExample.controller;

import com.makson.SqlExample.service.DepartmentService;
import com.makson.SqlExample.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/data")
public class MainController {
    @Autowired
    ProfessorService professorService;
    @Autowired
    DepartmentService departmentService;

    @GetMapping("/salary/{departmentName}")
    public ResponseEntity<Double> getAverageSalary(@PathVariable String departmentName) {
        return new ResponseEntity<>(professorService.averageSalary(departmentName), HttpStatus.OK);
    }

    @GetMapping("/departments")
    public ResponseEntity<List<String>> getDepartmentsWithDoctors() {
        return new ResponseEntity<>(professorService.getDepartmentsWithDoctor(), HttpStatus.OK);
    }

    @GetMapping("/lead/{name}")
    public ResponseEntity<List<String>> getDepartmentByLead(@PathVariable String name) {
        return new ResponseEntity<>(departmentService.getDepartmentByLead(name), HttpStatus.OK);
    }

    @GetMapping("/professors/{departmentName}")
    public ResponseEntity<List<String>> getProfessorsByDepartment(@PathVariable String departmentName) {
        return new ResponseEntity<>(departmentService.getProfessorsByDepartment(departmentName), HttpStatus.OK);
    }
}