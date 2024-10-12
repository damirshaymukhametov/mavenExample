package schemas;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LoginResponse {
    private String token;

    @JsonProperty("access_token")
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

