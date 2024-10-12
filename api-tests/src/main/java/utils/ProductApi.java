package utils;

import io.restassured.response.Response;
import schemas.Product;

public class ProductApi {
    public Response getProducts() {
        return RestApiBuilder.given()
                .baseUri(Urls.PRODUCTS_ENDPOINT)
                .get();
    }

    public Response getProductById(int productId) {
        return RestApiBuilder.given()
                .baseUri(Urls.PRODUCTS_ENDPOINT + "/" + productId)
                .get();
    }

    public Response addProduct(Product product) {
        return RestApiBuilder.given()
                .baseUri(Urls.PRODUCTS_ENDPOINT)
                .body(product)
                .post()
                .then()
                .extract()
                .response();
    }
}
