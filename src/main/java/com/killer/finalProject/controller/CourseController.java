package com.killer.finalProject.controller;

import com.killer.finalProject.model.Course;
import com.killer.finalProject.service.ICourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {
    private final ICourseService service;

    @GetMapping("/{id}")
    public ResponseEntity<Course> readById(@PathVariable("id") Integer id) throws Exception {
        Course course = service.readById(id);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Course>> readAll() throws Exception {
        List<Course> listOfCourses = service.readAll();
        return new ResponseEntity<>(listOfCourses, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Course> create(@RequestBody Course course) throws Exception {
        Course object = service.save(course);
        return new ResponseEntity<>(object,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> update (@PathVariable("id") Integer id, @RequestBody Course course) throws Exception{
        course.setId(id);
        Course object = service.update(course,id);
        return new ResponseEntity<>(object,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
