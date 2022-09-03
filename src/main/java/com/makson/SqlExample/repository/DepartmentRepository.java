package com.makson.SqlExample.repository;

import com.makson.SqlExample.model.Department;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DepartmentRepository extends CrudRepository<Department, Integer> {
    List<Department> findAll();

    Department findByName(String name);
}
