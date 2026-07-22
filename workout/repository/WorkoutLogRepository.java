package Spring.FitLog.domain.workout.repository;

import Spring.FitLog.domain.user.entity.User;
import Spring.FitLog.domain.workout.entity.WorkoutLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkoutLogRepository extends JpaRepository<WorkoutLog, Long> {

    List<WorkoutLog> findByUser(User user);
}
