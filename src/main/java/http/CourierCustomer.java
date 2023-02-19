package http;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class CourierCustomer {
    public CourierCustomer() {
        RestAssured.baseURI = "https://qa-scooter.praktikum-services.ru";
    }

    @Step
    @Description("base handle courier create /api/v1/courier")
    public Response newCourier(Courier courier) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(courier)
                .when()
                .post("/api/v1/courier");
    }

    @Step
    @Description("base handle courier login /api/v1/courier/login")
    public Response loginCourier(Courier courier) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(courier)
                .when()
                .post("/api/v1/courier/login");
    }

    @Step
    @Description("handle courier delete")
    public void deleteCourier(Courier courier) {
        try {
            int id = loginCourier(courier).then().extract().path("id");
            given()
                    .header("Content-type", "application/json")
                    .and()
                    .body(courier)
                    .when()
                    .delete("/api/v1/courier/"+id);
        }

        catch (NullPointerException e){
            System.out.println("Nothing to delete after test");
        }
    }
}
