package ImaanUp.com.example.ImaanUp.Controller;

import ImaanUp.com.example.ImaanUp.DTO.QuestionRequestDTO;
import ImaanUp.com.example.ImaanUp.DTO.QuestionResponseDTO;
import ImaanUp.com.example.ImaanUp.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
@CrossOrigin(origins = "*")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @PostMapping
    public ResponseEntity<QuestionResponseDTO> addQuestion(@RequestBody QuestionRequestDTO questionDTO) {
        return ResponseEntity.ok(questionService.addQuestion(questionDTO));
    }

    @GetMapping
    public ResponseEntity<List<QuestionResponseDTO>> getAllQuestions() {
        return ResponseEntity.ok(questionService.getAllQuestions());
    }
}
