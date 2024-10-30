package src.dto.request.admin;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.*;
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
public class ChapterUpdateReq {

    @NotEmpty(message = "Chapter name is required.")
    @Size(max = 255, message = "Chapter name must be less than 255 characters.")
    private String name;

    @Size(max = 1000, message = "Description must be less than 1000 characters.")
    private String description;

    @NotNull(message = "Status cannot be null")
    @Pattern(regexp = "0|1", message = "Status must be 0 (inactive) or 1 (active)")
    private Integer status;

    @NotNull(message = "Order is required.")
    @Min(value = 1, message = "Order must be greater than 0.")
    private Integer order;
}
