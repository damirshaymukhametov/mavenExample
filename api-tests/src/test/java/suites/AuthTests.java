package suites;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import schemas.LoginRequest;
import utils.AuthApi;

public class AuthTests {
    AuthApi authApi = new AuthApi();

    @Test
    public void get200AfterLoginUser() {
        LoginRequest body = new LoginRequest("string", "string");

        Response response = authApi.loginUser(body);
        response.prettyPeek();

        response.then().statusCode(200);
        String token = response.jsonPath().getString("token");
    }

    @Test
    public void get401AfterLoginUnregisteredUser() {
        LoginRequest body = new LoginRequest("unregistered_user", "wrong_password");

        Response response = authApi.loginUser(body);
        response.prettyPeek();

        response.then().statusCode(401);
    }

    @Test
    public void get401AfterLoginWithIncorrectPassword() {
        LoginRequest body = new LoginRequest("string", "incorrect_password");

        Response response = authApi.loginUser(body);
        response.prettyPeek();

        response.then().statusCode(401);
    }

}
