package com.example.DocterApplication.controller;

import com.example.DocterApplication.dto.DoctorRegistrationFormDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "DoctorRegistrationForm API")
public interface DoctorRegistrationFormController {
    @ApiOperation("Add new data")
    public DoctorRegistrationFormDTO save(@RequestBody DoctorRegistrationFormDTO doctorRegistrationForm);

    @ApiOperation("Find by Id")
    public DoctorRegistrationFormDTO findById(@PathVariable("id") int id);

    @ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") int id);

    @ApiOperation("Find all data")
    public List<DoctorRegistrationFormDTO> list();

    @ApiOperation("Pagination request")
    public Page<DoctorRegistrationFormDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    public DoctorRegistrationFormDTO update(@RequestBody DoctorRegistrationFormDTO dto, @PathVariable("id") Integer id);
}