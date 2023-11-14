package com.example.DocterApplication.controller.impl;

import com.example.DocterApplication.Entity.DoctorRegistrationForm;
import com.example.DocterApplication.controller.DoctorRegistrationFormController;
import com.example.DocterApplication.dto.DoctorRegistrationFormDTO;
import com.example.DocterApplication.mapper.DoctorRegistrationFormMapper;
import com.example.DocterApplication.service.DoctorRegistrationFormService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/api/doctor-registration-form")
@RestController
public class DoctorRegistrationFormControllerImpl implements DoctorRegistrationFormController {
    private final DoctorRegistrationFormService doctorRegistrationFormService;
    private final DoctorRegistrationFormMapper doctorRegistrationFormMapper;

    public DoctorRegistrationFormControllerImpl(DoctorRegistrationFormService doctorRegistrationFormService, DoctorRegistrationFormMapper doctorRegistrationFormMapper) {
        this.doctorRegistrationFormService = doctorRegistrationFormService;
        this.doctorRegistrationFormMapper = doctorRegistrationFormMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DoctorRegistrationFormDTO save(@RequestBody DoctorRegistrationFormDTO doctorRegistrationFormDTO) {
        DoctorRegistrationForm doctorRegistrationForm = doctorRegistrationFormMapper.asEntity(doctorRegistrationFormDTO);
        return doctorRegistrationFormMapper.asDTO(doctorRegistrationFormService.save(doctorRegistrationForm));
    }

    @Override
    @GetMapping("/{id}")
    public DoctorRegistrationFormDTO findById(@PathVariable("id") int id) {
        DoctorRegistrationForm doctorRegistrationForm = doctorRegistrationFormService.findById(id).orElse(null);
        return doctorRegistrationFormMapper.asDTO(doctorRegistrationForm);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        doctorRegistrationFormService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<DoctorRegistrationFormDTO> list() {
        return doctorRegistrationFormMapper.asDTOList(doctorRegistrationFormService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<DoctorRegistrationFormDTO> pageQuery(Pageable pageable) {
        Page<DoctorRegistrationForm> doctorRegistrationFormPage = doctorRegistrationFormService.findAll(pageable);
        List<DoctorRegistrationFormDTO> dtoList = doctorRegistrationFormPage
                .stream()
                .map(doctorRegistrationFormMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, doctorRegistrationFormPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public DoctorRegistrationFormDTO update(@RequestBody DoctorRegistrationFormDTO doctorRegistrationFormDTO, @PathVariable("id") Integer id) {
        DoctorRegistrationForm doctorRegistrationForm = doctorRegistrationFormMapper.asEntity(doctorRegistrationFormDTO);
        return doctorRegistrationFormMapper.asDTO(doctorRegistrationFormService.update(doctorRegistrationForm, id));
    }
}