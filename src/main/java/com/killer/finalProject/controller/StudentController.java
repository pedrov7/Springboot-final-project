package com.killer.finalProject.controller;

import com.killer.finalProject.dto.EnrollmentDetailDTO;
import com.killer.finalProject.dto.StudentDTO;
import com.killer.finalProject.model.EnrollmentDetail;
import com.killer.finalProject.model.Student;
import com.killer.finalProject.service.IStudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final IStudentService service;
    private final ModelMapper mapper;

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> readById(@PathVariable("id") Integer id) throws Exception {
        StudentDTO dto = this.convertToDto(service.readById(id));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> readAll() throws Exception {
        List<StudentDTO> list = service.readAll().stream()
                .map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentDTO> create(@Valid @RequestBody StudentDTO dto) throws Exception {
        Student object = service.save(this.convertToEntity(dto));
        return new ResponseEntity<>(this.convertToDto(object), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody StudentDTO dto) throws Exception {
        dto.setId(id);
        Student object = service.update(this.convertToEntity(dto), id);
        return new ResponseEntity<>(this.convertToDto(object), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public StudentDTO convertToDto(Student obj) {
        return mapper.map(obj, StudentDTO.class);
    }

    public Student convertToEntity(StudentDTO entity) {
        return mapper.map(entity, Student.class);
    }
}
