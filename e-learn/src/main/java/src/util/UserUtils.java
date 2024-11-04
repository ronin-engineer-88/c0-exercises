package src.util;

import src.dto.response.user.DetailResponse.UserResponseDto;
import src.entity.User;

import java.util.stream.Collectors;


public class UserUtils {
        public static UserResponseDto convertToResponseDto(User user) {

            UserResponseDto userResponseDto = new UserResponseDto();
            userResponseDto.setFullName(
                    user.getFullName() != null ? FullNameUtils.User.convertToResponseDto(user.getFullName()) : null
            );

            userResponseDto.setAddresses( user.getAddress() != null ?
                    user.getAddress().stream()
                            .map(AddressUtils.User::convertToResponseDto)
                            .collect(Collectors.toList()) : null);

            userResponseDto.setUsername(user.getUsername());
            userResponseDto.setPassword(user.getPassword());
            userResponseDto.setStatus(user.getStatus());
            userResponseDto.setCreatedDate(DateUtils.dateTimeToString(user.getCreatedDate()));
            userResponseDto.setUpdatedDate(
                    user.getUpdatedDate() != null ? DateUtils.dateTimeToString(user.getUpdatedDate()) : null
            );
            userResponseDto.setRegisterCourses(user.getUserCourses().size());

            return userResponseDto;
        }

}
