package com.killer.finalProject.controller;

import com.killer.finalProject.dto.CourseDTO;
import com.killer.finalProject.model.Course;
import com.killer.finalProject.service.ICourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {
    private final ICourseService service;
    private final ModelMapper mapper;

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> readById(@PathVariable("id") Integer id) throws Exception {
        Course course = service.readById(id);
        CourseDTO courseDTO = this.convertToDto(course);
        return new ResponseEntity<>(courseDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CourseDTO>> readAll() throws Exception {
        List<CourseDTO> listOfCourses = service.readAll().stream()
                .map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(listOfCourses, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CourseDTO> create(@Valid @RequestBody CourseDTO courseDTO) throws Exception {
        Course object = service.save(this.convertToEntity(courseDTO));
        return new ResponseEntity<>(this.convertToDto(object), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody CourseDTO courseDTO) throws Exception {
        courseDTO.setId(id);
        Course object = service.update(this.convertToEntity(courseDTO), id);
        return new ResponseEntity<>(this.convertToDto(object), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public CourseDTO convertToDto(Course obj) {
        return mapper.map(obj, CourseDTO.class);
    }

    public Course convertToEntity(CourseDTO entity) {
        return mapper.map(entity, Course.class);
    }

}
