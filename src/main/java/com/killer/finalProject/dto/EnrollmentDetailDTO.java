package com.killer.finalProject.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.killer.finalProject.model.Course;
import com.killer.finalProject.model.Enrollment;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentDetailDTO {

        @NotNull
        private CourseDTO course;

        @JsonBackReference
        private EnrollmentDTO enrollment;

        @NotNull
        @NotEmpty
        @Size(min=3,max = 25)
        private String room;
}
