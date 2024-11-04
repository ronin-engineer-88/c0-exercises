package src.util;

import src.dto.response.admin.FullNameResponseDto;
import src.entity.FullName;

public class FullNameUtils {
    public static class Admin {
        public static FullNameResponseDto convertToResponseDto(FullName fullName) {
            FullNameResponseDto fullNameResponseDto = new FullNameResponseDto();
            fullNameResponseDto.setFullName(
                    fullName.getLastName() + " " +
                            fullName.getMidName() + " " +
                            fullName.getFirstName());

            return fullNameResponseDto;
        }
    }

}
