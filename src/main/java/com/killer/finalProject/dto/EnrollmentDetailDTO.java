package com.killer.finalProject.dto;

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

        private Integer id;

        @NotNull
        @NotEmpty
        private Course course;

        @NotNull
        @NotEmpty
        private Enrollment enrollment;

        @NotNull
        @NotEmpty
        @Size(min=3,max = 25)
        private String room;
}
