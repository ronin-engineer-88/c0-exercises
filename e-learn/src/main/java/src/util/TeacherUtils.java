package src.util;

import src.dto.response.user.DetailResponse.TeacherResponseDto;
import src.entity.Teacher;

public class TeacherUtils {
    public static TeacherResponseDto convertToDto(Teacher teacher) {

        TeacherResponseDto teacherDto = new TeacherResponseDto();
        teacherDto.setName(teacher.getName());

        return teacherDto;
    }
}
