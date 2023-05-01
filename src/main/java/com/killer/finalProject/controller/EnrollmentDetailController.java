package com.killer.finalProject.controller;

import com.killer.finalProject.model.EnrollmentDetail;
import com.killer.finalProject.service.IEnrollmentDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/details")
@RequiredArgsConstructor
public class EnrollmentDetailController {
    private final IEnrollmentDetailService service;

    @GetMapping
    public ResponseEntity<List<EnrollmentDetail>> readAll() throws Exception {
        List<EnrollmentDetail> list = service.readAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EnrollmentDetail> create(@RequestBody EnrollmentDetail enrollmentDetail) throws Exception {
        EnrollmentDetail object = service.save(enrollmentDetail);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnrollmentDetail> update(@PathVariable("id") Integer id, @RequestBody EnrollmentDetail enrollmentDetail) throws Exception {
        enrollmentDetail.setId(id);
        EnrollmentDetail object = service.update(enrollmentDetail, id);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
