package Spring.FitLog.domain.user.dto;

public class LoginResponse {
    private String tokenType;
    private String accessToken;

    public LoginResponse(String accessToken) {
        this.tokenType = "Bearer";
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public String getAccessToken() {
        return accessToken;
    }
}
