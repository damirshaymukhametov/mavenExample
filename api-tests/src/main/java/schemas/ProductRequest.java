package schemas;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProductRequest {
    @JsonProperty("product_id")
    private int productId;

    private int quantity;
}

