package com.nsv.example.spring.web.postgres.docker.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentDTO {
    private String name;
    private String email;
}
