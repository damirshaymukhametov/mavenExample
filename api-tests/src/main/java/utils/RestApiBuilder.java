package utils;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class RestApiBuilder {
    public static RequestSpecification given() {
        return RestAssured.given()
                .contentType("application/json")
                .accept("application/json");
    }
}
