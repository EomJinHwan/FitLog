package Spring.FitLog.domain.exercise.controller;

import Spring.FitLog.domain.exercise.dto.ExerciseCreateRequest;
import Spring.FitLog.domain.exercise.dto.ExerciseResponse;
import Spring.FitLog.domain.exercise.entity.Exercise;
import Spring.FitLog.domain.exercise.service.ExerciseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ExerciseController {
    private ExerciseService service;

    public ExerciseController(ExerciseService service) {
        this.service = service;
    }

    /**
     * 운동 등록
     */
    @PostMapping("/exercises")
    public ExerciseResponse createExercise(@RequestBody ExerciseCreateRequest request) {
        return service.createExercise(request.getExerciseName(),
                request.getExerciseType(),
                request.getExercisePart());
    }

    /**
     * 전체 운동 보기
     */
    @GetMapping("/exercises")
    public List<Exercise> findAll() {
        return service.findAll();
    }

    /**
     * 운동 삭제
     */
    @DeleteMapping("/exercises/{exerciseNo}")
    public String deleteExercise(@PathVariable Long exerciseNo) {
        service.deleteById(exerciseNo);

        return "운동이 삭제되었습니다.";
    }
}
