package src.util;

import src.dto.response.user.DetailResponse.TeacherResponseDto;
import src.entity.Teacher;

public class TeacherUtils {
    public static class User {
        public static TeacherResponseDto convertToResponseDto(Teacher teacher) {

            TeacherResponseDto teacherDto = new TeacherResponseDto();
            teacherDto.setName(teacher.getName());

            return teacherDto;
        }
    }
}
