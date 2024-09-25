package src.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserStatusConstant {

    ACTIVE("ACTIVE"),
    INACTIVE("INACTIVE")
    ;

    private final String value;
}
