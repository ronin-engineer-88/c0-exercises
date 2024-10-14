package src.service;

import src.dto.request.admin.TeacherCreateReq;
import src.dto.request.admin.TeacherSearchReq;
import src.dto.request.admin.TeacherUpdateReq;
import src.dto.response.admin.TeacherSearchRes;
import src.entity.Teacher;

public interface ITeacherService {
    Teacher createTeacher(TeacherCreateReq req);
    Teacher updateTeacher(Long teacherId, TeacherUpdateReq req);
    void deleteTeacher(Long teacherId);
    TeacherSearchRes getTeachers(int page, int pageSize, String sort, TeacherSearchReq req);
}
