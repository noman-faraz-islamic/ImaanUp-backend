package ImaanUp.com.example.ImaanUp.DTO;

import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class OptionDTO {
    private Long id;
    private String optionText;
}