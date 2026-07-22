package Spring.FitLog.domain.exercise.repository;

import Spring.FitLog.domain.exercise.entity.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    
}
