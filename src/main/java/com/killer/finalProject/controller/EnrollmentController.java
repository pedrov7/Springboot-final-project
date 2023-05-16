package com.killer.finalProject.controller;

import com.killer.finalProject.dto.EnrollmentDTO;
import com.killer.finalProject.dto.EnrollmentDetailDTO;
import com.killer.finalProject.dto.StudentDTO;
import com.killer.finalProject.model.Course;
import com.killer.finalProject.model.Enrollment;
import com.killer.finalProject.model.EnrollmentDetail;
import com.killer.finalProject.model.Student;
import com.killer.finalProject.service.IEnrollmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {

    private final IEnrollmentService service;
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<EnrollmentDTO>> readAll() throws Exception {
        List<EnrollmentDTO> list = service.readAll().stream()
                .map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnrollmentDTO> readById(@PathVariable("id") Integer id) throws Exception {
        Enrollment obj = service.readById(id);
        EnrollmentDTO dto = this.convertToDto(obj);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EnrollmentDTO> create(@Valid @RequestBody EnrollmentDTO dto) throws Exception {
        Enrollment object = service.save(this.convertToEntity(dto));
        return new ResponseEntity<>(this.convertToDto(object), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnrollmentDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody EnrollmentDTO dto) throws Exception {
        dto.setId(id);
        Enrollment object = service.update(this.convertToEntity(dto), id);
        return new ResponseEntity<>(this.convertToDto(object), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Return Students enrolled by Course, the convertion to DTO is in Service Implementation
     */
    @GetMapping("/course_students")
    public ResponseEntity<Map<String, List<String>>> relationCourseStudents() throws Exception {
        Map<String, List<String>> answer = service.getStudentsByCourse();

        return new ResponseEntity<>(answer, HttpStatus.OK);
    }


    public EnrollmentDTO convertToDto(Enrollment obj) {
        return mapper.map(obj, EnrollmentDTO.class);
    }

    public Enrollment convertToEntity(EnrollmentDTO entity) {
        return mapper.map(entity, Enrollment.class);
    }

}
