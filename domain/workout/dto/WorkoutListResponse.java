package Spring.FitLog.domain.workout.dto;

import Spring.FitLog.domain.workout.entity.WorkoutLog;

import java.time.LocalDate;

public class WorkoutListResponse {

    private Long workoutLogNo;
    private LocalDate workoutDate;

    public WorkoutListResponse(WorkoutLog workoutLog) {
        this.workoutLogNo = workoutLog.getWorkoutLogNo();
        this.workoutDate = workoutLog.getWorkoutDate();
    }

    public Long getWorkoutLogNo() {
        return workoutLogNo;
    }

    public LocalDate getWorkoutDate() {
        return workoutDate;
    }
}
