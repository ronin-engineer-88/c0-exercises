package src.service;

import src.dto.request.admin.TeacherCreateReq;
import src.dto.request.admin.TeacherSearchReq;
import src.dto.request.admin.TeacherUpdateReq;
import src.dto.response.admin.TeacherResDto;
import src.dto.response.admin.TeacherSearchRes;

public interface ITeacherService {
    TeacherResDto createTeacher(TeacherCreateReq req);
    TeacherResDto updateTeacher(Long teacherId, TeacherUpdateReq req);
    void deleteTeacher(Long teacherId);
    TeacherSearchRes getTeachers(TeacherSearchReq req);
}
