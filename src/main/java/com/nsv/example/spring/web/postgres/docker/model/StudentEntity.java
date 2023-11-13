package com.nsv.example.spring.web.postgres.docker.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "student")
@Data
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String email;
}
