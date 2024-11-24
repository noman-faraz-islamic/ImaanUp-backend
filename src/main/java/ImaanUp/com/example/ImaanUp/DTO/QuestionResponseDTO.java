package ImaanUp.com.example.ImaanUp.DTO;

import ImaanUp.com.example.ImaanUp.Entity.Question;
import lombok.Data;
import lombok.Builder;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class QuestionResponseDTO {
    private Long id;
    private String questionText;
    private List<OptionDTO> options;
    private Long correctOptionId;

    public static QuestionResponseDTO fromEntity(Question question) {
        List<OptionDTO> optionDTOs = question.getOptions().stream()
                .map(option -> OptionDTO.builder()
                        .id(option.getId())
                        .optionText(option.getOptionText())
                        .build())
                .collect(Collectors.toList());

        return QuestionResponseDTO.builder()
                .id(question.getId())
                .questionText(question.getQuestionText())
                .options(optionDTOs)
                .correctOptionId(question.getRightOption().getId())
                .build();
    }
}
