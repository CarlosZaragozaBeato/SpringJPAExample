package com.carloszaragoza.JPAExample.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class EnrolmentId implements Serializable {

    @Column(name = "student_id")
    private Long studentId;


    @Column(name = "course_id")
    private Long courseId;
}