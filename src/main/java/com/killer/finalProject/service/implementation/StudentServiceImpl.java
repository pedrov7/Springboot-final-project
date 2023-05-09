package com.killer.finalProject.service.implementation;

import com.killer.finalProject.model.Student;
import com.killer.finalProject.repository.IGenericRepository;
import com.killer.finalProject.repository.IStudentRepository;
import com.killer.finalProject.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl extends CRUDImpl<Student,Integer> implements IStudentService {

    private final IStudentRepository repo;

    @Override
    protected IGenericRepository<Student, Integer> getRepository() {
        return repo;
    }

    @Override
    public List<Student> getStudentsOrdered() {
        return repo.findAll()
                .stream().sorted((x,y) -> y.getAge() - x.getAge()).toList();
    }
}
