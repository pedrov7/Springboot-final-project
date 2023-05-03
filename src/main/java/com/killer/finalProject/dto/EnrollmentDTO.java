package com.killer.finalProject.dto;

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

    @NotNull
    @NotEmpty
    private LocalDateTime enrollmentDate;

    @NotNull
    @NotEmpty
    private Student student;

    @NotNull
    private List<EnrollmentDetail> enrollmentDetails;

    @NotNull
    private boolean state;
}
