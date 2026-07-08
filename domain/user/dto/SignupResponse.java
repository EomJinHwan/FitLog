package Spring.FitLog.domain.user.dto;

public class SignupResponse {

    private String userId;
    private String userName;
    private String result;

    public SignupResponse(String userId, String userName, String result) {
        this.userId = userId;
        this.userName = userName;
        this.result = result;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getResult() {
        return result;
    }
}
