package com.example.DocterApplication.dao;

import com.example.DocterApplication.Entity.DoctorRegistrationForm;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRegistrationFormRepository extends PagingAndSortingRepository<DoctorRegistrationForm, Integer> {
}