package src.dto.request.admin;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;
import src.dto.response.admin.SortOption;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CourseSearchReq {

    private String name;

    private String status;          // ACTIVE || INACTIVE

    private String teacherName;

    private String createdDateFrom; // yyyy-MM-dd HH:mi:ss

    private String createdDateTo;   // yyyy-MM-dd HH:mi:ss

    private Integer pageIndex;      // >= 0

    private Integer pageSize;       // <= 1

    private List<SortOption> sort;
}
