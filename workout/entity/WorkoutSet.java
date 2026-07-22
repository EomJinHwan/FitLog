package Spring.FitLog.domain.workout.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "workout_sets")
public class WorkoutSet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long workoutSetNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workout_exercise_no")
    private WorkoutExercise workoutExercise;

    private Integer setNumber;

    private Double weight;

    private Integer reps;

    public WorkoutSet() {
    }

    public WorkoutSet(Integer setNumber, Double weight, Integer reps) {
        this.setNumber = setNumber;
        this.weight = weight;
        this.reps = reps;
    }

    public Long getWorkoutSetNo() {
        return workoutSetNo;
    }


    public WorkoutExercise getWorkoutExercise() {
        return workoutExercise;
    }

    public void setWorkoutExercise(WorkoutExercise workoutExercise) {
        this.workoutExercise = workoutExercise;
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
