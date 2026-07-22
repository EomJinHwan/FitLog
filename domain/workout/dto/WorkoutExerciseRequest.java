package Spring.FitLog.domain.workout.dto;

import java.util.List;

public class WorkoutExerciseRequest {

    private Long exerciseNo;
    private Integer orderIndex;
    private List<WorkoutSetRequest> sets;

    public WorkoutExerciseRequest() {
    }

    public Long getExerciseNo() {
        return exerciseNo;
    }

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public List<WorkoutSetRequest> getSets() {
        return sets;
    }
}
