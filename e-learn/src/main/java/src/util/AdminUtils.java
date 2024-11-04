package src.util;

import org.springframework.beans.BeanUtils;
import src.dto.response.admin.AdminResponseDto;
import src.entity.Admin;

public class AdminUtils {

    public static AdminResponseDto convertToResponseDto(Admin admin) {

        AdminResponseDto adminResponseDto = new AdminResponseDto();
        BeanUtils.copyProperties(admin, adminResponseDto);
        adminResponseDto.setCreatedDate(DateUtils.dateTimeToString(admin.getCreatedDate()));
        adminResponseDto.setUpdatedDate(
                admin.getUpdatedDate() != null ? DateUtils.dateTimeToString(admin.getUpdatedDate()) : null
        );

        return adminResponseDto;

    }

}
