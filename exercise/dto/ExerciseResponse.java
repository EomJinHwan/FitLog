package Spring.FitLog.domain.exercise.dto;

import Spring.FitLog.domain.exercise.entity.ExercisePart;
import Spring.FitLog.domain.exercise.entity.ExerciseType;

public class ExerciseResponse {
    private Long exerciseNo;
    private String exerciseName;
    private ExerciseType exerciseType;
    private ExercisePart exercisePart;

    public ExerciseResponse(Long exerciseNo, String exerciseName, ExerciseType exerciseType, ExercisePart exercisePart) {
        this.exerciseNo = exerciseNo;
        this.exerciseName = exerciseName;
        this.exerciseType = exerciseType;
        this.exercisePart = exercisePart;
    }

    public Long getExerciseNo() {
        return exerciseNo;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public ExerciseType getExerciseType() {
        return exerciseType;
    }

    public ExercisePart getExercisePart() {
        return exercisePart;
    }
}
