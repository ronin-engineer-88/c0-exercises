package src.util;

import src.dto.response.user.DetailResponse.AddressResponseDto;
import src.entity.Address;

public class AddressUtils {
    public static class User {
        public static AddressResponseDto convertToResponseDto(Address address) {

            AddressResponseDto addressResponseDto = new AddressResponseDto();
            addressResponseDto.setAddress(
                    address.getAddressDetail() + ", " +
                            address.getStreet() + ", " +
                            address.getDistrict() + ", " +
                            address.getCity() + ", " +
                            address.getCountry()
            );

            return addressResponseDto;
        }
    }


}
