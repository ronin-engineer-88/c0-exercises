package src.util;

import src.dto.response.user.DetailResponse.FullNameResponseDto;
import src.entity.FullName;

public class FullNameUtils {

    public static FullNameResponseDto convertToDto (FullName fullName) {

        FullNameResponseDto fullNameResponseDto = new FullNameResponseDto();
        fullNameResponseDto.setFullName(
                fullName.getLastName() + " " +
                fullName.getMidName() + " " +
                fullName.getFirstName());

        return fullNameResponseDto;
    }

}
