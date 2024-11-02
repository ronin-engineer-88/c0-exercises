package src.util;

import org.springframework.beans.BeanUtils;
import src.dto.response.admin.TeacherResDto;
import src.entity.Teacher;

public class TeacherUtils {

    public static TeacherResDto convertToResponseDto(Teacher teacher) {

        TeacherResDto teacherResDto = new TeacherResDto();
        BeanUtils.copyProperties(teacher, teacherResDto);
        teacherResDto.setCreatedDate(DateUtils.dateTimeToString(teacher.getCreatedDate()));
        teacherResDto.setUpdatedDate(
                teacher.getUpdatedDate() != null ? DateUtils.dateTimeToString(teacher.getUpdatedDate()) : null
        );

        return teacherResDto;
    }

}
