package TestApi;

import http.OrderCustomer;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import java.util.ArrayList;
import static org.hamcrest.Matchers.notNullValue;

public class OrderListTest {
    OrderCustomer orderClient = new OrderCustomer();

    @Test
    @DisplayName("The body of response return list of orders")
    public void getOrderReturnList() {
        orderClient.getOrder()
                .then()
                .body("orders", notNullValue());
    }

    @Test
    @DisplayName("The body of response return list of orders 2 var")
    public void getOrderReturnList1() {
        orderClient.getOrder()
                .then()
                .extract().path("orders")
                .getClass().equals(ArrayList.class);
    }
}
