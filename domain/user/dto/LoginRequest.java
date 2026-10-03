package Spring.FitLog.domain.user.dto;

public class LoginRequest {

    private String userId;
    private String userPw;

    public LoginRequest() {
    }

    public String getUserId() {
        return userId;
    }

    public String getUserPw() {
        return userPw;
    }
}
