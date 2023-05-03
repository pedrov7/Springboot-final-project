package com.killer.finalProject.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    private Integer id;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 100)
    private String name;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 100)
    private String lastname;

    @NotNull
    @NotEmpty
    @Size(min = 10, max = 10)
    private String dni;

    @NotNull
    @Min(value = 1)
    @Max(value = 115)
    private int age;
}
