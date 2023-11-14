package com.example.DocterApplication.service.impl;

import com.example.DocterApplication.Entity.DoctorRegistrationForm;
import com.example.DocterApplication.dao.DoctorRegistrationFormRepository;
import com.example.DocterApplication.service.DoctorRegistrationFormService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DoctorRegistrationFormServiceImpl implements DoctorRegistrationFormService {
    private final DoctorRegistrationFormRepository repository;

    public DoctorRegistrationFormServiceImpl(DoctorRegistrationFormRepository repository) {
        this.repository = repository;
    }

    @Override
    public DoctorRegistrationForm save(DoctorRegistrationForm entity) {
        return repository.save(entity);
    }

    @Override
    public List<DoctorRegistrationForm> save(List<DoctorRegistrationForm> entities) {
        return (List<DoctorRegistrationForm>) repository.saveAll(entities);
    }


    @Override
    public Optional<DoctorRegistrationForm> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }


    @Override
    public List<DoctorRegistrationForm> findAll() {
        return (List<DoctorRegistrationForm>) repository.findAll();
    }

    @Override
    public Page<DoctorRegistrationForm> findAll(Pageable pageable) {
        Page<DoctorRegistrationForm> entityPage = repository.findAll(pageable);
        List<DoctorRegistrationForm> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }


    @Override
    public DoctorRegistrationForm update(DoctorRegistrationForm entity, Integer id) {
        Optional<DoctorRegistrationForm> optional = findById(id) ;
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}