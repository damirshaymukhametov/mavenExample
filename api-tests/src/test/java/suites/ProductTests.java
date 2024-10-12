package suites;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import schemas.Product;
import utils.ProductApi;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProductTests {
    private final ProductApi productApi = new ProductApi();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final Random random = new Random();

    @Test
    public void getProductList() throws Exception {
        Response response = productApi.getProducts();

        response.prettyPeek();

        response.then().statusCode(200);
        Product[] products = objectMapper.readValue(response.asString(), Product[].class);
        assertNotNull(products);
    }

    @Test // 405 Undocumented Error: METHOD NOT ALLOWED Тест не работает метод в Свагере не рабочий
    public void addAndGetProductById() throws Exception {
        Product newProduct = new Product("New Product", "Electronics", 12.99, 5);
        Response addResponse = productApi.addProduct(newProduct);
        addResponse.prettyPeek();
        addResponse.then().statusCode(201);

        int productId = addResponse.jsonPath().getInt("id");

        Response getResponse = productApi.getProductById(productId);
        getResponse.prettyPeek();
        getResponse.then().statusCode(200);

        Product product = objectMapper.readValue(getResponse.asString(), Product.class);

        assertNotNull(product);
        assertEquals(newProduct.getName(), product.getName());
        assertEquals(newProduct.getCategory(), product.getCategory());
        assertEquals(newProduct.getPrice(), product.getPrice());
        assertEquals(newProduct.getDiscount(), product.getDiscount());
    }

    @Test
    public void get404ForNonExistentProduct() throws Exception {
        int nonExistentProductId = random.nextInt(100000);

        Response response = productApi.getProductById(nonExistentProductId);
        response.prettyPeek();

        response.then().statusCode(404);

        String responseBody = response.asString();
        JsonNode jsonResponse = objectMapper.readTree(responseBody);
        assertEquals("Product not found", jsonResponse.get("message").asText());
    }
}