package com.makson.SqlExample.service;

import com.makson.SqlExample.model.Professor;
import com.makson.SqlExample.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfessorService {
    @Autowired
    ProfessorRepository professorRepository;

    public double averageSalary(String departmentName) {
        return professorRepository.findAll()
                .stream().filter(Professor -> Professor.getDepartment().getName().equals(departmentName))
                .map(Professor::getSalary).mapToInt(Professor -> Professor).average().orElse(0);
    }

    public List<String> getDepartmentsWithDoctor() {
        return professorRepository.findAll()
                .stream().filter(professor -> professor.getScientificDegree().getName().equals("Doctor of sciences"))
                .map(professor -> professor.getDepartment().getName()).distinct().collect(Collectors.toList());
    }
}