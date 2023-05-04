package com.killer.finalProject.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.killer.finalProject.model.EnrollmentDetail;
import com.killer.finalProject.model.Student;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentDTO {

    private Integer id;

    private LocalDateTime enrollmentDate;

    @NotNull
    private StudentDTO student;

    @NotNull
    @JsonManagedReference
    private List<EnrollmentDetailDTO> details;

    @NotNull
    private boolean state;
}
