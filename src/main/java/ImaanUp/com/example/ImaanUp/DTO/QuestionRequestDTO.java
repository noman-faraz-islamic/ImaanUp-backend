package ImaanUp.com.example.ImaanUp.DTO;

import lombok.Data;
import java.util.List;

@Data
public class QuestionRequestDTO {
    private String questionText;

    private List<String> optionTexts;

    private Integer correctOptionIndex;
}