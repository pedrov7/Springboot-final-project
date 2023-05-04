package com.killer.finalProject.controller;

import com.killer.finalProject.dto.EnrollmentDTO;
import com.killer.finalProject.dto.EnrollmentDetailDTO;
import com.killer.finalProject.model.Enrollment;
import com.killer.finalProject.model.EnrollmentDetail;
import com.killer.finalProject.service.IEnrollmentDetailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/details")
@RequiredArgsConstructor
public class EnrollmentDetailController {
    private final IEnrollmentDetailService service;
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<EnrollmentDetailDTO>> readAll() throws Exception {
        List<EnrollmentDetailDTO> list = service.readAll().stream()
                .map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnrollmentDetailDTO> readById(@PathVariable("id") Integer id) throws Exception {
        EnrollmentDetailDTO dto = this.convertToDto(service.readById(id));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EnrollmentDetailDTO> create(@Valid @RequestBody EnrollmentDetailDTO dto) throws Exception {
        EnrollmentDetail object = service.save(this.convertToEntity(dto));
        return new ResponseEntity<>(this.convertToDto(object), HttpStatus.OK);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<EnrollmentDetailDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody EnrollmentDetailDTO dto) throws Exception {
//        dto.setId(id);
//        EnrollmentDetail object = service.update(this.convertToEntity(dto), id);
//        return new ResponseEntity<>(this.convertToDto(object), HttpStatus.OK);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public EnrollmentDetailDTO convertToDto(EnrollmentDetail obj) {
        return mapper.map(obj, EnrollmentDetailDTO.class);
    }

    public EnrollmentDetail convertToEntity(EnrollmentDetailDTO entity) {
        return mapper.map(entity, EnrollmentDetail.class);
    }
}
