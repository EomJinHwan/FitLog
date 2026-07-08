package Spring.FitLog.domain.user.controller;

import Spring.FitLog.domain.user.dto.*;
import Spring.FitLog.domain.user.entity.User;
import Spring.FitLog.domain.user.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    /**
     * 회원가입
     */
    @PostMapping("/auth/signup")
    public SignupResponse signup(@RequestBody SignupRequest request) {
        return service.signup(request.getUserId(),
                request.getUserPw(),
                request.getUserName(),
                request.getUserAge(),
                request.getUserHeight(),
                request.getUserWeight());
    }

    /**
     * 로그인
     */
    @PostMapping("/auth/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return service.login(request.getUserId(),
                request.getUserPw());
    }

    /**
     * 전체 유저 정보 가져오기
     */
    @GetMapping("/users")
    public List<User> findAll() {
        return service.findAll();
    }

    /**
     * 이름으로 유저 정보 가져오기
     */
    @GetMapping("/users/search")
    public List<User> findByUserName(@RequestParam String userName) {
        return service.findByUserName(userName);
    }

    /**
     * 내 정보 가져오기
     */
    @GetMapping("/users/me")
    public UserResponse getMyInfo(Authentication authentication) {
        String userId = authentication.getName();

        return service.getMyInfo(userId);
    }
}
