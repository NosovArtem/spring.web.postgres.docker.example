package com.nsv.example.spring.web.postgres.docker.controller;

import com.nsv.example.spring.web.postgres.docker.model.StudentEntity;
import com.nsv.example.spring.web.postgres.docker.model.dto.StudentDTO;
import com.nsv.example.spring.web.postgres.docker.model.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("students")
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public List<StudentDTO> findAll() {
        Iterable<StudentEntity> all = studentRepository.findAll();
        return StreamSupport.stream(all.spliterator(), false)
                .map(studentEntity -> mapToStudentDTO(studentEntity))
                .toList();
    }

    StudentDTO mapToStudentDTO(StudentEntity studentEntity) {
        return StudentDTO.builder()
                .name(studentEntity.getName())
                .email(studentEntity.getEmail())
                .build();
    }

    @GetMapping("/{id}")
    public StudentEntity findById(@PathVariable Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @PostMapping
    public StudentDTO save(@RequestBody StudentDTO studentDTO) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(studentDTO.getName());
        studentEntity.setEmail(studentDTO.getEmail());
        return mapToStudentDTO(studentRepository.save(studentEntity));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        studentRepository.deleteById(id);
    }

    @PutMapping
    public StudentDTO update(@RequestBody StudentEntity studentEntity) {
        return mapToStudentDTO(studentRepository.save(studentEntity));
    }
}
