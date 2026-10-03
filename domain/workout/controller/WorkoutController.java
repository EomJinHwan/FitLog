package Spring.FitLog.domain.workout.controller;

import Spring.FitLog.domain.workout.dto.WorkoutCreateRequest;
import Spring.FitLog.domain.workout.dto.WorkoutCreateResponse;
import Spring.FitLog.domain.workout.dto.WorkoutDetailResponse;
import Spring.FitLog.domain.workout.dto.WorkoutListResponse;
import Spring.FitLog.domain.workout.service.WorkoutService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/workouts")
public class WorkoutController {

    private final WorkoutService service;

    public WorkoutController(WorkoutService service) {
        this.service = service;
    }

    // 운동 기록 등록
    @PostMapping
    public WorkoutCreateResponse createResponse(@RequestBody WorkoutCreateRequest request, Authentication authentication) {

        String userId = authentication.getName();
        return service.createWorkout(userId, request);
    }

    // 내 운동 기록 목록 보기
    @GetMapping
    public List<WorkoutListResponse> findMyWorkouts(Authentication authentication) {
        String userId = authentication.getName();

        return service.findMyWorkouts(userId);
    }

    // 내 운동 기록 상세 보기
    @GetMapping("/{workoutLogNo}")
    public WorkoutDetailResponse findDetailWorkouts(Authentication authentication, @PathVariable Long workoutLogNo) {
        String userId = authentication.getName();

        return service.findDetailWorkouts(userId, workoutLogNo);
    }

    // 날짜 별 운동 기록 보기
    @GetMapping("/date")
    public List<WorkoutDetailResponse> findByDate(Authentication authentication, @RequestParam LocalDate workoutDate) {
        String userId = authentication.getName();

        return service.findByDate(userId, workoutDate);
    }

    // 월 별 운동 기록 보기
    @GetMapping("/month")
    public List<WorkoutListResponse> findByMonth(Authentication authentication, @RequestParam int year, @RequestParam int month) {
        String userId = authentication.getName();

        return service.findByMonth(userId, year, month);
    }

    // 내 운동 기록 삭제
    @DeleteMapping("/{workoutLogNo}")
    public String deleteWorkoutLog(Authentication authentication, @PathVariable Long workoutLogNo) {
        String userId = authentication.getName();

        service.deleteWorkoutLog(userId, workoutLogNo);

        return "운동 기록 삭제가 완료되었습니다";
    }
}
