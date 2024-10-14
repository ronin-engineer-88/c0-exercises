package src.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import src.dto.request.admin.CourseCreateReq;
import src.dto.request.admin.CourseSearchReq;
import src.dto.request.admin.CourseUpdateReq;
import src.dto.response.admin.CourseSearchRes;
import src.entity.Course;
import src.repository.CourseRepository;
import src.service.ICourseService;

@Service
public class CourseServiceImpl implements ICourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course createCourse(CourseCreateReq req) {
        return null;
    }

    @Override
    public Course updateCourse(Long courseId, CourseUpdateReq req) {
        return null;
    }

    @Override
    public void softDeleteCourse(Long courseId) {

    }

    @Override
    public CourseSearchRes getCourses(int page, int pageSize, String sort, CourseSearchReq req) {
        CourseSearchRes res = new CourseSearchRes();
        res.setSort(sort);
        res.setPage(page);
        res.setPageSize(pageSize);
        res.setName(req.getName());
        res.setStatus(req.getStatus());
        res.setTeacherName(res.getTeacherName());
        res.setCreatedDateFrom(req.getCreatedDateFrom());
        res.setCreatedDateTo(req.getCreatedDateTo());
        res.setRatingFrom(req.getRatingFrom());
        res.setRatingTo(req.getRatingTo());

        return res;
    }


}
