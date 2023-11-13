package com.nsv.example.spring.web.postgres.docker.model.repository;

import com.nsv.example.spring.web.postgres.docker.model.StudentEntity;
import org.springframework.data.repository.CrudRepository;


public interface StudentRepository extends CrudRepository<StudentEntity, Long> {
}
