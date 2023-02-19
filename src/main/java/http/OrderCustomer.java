package http;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class OrderCustomer {

    public OrderCustomer() {
        RestAssured.baseURI = "https://qa-scooter.praktikum-services.ru";
    }

    @Step
    @Description("base handle order create api/v1/orders")
    public Response newOrder(Order order){
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(order)
                .when()
                .post("/api/v1/orders");
    }

    @Step
    @Description("base handle GET /api/v1/orders")
    public Response getOrder(){
        return given()
                .get("api/v1/orders");
    }
}
