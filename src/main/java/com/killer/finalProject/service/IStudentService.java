package com.killer.finalProject.service;

import com.killer.finalProject.model.Student;

import java.util.List;

public interface IStudentService extends ICRUD<Student,Integer> {

    List<Student> getStudentsOrdered();
}
