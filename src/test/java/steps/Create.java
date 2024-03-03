package steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.EntityModel;

import static io.restassured.RestAssured.given;

/**
 * Класс с POST запросами
 */
public class Create {
    private final RequestSpecification requestSpecification;
    public Create(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    /**
     * Запрос на создание сущности
     */
    @Step("Создание сущности")
    public Response createEntity(EntityModel request) {
        return given(requestSpecification)
                .when()
                .body(request)
                .post("create")
                .andReturn();
    }
}
