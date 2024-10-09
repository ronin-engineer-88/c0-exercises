package src.service;

import src.dto.request.admin.CourseCreateReq;
import src.dto.request.admin.CourseSearchReq;
import src.dto.request.admin.CourseUpdateReq;
import src.dto.response.admin.CourseSearchRes;
import src.entity.Course;

public interface ICourseService {
    Course createCourse(CourseCreateReq req);
    Course updateCourse(Long courseId, CourseUpdateReq req);
    void softDeleteCourse(Long courseId);
    CourseSearchRes getCourses(int page, int pageSize, String sort, CourseSearchReq req);
}
