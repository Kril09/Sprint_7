package TestApi;

import http.Courier;
import http.CourierCustomer;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;

public class LoginCourierNegativeTest {
    String randomLogin = RandomStringUtils.random(10, true, false);
    String randomPass = RandomStringUtils.random(10, true, true);
    String randomName = RandomStringUtils.random(10, true, false);
    CourierCustomer courierCustomer= new CourierCustomer();
    Courier courier = new Courier(randomLogin, randomPass, randomName);

    @Test
    @DisplayName("Для успешной авторизации нужно передать все обязательные поля;")
    @Description("Если параметра Password нет, запрос возвращает ошибку - Недостаточно данных для входа;")
    public void checkLoginWithoutPasswordReturnFalse() {
        courier = new Courier(randomLogin, "", "");
        courierCustomer.newCourier(courier);
        courierCustomer.loginCourier(courier)
                .then().assertThat().statusCode(400)
                .and().body("message", equalTo("Недостаточно данных для входа"));
    }

    @Test
    @DisplayName("Для успешной авторизации нужно передать все обязательные поля;")
    @Description("Если параметра Login нет, запрос возвращает ошибку - Недостаточно данных для входа;")
    public void checkLoginWithoutLoginReturnFalse() {
        courier = new Courier("", randomPass, "");
        courierCustomer.loginCourier(courier)
                .then().assertThat().statusCode(400)
                .and().body("message", equalTo("Недостаточно данных для входа"));
    }

    @Test
    @DisplayName("Система вернёт ошибку, если неправильно указать логин или пароль;")
    @Description("Если авторизоваться под несуществующим пользователем, запрос возвращает ошибку - Недостаточно данных для входа;")
    public void checkLoginNotExistReturnFalse() {
        courier = new Courier("ooo", "", "");
        courierCustomer.loginCourier(courier)
                .then().assertThat().statusCode(400)
                .and().body("message", equalTo("Недостаточно данных для входа"));
    }

    @After
    public void deleteCourier() {
        courierCustomer.deleteCourier(courier);
    }
}
