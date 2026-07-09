package com.johurulislam.educationmanagementsystemwms.mapper;

import com.johurulislam.educationmanagementsystemwms.dto.CourseRequest;
import com.johurulislam.educationmanagementsystemwms.dto.CourseResponse;
import com.johurulislam.educationmanagementsystemwms.model.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Course toEntity(CourseRequest request);

    CourseResponse toResponse(Course course);
}
