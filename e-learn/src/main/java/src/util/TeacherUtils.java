package src.util;

import src.dto.response.user.CourseDetailResponse.TeacherDetailDto;
import src.entity.Teacher;

public class TeacherUtils {
    public static TeacherDetailDto convertToDetailDto(Teacher teacher) {

        TeacherDetailDto teacherDto = new TeacherDetailDto();
        teacherDto.setName(teacher.getName());

        return teacherDto;
    }
}
