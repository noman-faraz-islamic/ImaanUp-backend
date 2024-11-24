package ImaanUp.com.example.ImaanUp.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "options")
@Data
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String optionText;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
}