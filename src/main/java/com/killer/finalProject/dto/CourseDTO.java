package com.killer.finalProject.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {

    private Integer id;

    @NotNull
    @NotEmpty
    @Size(min=3,max = 10)
    private String name;

    @NotNull
    @NotEmpty
    @Size(min=1,max = 5)
    private String acronym;

    @NotNull
    private boolean state;

}
