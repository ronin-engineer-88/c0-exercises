package src.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ConfigConstant {

    ACTIVE("active", 1),
    INACTIVE("inactive", 0);

    private final String value;
    private final int code;
}
