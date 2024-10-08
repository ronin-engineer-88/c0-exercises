package src.service.impl;

import org.springframework.stereotype.Service;
import src.dto.request.admin.TeacherCreateReq;
import src.dto.request.admin.TeacherSearchReq;
import src.dto.request.admin.TeacherUpdateReq;
import src.dto.response.admin.TeacherSearchRes;
import src.entity.Teacher;
import src.service.ITeacherService;

@Service
public class TeacherServiceImpl implements ITeacherService {

    @Override
    public Teacher createTeacher(TeacherCreateReq req) {
        return null;
    }

    @Override
    public Teacher updateTeacher(Long teacherId, TeacherUpdateReq req) {
        return null;
    }

    @Override
    public void deleteTeacher(Long teacherId) {

    }

    @Override
    public TeacherSearchRes getTeachers(int page, int pageSize, String sort, TeacherSearchReq req) {
        TeacherSearchRes res = new TeacherSearchRes();
        res.setSort(sort);
        res.setPage(page);
        res.setPageSize(pageSize);
        res.setUsername(req.getUsername());
        res.setName(req.getName());
        res.setStatus(req.getStatus());
        res.setCreatedDateFrom(req.getCreatedDateFrom());
        res.setCreatedDateTo(req.getCreatedDateTo());

        return res;
    }
}
