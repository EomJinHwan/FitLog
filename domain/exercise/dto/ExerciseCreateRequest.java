package Spring.FitLog.domain.exercise.dto;

import Spring.FitLog.domain.exercise.entity.ExercisePart;
import Spring.FitLog.domain.exercise.entity.ExerciseType;

public class ExerciseCreateRequest {
    private String exerciseName;
    private ExerciseType exerciseType;
    private ExercisePart exercisePart;

    public ExerciseCreateRequest() {
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
