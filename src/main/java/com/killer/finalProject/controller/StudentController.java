package com.killer.finalProject.controller;

import com.killer.finalProject.model.Student;
import com.killer.finalProject.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final IStudentService service;

    @GetMapping("/{id}")
    public ResponseEntity<Student> readById(@PathVariable("id") Integer id) throws Exception {
        Student student = service.readById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Student>> readAll() throws Exception {
        List<Student> listOfStudents = service.readAll();
        return new ResponseEntity<>(listOfStudents, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> create(@RequestBody Student student) throws Exception {
        Student object = service.save(student);
        return new ResponseEntity<>(object,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update (@PathVariable("id") Integer id, @RequestBody Student student) throws Exception{
        student.setId(id);
        Student object = service.update(student,id);
        return new ResponseEntity<>(object,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
