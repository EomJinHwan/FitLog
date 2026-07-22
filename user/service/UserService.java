package Spring.FitLog.domain.user.service;

import Spring.FitLog.domain.user.dto.LoginResponse;
import Spring.FitLog.domain.user.dto.SignupResponse;
import Spring.FitLog.domain.user.dto.UserResponse;
import Spring.FitLog.domain.user.entity.User;
import Spring.FitLog.domain.user.repository.UserRepository;
import Spring.FitLog.security.jwt.JwtTokenProvider;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public UserService(UserRepository repository, PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    // 회원 가입
    public SignupResponse signup(String userId, String userPw, String userName, Integer userAge, Double userHeight, Double userWeight) {
        validateDuplicatedUser(userId);
        checkPw(userPw);
        // 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(userPw);
        User user = new User(userId, encodedPassword, userName, userAge, userHeight, userWeight);

        repository.save(user);

        return new SignupResponse(userId, userName, "회원가입이 완료되었습니다.");
    }

    // 아이디 중복 검사
    private void validateDuplicatedUser(String id) {
        repository.findByUserId(id).ifPresent(user -> {
            throw new IllegalArgumentException("중복된 아이디 입니다");
        });
    }

    // 비밀번호 검사
    public void checkPw(String userPw) {
        if (userPw.length() < 5) {
            throw new IllegalArgumentException("비밀번호를 5자리 이상으로 해주세요");
        }
    }

    // 로그인
    public LoginResponse login(String userId, String userPw) {
        User user = repository.findByUserId(userId).
                orElseThrow(() -> new IllegalArgumentException("아이디 또는 비밀번호가 일치하지 않습니다"));
        if (!passwordEncoder.matches(userPw, user.getUserPw())) {
            throw new IllegalArgumentException("아이디 또는 비밀번호가 일치하지 않습니다");
        }

        String accessToken = jwtTokenProvider.createAccessToken(
                user.getUserId(),
                user.getRole());

        return new LoginResponse(accessToken);
    }

    // 이름으로 유저 정보 가져오기 - 관리자
    public List<User> findByUserName(String userName) {
        return repository.findByUserName(userName);
    }

    // 전체 유저 정보 가져오기
    public List<User> findAll() {
        return repository.findAll();
    }

    // 내정보 가져오기 - token
    public UserResponse getMyInfo(String userId) {
        User user = repository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다"));

        return new UserResponse(
                user.getUserNo(),
                user.getUserId(),
                user.getUserName(),
                user.getUserAge(),
                user.getUserHeight(),
                user.getUserWeight(),
                user.getRole()
        );
    }

}
