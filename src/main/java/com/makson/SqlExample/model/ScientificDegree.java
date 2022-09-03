package com.makson.SqlExample.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "scientific_degrees")
public class ScientificDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "scientificDegree")
    private Set<Professor> professorSet;
}
