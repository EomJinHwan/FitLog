package Spring.FitLog.domain.workout.dto;

public class WorkoutSetRequest {

    private Integer setNumber;
    private Double weight;
    private Integer reps;

    public WorkoutSetRequest() {
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
