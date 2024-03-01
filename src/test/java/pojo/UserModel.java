package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * pojo класс с JSON моделью пользователя
 */
@Data
@Builder
@EqualsAndHashCode(exclude = {"id"})
public class UserModel {
    private final Addition addition;

    @Data
    @Builder
    public static class Addition {
        @JsonProperty("additional_info")
        private final String additionalInfo;
        @JsonProperty("additional_number")
        private final int additionalNumber;
        private final String id;
    }

    private final String id;
    @JsonProperty("important_numbers")
    private final List<Integer> importantNumbers;
    private final String title;
    private final boolean verified;
}
