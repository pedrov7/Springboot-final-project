package com.killer.finalProject.controller;

import com.killer.finalProject.model.Enrollment;
import com.killer.finalProject.model.EnrollmentDetail;
import com.killer.finalProject.service.IEnrollmentDetailService;
import com.killer.finalProject.service.IEnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {

    private final IEnrollmentService service;

    @GetMapping
    public ResponseEntity<List<Enrollment>> readAll() throws Exception {
        List<Enrollment> list = service.readAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Enrollment> create(@RequestBody Enrollment enrollment) throws Exception {
        Enrollment object = service.save(enrollment);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Enrollment> update(@PathVariable("id") Integer id, @RequestBody Enrollment enrollment) throws Exception {
        enrollment.setId(id);
        Enrollment object = service.update(enrollment, id);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
