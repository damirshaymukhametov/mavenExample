package utils;

import io.restassured.response.Response;
import schemas.LoginRequest;

public class AuthApi {
    public Response loginUser(LoginRequest body) {
        return RestApiBuilder.given()
                .baseUri(Urls.LOGIN_ENDPOINT)
                .body(body)
                .post();
    }
}