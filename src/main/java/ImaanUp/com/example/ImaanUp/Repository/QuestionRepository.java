package ImaanUp.com.example.ImaanUp.Repository;

import ImaanUp.com.example.ImaanUp.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
