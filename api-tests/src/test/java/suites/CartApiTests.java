package suites;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import schemas.Cart;
import schemas.LoginRequest;
import schemas.LoginResponse;
import schemas.ProductRequest;
import utils.AuthApi;
import utils.CartApi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CartApiTests {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final AuthApi authApi = new AuthApi();
    private final CartApi cartApi = new CartApi();
    private String token;

    @BeforeEach
    public void setUp() throws JsonProcessingException {
        token = getAuthToken();
    }

    public String getAuthToken() throws JsonProcessingException {
        LoginRequest body = new LoginRequest("string", "string");
        Response response = authApi.loginUser(body);
        response.prettyPeek();
        LoginResponse loginResponse = objectMapper.readValue(response.asString(), LoginResponse.class);
        return loginResponse.getToken();
    }

    @Test
    public void getClientCart() throws Exception {
        Response response = cartApi.getCart(token);
        Cart cartResponse = objectMapper.readValue(response.asString(), Cart.class);

        response.prettyPeek();
        response.then().statusCode(200);
        assertNotNull(cartResponse.getCart());
    }

    @Test
    public void addExistingProductToCart() throws Exception {
        ProductRequest requestBody = new ProductRequest();
        requestBody.setProductId(1);
        requestBody.setQuantity(2);

        Response response = cartApi.addProductToCart(token, requestBody);

        response.prettyPeek();
        String responseBody = response.asString();
        response.then().statusCode(201);
        JsonNode jsonResponse = objectMapper.readTree(responseBody);
        assertEquals("Product added to cart successfully", jsonResponse.get("message").asText());
    }

    @Test
    public void get404ForNonExistentProductInCart() throws JsonProcessingException {
        int nonExistentProductId = 999999;
        ProductRequest requestBody = new ProductRequest();
        requestBody.setProductId(nonExistentProductId);

        Response response = cartApi.addProductToCart(token, requestBody);

        response.prettyPeek();
        assertEquals(404, response.getStatusCode());

        String responseBody = response.asString();
        JsonNode jsonResponse = objectMapper.readTree(responseBody);
        assertEquals("Product not found", jsonResponse.get("message").asText());
    }

    @Test
    public void get401ForUnauthorizedClient() throws JsonProcessingException {
        ProductRequest requestBody = new ProductRequest();
        requestBody.setProductId(1);
        requestBody.setQuantity(2);

        Response response = cartApi.addProductToCartUnauthorized(requestBody);

        response.prettyPeek();
        assertEquals(401, response.getStatusCode());
    }

    @Test
    public void deleteProductFromCart() throws JsonProcessingException {
        ProductRequest requestBody = new ProductRequest();
        requestBody.setProductId(1);
        requestBody.setQuantity(2);

        Response response = cartApi.addProductToCart(token, requestBody);
        response.prettyPeek();

        Response removeResponse = cartApi.removeProductFromCart(token, 1);

        removeResponse.prettyPeek();
        assertEquals(200, removeResponse.getStatusCode());

        String responseBody = removeResponse.asString();
        JsonNode jsonResponse = objectMapper.readTree(responseBody);
        assertEquals("Product removed from cart", jsonResponse.get("message").asText());
    }

    @Test
    public void get404ForNonExistentProduct() throws JsonProcessingException {
        int nonExistentProductId = 999999;

        Response response = cartApi.removeProductFromCart(token, nonExistentProductId);

        response.prettyPeek();
        assertEquals(404, response.getStatusCode());

        String responseBody = response.asString();
        assertEquals("Product not found in cart", objectMapper.readTree(responseBody).get("message").asText());
    }
}