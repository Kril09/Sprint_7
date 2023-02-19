package TestApi;

import http.Order;
import http.OrderCustomer;
import http.RandomOrder;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

public class NewOrdersPositiveTest {
    OrderCustomer orderCustomer = new OrderCustomer();
    Order order = new RandomOrder(null);

    @Test
    public void newOrder() {
        orderCustomer.newOrder(order)
                .then().assertThat().statusCode(201)
                .and()
                .body("track", notNullValue());
    }
}
