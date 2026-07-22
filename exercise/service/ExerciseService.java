package Spring.FitLog.domain.exercise.service;

import Spring.FitLog.domain.exercise.dto.ExerciseResponse;
import Spring.FitLog.domain.exercise.entity.Exercise;
import Spring.FitLog.domain.exercise.entity.ExercisePart;
import Spring.FitLog.domain.exercise.entity.ExerciseType;
import Spring.FitLog.domain.exercise.repository.ExerciseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService {
    private ExerciseRepository repository;

    public ExerciseService(ExerciseRepository repository) {
        this.repository = repository;
    }

    // 운동 종목 등록
    public ExerciseResponse createExercise(String exerciseName, ExerciseType exerciseType, ExercisePart exercisePart) {
        Exercise exercise = new Exercise(exerciseName, exerciseType, exercisePart);

        Exercise saveExercise = repository.save(exercise);

        return new ExerciseResponse(saveExercise.getExerciseNo(),
                saveExercise.getExerciseName(),
                saveExercise.getExerciseType(),
                saveExercise.getExercisePart());
    }

    // 운동 종목 전체 조회
    public List<Exercise> findAll() {
        return repository.findAll();
    }

    // 운동 종목 삭제
    public void deleteById(Long exerciseNo) {
        repository.findById(exerciseNo)
                .orElseThrow(() -> new IllegalArgumentException("운동을 찾을 수 없습니다."));

        repository.deleteById(exerciseNo);
    }
}
