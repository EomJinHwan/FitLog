package Spring.FitLog.domain.workout.dto;

import Spring.FitLog.domain.workout.entity.WorkoutSet;

public class WorkoutSetResponse {
    private Integer setNumber;
    private Double weight;
    private Integer reps;

    public WorkoutSetResponse(WorkoutSet workoutSet) {
        this.setNumber = workoutSet.getSetNumber();
        this.weight = workoutSet.getWeight();
        this.reps = workoutSet.getReps();
    }

    public Integer getSetNumber() {
        return setNumber;
    }

    public Double getWeight() {
        return weight;
    }

    public Integer getReps() {
        return reps;
    }
}
