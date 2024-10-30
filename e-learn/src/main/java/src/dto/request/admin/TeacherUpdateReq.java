package src.dto.request.admin;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TeacherUpdateReq {

    @NotBlank(message = "Name must not be blank.")
    @Size(max = 50, message = "Name must not exceed 50 characters.")
    private String name;

    @NotNull(message = "Status cannot be null")
    @Pattern(regexp = "0|1", message = "Status must be 0 (inactive) or 1 (active)")
    private Integer status;

    @Size(max = 50, message = "Username must not exceed 50 characters.")
    private String username;

    @Size(min = 6, max = 20, message = "Password must be between 6 and 20 characters.")
    private String password;
}
