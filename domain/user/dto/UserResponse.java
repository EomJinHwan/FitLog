package Spring.FitLog.domain.user.dto;

public class UserResponse {

    private Long userNo;
    private String userId;
    private String userName;
    private Integer userAge;
    private Double userHeight;
    private Double userWeight;
    private String role;

    public UserResponse(Long userNo, String userId, String userName, Integer userAge, Double userHeight, Double userWeight, String role) {
        this.userNo = userNo;
        this.userId = userId;
        this.userName = userName;
        this.userAge = userAge;
        this.userHeight = userHeight;
        this.userWeight = userWeight;
        this.role = role;
    }

    public Long getUserNo() {
        return userNo;
    }

    public String getUserId() {
        return userId;
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

    public String getRole() {
        return role;
    }
}
