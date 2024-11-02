package src.service.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import src.entity.Teacher;
import src.exception.TeacherException.TeacherNotFoundException;
import src.repository.TeacherRepository;

@Service
public class TeacherValidateService {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherValidateService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Teacher validateTeacherExist(Long teacherId) {
        return teacherRepository.getTeacherById(teacherId)
                .orElseThrow(() -> new TeacherNotFoundException("Not found teacher with id: " + teacherId));
    }
}
