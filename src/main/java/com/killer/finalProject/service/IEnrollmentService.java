package com.killer.finalProject.service;

import com.killer.finalProject.model.Enrollment;

import java.util.List;
import java.util.Map;

public interface IEnrollmentService extends ICRUD<Enrollment, Integer> {

    Map<String, List<String>> getStudentsByCourse();

}

