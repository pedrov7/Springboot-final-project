package com.killer.finalProject.service.implementation;

import com.killer.finalProject.model.Course;
import com.killer.finalProject.repository.ICourseRepository;
import com.killer.finalProject.repository.IGenericRepository;
import com.killer.finalProject.service.ICourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl extends CRUDImpl<Course,Integer> implements ICourseService {

    private final ICourseRepository repo;
    @Override
    protected IGenericRepository<Course, Integer> getRepository() {
        return repo;
    }
}
