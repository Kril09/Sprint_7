package TestApi;

import http.Order;
import http.OrderCustomer;
import http.RandomOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.hamcrest.CoreMatchers.notNullValue;

@RunWith(Parameterized.class)
public class NewOrdersParameterizedTest {
    private final Order order;
    OrderCustomer orderCustomer = new OrderCustomer();
    public NewOrdersParameterizedTest(Order order) {
        this.order = order;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {new RandomOrder(new String[]{"BLACK"})},
                {new RandomOrder(new String[]{"GREY"})},
                {new RandomOrder(new String[]{"BLACK", "GREY"})},
                {new RandomOrder(null)},
        };
    }

    @Test
    public void newOrder() {
        orderCustomer.newOrder(order)
                .then().assertThat().statusCode(201)
                .and()
                .body("track", notNullValue());
    }
}
