package Spring.FitLog.domain.workout.dto;

import Spring.FitLog.domain.workout.entity.WorkoutExercise;

import java.util.List;

public class WorkoutExerciseResponse {

    private String exerciseName;
    private Integer orderIndex;
    private List<WorkoutSetResponse> sets;

    public WorkoutExerciseResponse(WorkoutExercise workoutExercise) {
        this.exerciseName = workoutExercise.getExercise().getExerciseName();
        this.orderIndex = workoutExercise.getOrderIndex();
        this.sets = workoutExercise.getWorkoutSets().stream()
                .map(workoutSet -> new WorkoutSetResponse(workoutSet))
                .toList();
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public List<WorkoutSetResponse> getSets() {
        return sets;
    }
}
