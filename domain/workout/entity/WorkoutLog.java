package Spring.FitLog.domain.workout.entity;

import Spring.FitLog.domain.user.entity.User;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "workout_logs")
public class WorkoutLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long workoutLogNo;

    private LocalDate workoutDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_no")
    private User user;

    @OneToMany(mappedBy = "workoutLog", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WorkoutExercise> workoutExercises = new ArrayList<>();

    public WorkoutLog() {
    }

    public WorkoutLog(LocalDate workoutDate, User user) {
        this.workoutDate = workoutDate;
        this.user = user;
    }

    public LocalDate getWorkoutDate() {
        return workoutDate;
    }

    public User getUser() {
        return user;
    }

    public List<WorkoutExercise> getWorkoutExercises() {
        return workoutExercises;
    }

    public Long getWorkoutLogNo() {
        return workoutLogNo;
    }

    public void addWorkoutExercise(WorkoutExercise workoutExercise) {
        workoutExercises.add(workoutExercise);
        workoutExercise.setWorkoutLog(this);
    }
}
