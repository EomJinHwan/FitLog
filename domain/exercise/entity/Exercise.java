package Spring.FitLog.domain.exercise.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "exercises")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exerciseNo;

    private String exerciseName;

    @Enumerated(EnumType.STRING)
    private ExerciseType exerciseType;

    @Enumerated(EnumType.STRING)
    private ExercisePart exercisePart;

    public Exercise() {
    }

    public Long getExerciseNo() {
        return exerciseNo;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public ExerciseType getExerciseType() {
        return exerciseType;
    }

    public void setExerciseType(ExerciseType exerciseType) {
        this.exerciseType = exerciseType;
    }

    public ExercisePart getExercisePart() {
        return exercisePart;
    }

    public void setExercisePart(ExercisePart exercisePart) {
        this.exercisePart = exercisePart;
    }

    public Exercise(String exerciseName, ExerciseType exerciseType, ExercisePart exercisePart) {
        this.exerciseName = exerciseName;
        this.exerciseType = exerciseType;
        this.exercisePart = exercisePart;
    }
}
