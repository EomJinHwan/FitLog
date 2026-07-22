package Spring.FitLog.domain.workout.controller;

import Spring.FitLog.domain.workout.dto.WorkoutCreateRequest;
import Spring.FitLog.domain.workout.dto.WorkoutCreateResponse;
import Spring.FitLog.domain.workout.dto.WorkoutListResponse;
import Spring.FitLog.domain.workout.service.WorkoutService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workouts")
public class WorkoutController {

    private final WorkoutService service;

    public WorkoutController(WorkoutService service) {
        this.service = service;
    }

    @PostMapping
    public WorkoutCreateResponse createResponse(@RequestBody WorkoutCreateRequest request, Authentication authentication) {

        String userId = authentication.getName();
        return service.createWorkout(userId, request);
    }

    @GetMapping
    public List<WorkoutListResponse> findMyWorkouts(Authentication authentication) {
        String userId = authentication.getName();

        return service.findMyWorkouts(userId);
    }
}
