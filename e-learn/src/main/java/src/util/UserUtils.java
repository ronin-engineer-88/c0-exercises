package src.util;

import org.springframework.beans.BeanUtils;
import src.dto.response.admin.UserResponseDto;
import src.entity.Student;

public class UserUtils {

    public static UserResponseDto convertToUserResponseDto(Student user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        BeanUtils.copyProperties(user, userResponseDto);
        userResponseDto.setCreatedDate(DateUtils.dateTimeToString(user.getCreatedDate()));
        userResponseDto.setUpdatedDate(
                user.getUpdatedDate() != null ? DateUtils.dateTimeToString(user.getUpdatedDate()) : null
        );

        return userResponseDto;
    }

}
