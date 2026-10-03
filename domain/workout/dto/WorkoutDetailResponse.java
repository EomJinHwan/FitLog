package Spring.FitLog.domain.workout.dto;

import Spring.FitLog.domain.workout.entity.WorkoutLog;

import java.time.LocalDate;
import java.util.List;

public class WorkoutDetailResponse {

    private Long workoutLogNo;
    private LocalDate workoutDate;
    private List<WorkoutExerciseResponse> exercises;

    public WorkoutDetailResponse(WorkoutLog workoutLog) {
        this.workoutLogNo = workoutLog.getWorkoutLogNo();
        this.workoutDate = workoutLog.getWorkoutDate();
        this.exercises = workoutLog.getWorkoutExercises().stream()
                .map(workoutExercise -> new WorkoutExerciseResponse(workoutExercise))
                .toList();
    }

    public Long getWorkoutLogNo() {
        return workoutLogNo;
    }

    public LocalDate getWorkoutDate() {
        return workoutDate;
    }

    public List<WorkoutExerciseResponse> getExercises() {
        return exercises;
    }
}
