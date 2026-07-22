package Spring.FitLog.domain.workout.dto;

import java.time.LocalDate;

public class WorkoutCreateResponse {

    private Long workoutLogNo;
    private LocalDate workoutDate;
    private String message;

    public WorkoutCreateResponse(Long workoutLogNo, LocalDate workoutDate) {
        this.workoutLogNo = workoutLogNo;
        this.workoutDate = workoutDate;
        this.message = "운동 기록 등록 완료";
    }

    public Long getWorkoutLogNo() {
        return workoutLogNo;
    }

    public LocalDate getWorkoutDate() {
        return workoutDate;
    }

    public String getMessage() {
        return message;
    }
}
