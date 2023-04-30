package com.killer.finalProject.service.implementation;

import com.killer.finalProject.model.EnrollmentDetail;
import com.killer.finalProject.repository.IEnrollmentDetailRepository;
import com.killer.finalProject.repository.IGenericRepository;
import com.killer.finalProject.service.ICourseService;
import com.killer.finalProject.service.IEnrollmentDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnrollmentDetailImpl extends CRUDImpl<EnrollmentDetail,Integer> implements IEnrollmentDetailService {

    private final IEnrollmentDetailRepository repo;

    @Override
    protected IGenericRepository<EnrollmentDetail, Integer> getRepository() {
        return repo;
    }
}
