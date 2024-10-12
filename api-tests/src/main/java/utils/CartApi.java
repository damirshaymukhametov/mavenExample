package utils;

import io.restassured.response.Response;
import schemas.ProductRequest;

public class CartApi {
    public Response getCart(String token) {
        return RestApiBuilder.given()
                .baseUri(Urls.CART_ENDPOINT)
                .header("Authorization", "Bearer " + token)
                .get();
    }

    public Response addProductToCart(String token, ProductRequest requestBody) {
        return RestApiBuilder.given()
                .baseUri(Urls.CART_ENDPOINT)
                .header("Authorization", "Bearer " + token)
                .body(requestBody)
                .post();
    }

    public Response addProductToCartUnauthorized(ProductRequest requestBody) {
        return RestApiBuilder.given()
                .baseUri(Urls.CART_ENDPOINT)
                .body(requestBody)
                .post();
    }

    public Response removeProductFromCart(String token, int productId) {
        return RestApiBuilder.given()
                .baseUri(Urls.CART_ENDPOINT + "/" + productId)
                .header("Authorization", "Bearer " + token)
                .delete();
    }
}