package com.example.DocterApplication.mapper;

import com.example.DocterApplication.Entity.DoctorRegistrationForm;
import com.example.DocterApplication.dto.DoctorRegistrationFormDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DoctorRegistrationFormMapper extends GenericMapper<DoctorRegistrationForm, DoctorRegistrationFormDTO> {
    @Override
    @Mapping(target = "id", ignore = false)
    DoctorRegistrationForm asEntity(DoctorRegistrationFormDTO dto);
}