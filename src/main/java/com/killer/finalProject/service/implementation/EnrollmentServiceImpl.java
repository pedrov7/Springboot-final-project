package com.killer.finalProject.service.implementation;

import com.killer.finalProject.model.Enrollment;
import com.killer.finalProject.repository.IEnrollmentRepository;
import com.killer.finalProject.repository.IGenericRepository;
import com.killer.finalProject.service.IEnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl extends CRUDImpl<Enrollment, Integer> implements IEnrollmentService{

    private final IEnrollmentRepository repo;

    @Override
    protected IGenericRepository<Enrollment, Integer> getRepository() {
        return repo;
    }

}
