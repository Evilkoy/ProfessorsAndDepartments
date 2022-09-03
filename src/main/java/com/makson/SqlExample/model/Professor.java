package com.makson.SqlExample.model;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "professors")
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    private String name;
    @ManyToOne
    @JoinColumn(name = "scientific_degree_id")
    private ScientificDegree scientificDegree;
    private Integer salary;
}