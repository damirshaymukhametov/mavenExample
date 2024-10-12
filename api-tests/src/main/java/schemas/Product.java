package schemas;

import lombok.Data;

@Data
public class Product {

    private int id;
    private String name;
    private String category;
    private double price;
    private int discount;

    public Product() {
    }

    public Product(String name, String category, double price, int discount) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.discount = discount;
    }

}
