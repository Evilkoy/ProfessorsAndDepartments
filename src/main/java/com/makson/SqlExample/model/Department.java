package com.makson.SqlExample.model;

import lombok.Getter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "lead_id")
    private Professor lead;
    private String name;
    @OneToMany(mappedBy = "department")
    private Set<Professor> staff;
}
