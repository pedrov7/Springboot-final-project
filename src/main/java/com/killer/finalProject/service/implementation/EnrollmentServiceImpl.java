package com.killer.finalProject.service.implementation;

import com.killer.finalProject.dto.EnrollmentDTO;
import com.killer.finalProject.dto.EnrollmentDetailDTO;
import com.killer.finalProject.model.Enrollment;
import com.killer.finalProject.model.EnrollmentDetail;
import com.killer.finalProject.model.Student;
import com.killer.finalProject.repository.IEnrollmentRepository;
import com.killer.finalProject.repository.IGenericRepository;
import com.killer.finalProject.service.IEnrollmentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl extends CRUDImpl<Enrollment, Integer> implements IEnrollmentService{

    private final IEnrollmentRepository repo;
    private final ModelMapper mapper;

    @Override
    protected IGenericRepository<Enrollment, Integer> getRepository() {
        return repo;
    }

    @Override
    public Map<String, List<String>> getStudentsByCourse() {
        Stream<Enrollment> enrollmentStream = repo.findAll().stream();
        Stream<List<EnrollmentDetail>> listStream = enrollmentStream.map(Enrollment::getDetails);
        Stream<EnrollmentDetail> enrollmentDetailStream = listStream.flatMap(Collection::stream);

        Stream<EnrollmentDetailDTO> enrollmentDetailDTO = enrollmentDetailStream.map(this::convertToDto);

        return enrollmentDetailDTO.collect(Collectors.groupingBy(c->c.getCourse().getName(),Collectors.mapping(s->s.getEnrollment()
                .getStudent().getName()+ " " +s.getEnrollment().getStudent().getLastname(),Collectors.toList())));

    }
    public EnrollmentDetailDTO convertToDto(EnrollmentDetail obj) {
        return mapper.map(obj, EnrollmentDetailDTO.class);
    }
}
