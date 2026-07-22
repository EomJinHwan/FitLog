package Spring.FitLog.domain.workout.dto;

import java.time.LocalDate;
import java.util.List;

public class WorkoutCreateRequest {

    private LocalDate workoutDate;
    private List<WorkoutExerciseRequest> exercises;

    public WorkoutCreateRequest() {
    }

    public LocalDate getWorkoutDate() {
        return workoutDate;
    }

    public List<WorkoutExerciseRequest> getExercises() {
        return exercises;
    }
}
