package ImaanUp.com.example.ImaanUp.Service;

import ImaanUp.com.example.ImaanUp.DTO.QuestionRequestDTO;
import ImaanUp.com.example.ImaanUp.DTO.QuestionResponseDTO;
import ImaanUp.com.example.ImaanUp.Entity.Option;
import ImaanUp.com.example.ImaanUp.Entity.Question;
import ImaanUp.com.example.ImaanUp.Repository.QuestionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Transactional
    public QuestionResponseDTO addQuestion(QuestionRequestDTO requestDTO) {
        Question question = new Question();
        question.setQuestionText(requestDTO.getQuestionText());

        List<Option> options = new ArrayList<>();
        for (String optionText : requestDTO.getOptionTexts()) {
            Option option = new Option();
            option.setOptionText(optionText);
            option.setQuestion(question);
            options.add(option);
        }

        question.setOptions(options);
        question.setRightOption(options.get(requestDTO.getCorrectOptionIndex()));

        Question savedQuestion = questionRepository.save(question);
        return QuestionResponseDTO.fromEntity(savedQuestion);
    }

    public List<QuestionResponseDTO> getAllQuestions() {
        return questionRepository.findAll()
                .stream()
                .map(QuestionResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }
}