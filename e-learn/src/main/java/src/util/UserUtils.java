package src.util;

import org.springframework.beans.BeanUtils;
import src.dto.response.admin.UserResponseDto;
import src.entity.User;

public class UserUtils {
    public static class Admin {
        public static UserResponseDto convertToUserResponseDto(User user) {
            UserResponseDto userResponseDto = new UserResponseDto();
            BeanUtils.copyProperties(user, userResponseDto);
            userResponseDto.setFullName(FullNameUtils.Admin.convertToResponseDto(user.getFullName()));
            userResponseDto.setAddresses(
                    user.getAddress().stream()
                            .map(AddressUtils.Admin::convertToResponseDto)
                            .toList()
            );
            userResponseDto.setCreatedDate(DateUtils.dateTimeToString(user.getCreatedDate()));
            userResponseDto.setUpdatedDate(
                    user.getUpdatedDate() != null ? DateUtils.dateTimeToString(user.getUpdatedDate()) : null
            );
            userResponseDto.setNumCourseRegister(user.getUserCourses().size());

            return userResponseDto;
        }
    }

}
