package com.makson.SqlExample.repository;

import com.makson.SqlExample.model.Professor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProfessorRepository extends CrudRepository<Professor, Integer> {
    List<Professor> findAll();
}
