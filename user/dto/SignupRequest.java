package Spring.FitLog.domain.user.dto;

public class SignupRequest {

    private String userId;
    private String userPw;
    private String userName;
    private Integer userAge;
    private Double userHeight;
    private Double userWeight;

    public SignupRequest() {
    }

    public String getUserId() {
        return userId;
    }

    public String getUserPw() {
        return userPw;
    }

    public String getUserName() {
        return userName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public Double getUserHeight() {
        return userHeight;
    }

    public Double getUserWeight() {
        return userWeight;
    }
}
