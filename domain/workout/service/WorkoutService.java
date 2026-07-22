package Spring.FitLog.domain.workout.service;

import Spring.FitLog.domain.exercise.entity.Exercise;
import Spring.FitLog.domain.exercise.repository.ExerciseRepository;
import Spring.FitLog.domain.user.entity.User;
import Spring.FitLog.domain.user.repository.UserRepository;
import Spring.FitLog.domain.workout.dto.*;
import Spring.FitLog.domain.workout.entity.WorkoutExercise;
import Spring.FitLog.domain.workout.entity.WorkoutLog;
import Spring.FitLog.domain.workout.entity.WorkoutSet;
import Spring.FitLog.domain.workout.repository.WorkoutLogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WorkoutService {

    private final WorkoutLogRepository workoutLogRepository;
    private final UserRepository userRepository;
    private final ExerciseRepository exerciseRepository;

    public WorkoutService(WorkoutLogRepository workoutLogRepository, UserRepository userRepository, ExerciseRepository exerciseRepository) {
        this.workoutLogRepository = workoutLogRepository;
        this.userRepository = userRepository;
        this.exerciseRepository = exerciseRepository;
    }

    // 운동 로그 생성
    @Transactional
    public WorkoutCreateResponse createWorkout(String userId, WorkoutCreateRequest request) {
        // 유저 정보 가져오기
        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다"));
        // 운동 기록 생성 - 운동 List 생성
        WorkoutLog workoutLog = new WorkoutLog(
                request.getWorkoutDate(),
                user
        );

        // 리스트에 들어있는 운동 확인
        for (WorkoutExerciseRequest exerciseRequest : request.getExercises()) {
            Exercise exercise = exerciseRepository.findById(exerciseRequest.getExerciseNo())
                    .orElseThrow(() -> new IllegalArgumentException("해당 운동 종목이 없습니다"));

            // 기록에 들어갈 운동 객체 생성
            WorkoutExercise workoutExercise = new WorkoutExercise(
                    exercise,
                    exerciseRequest.getOrderIndex()
            );

            for (WorkoutSetRequest setRequest : exerciseRequest.getSets()) {
                WorkoutSet workoutSet = new WorkoutSet(
                        setRequest.getSetNumber(),
                        setRequest.getWeight(),
                        setRequest.getReps()
                );

                workoutExercise.addWorkoutSet(workoutSet);
            }

            workoutLog.addWorkoutExercise(workoutExercise);
        }

        WorkoutLog savedWorkoutLog = workoutLogRepository.save(workoutLog);

        return new WorkoutCreateResponse(
                savedWorkoutLog.getWorkoutLogNo(),
                savedWorkoutLog.getWorkoutDate()
        );
    }

    // 내 운동 기록 리스트 가져오기
    public List<WorkoutListResponse> findMyWorkouts(String userId) {
        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다"));

        return workoutLogRepository.findByUser(user).stream()
                .map(workoutLog -> new WorkoutListResponse(workoutLog))
                .toList();
    }
}
