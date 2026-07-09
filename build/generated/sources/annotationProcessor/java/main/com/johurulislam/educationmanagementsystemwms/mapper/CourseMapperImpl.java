package com.johurulislam.educationmanagementsystemwms.mapper;

import com.johurulislam.educationmanagementsystemwms.dto.CourseRequest;
import com.johurulislam.educationmanagementsystemwms.dto.CourseResponse;
import com.johurulislam.educationmanagementsystemwms.model.Course;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-07-09T16:48:29+0600",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-java-compiler-worker-9.5.1.jar, environment: Java 21.0.7 (Amazon.com Inc.)"
)
@Component
public class CourseMapperImpl implements CourseMapper {

    @Override
    public Course toEntity(CourseRequest request) {
        if ( request == null ) {
            return null;
        }

        Course course = new Course();

        course.setCourseCode( request.courseCode() );
        course.setCourseName( request.courseName() );
        course.setCredit( request.credit() );

        return course;
    }

    @Override
    public CourseResponse toResponse(Course course) {
        if ( course == null ) {
            return null;
        }

        Long id = null;
        String courseCode = null;
        String courseName = null;
        Integer credit = null;
        LocalDateTime createdAt = null;
        LocalDateTime updatedAt = null;

        id = course.getId();
        courseCode = course.getCourseCode();
        courseName = course.getCourseName();
        credit = course.getCredit();
        createdAt = course.getCreatedAt();
        updatedAt = course.getUpdatedAt();

        CourseResponse courseResponse = new CourseResponse( id, courseCode, courseName, credit, createdAt, updatedAt );

        return courseResponse;
    }
}
