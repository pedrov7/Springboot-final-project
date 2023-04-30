package com.killer.finalProject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode (onlyExplicitlyIncluded = true)
@Entity
public class EnrollmentDetail {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "xid_course", nullable = false, foreignKey = @ForeignKey(name = "FK_DETAIL_COURSE"))
    private Course course;

    @ManyToOne
    @JoinColumn(name = "xid_enrollment", nullable = false, foreignKey = @ForeignKey(name = "FK_DETAIL_ENROLLMENT"))
    private Enrollment enrollment;

    @Column(nullable = false, length = 25)
    private String room;



}
