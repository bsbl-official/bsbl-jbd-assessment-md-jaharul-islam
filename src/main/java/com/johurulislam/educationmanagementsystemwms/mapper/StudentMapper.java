package com.johurulislam.educationmanagementsystemwms.mapper;

import com.johurulislam.educationmanagementsystemwms.dto.StudentRequest;
import com.johurulislam.educationmanagementsystemwms.dto.StudentResponse;
import com.johurulislam.educationmanagementsystemwms.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Student toEntity(StudentRequest request);

    StudentResponse toResponse(Student student);
}
