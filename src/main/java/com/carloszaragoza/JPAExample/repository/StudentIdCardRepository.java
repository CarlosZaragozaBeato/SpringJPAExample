package com.carloszaragoza.JPAExample.repository;

import com.carloszaragoza.JPAExample.model.StudentIdCard;
import org.springframework.data.repository.CrudRepository;

public interface StudentIdCardRepository extends CrudRepository<StudentIdCard, Long> {
}
