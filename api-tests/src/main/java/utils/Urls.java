package utils;

public class Urls {
    public static final String BASE_URI = "http://9b142cdd34e.vps.myjino.ru:49268";
    public static final String LOGIN_ENDPOINT = BASE_URI + "/login";
    public static final String PRODUCTS_ENDPOINT = BASE_URI + "/products";
    public static final String CART_ENDPOINT = BASE_URI + "/cart";

    public static String getBaseUri() {
        return BASE_URI;
    }
}
