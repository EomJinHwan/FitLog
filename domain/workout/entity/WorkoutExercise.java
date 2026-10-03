package Spring.FitLog.domain.workout.entity;

import Spring.FitLog.domain.exercise.entity.Exercise;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "workout_exercises")
public class WorkoutExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long workoutExerciseNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workout_log_no")
    private WorkoutLog workoutLog;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exercise_no")
    private Exercise exercise;

    private Integer orderIndex;

    @OneToMany(mappedBy = "workoutExercise", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WorkoutSet> workoutSets = new ArrayList<>();

    public WorkoutExercise() {
    }

    public WorkoutExercise(Exercise exercise, Integer orderIndex) {
        this.exercise = exercise;
        this.orderIndex = orderIndex;
    }

    public Long getWorkoutExerciseNo() {
        return workoutExerciseNo;
    }

    public WorkoutLog getWorkoutLog() {
        return workoutLog;
    }

    public void setWorkoutLog(WorkoutLog workoutLog) {
        this.workoutLog = workoutLog;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public List<WorkoutSet> getWorkoutSets() {
        return workoutSets;
    }

    public void addWorkoutSet(WorkoutSet workoutSet) {
        workoutSets.add(workoutSet);
        workoutSet.setWorkoutExercise(this);
    }

}
