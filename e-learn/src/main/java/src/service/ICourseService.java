package src.service;

import src.dto.request.admin.CourseCreateReq;
import src.dto.request.admin.CourseSearchReq;
import src.dto.request.admin.CourseUpdateReq;
import src.dto.response.admin.CourseResponseDto;
import src.dto.response.admin.CourseSearchRes;

public interface ICourseService {
    CourseResponseDto createCourse(CourseCreateReq req);
    CourseResponseDto updateCourse(Long courseId, CourseUpdateReq req);
    void softDeleteCourse(Long courseId);
    CourseSearchRes getCourses(CourseSearchReq req);
    void deleteByStatus(String value);
}
