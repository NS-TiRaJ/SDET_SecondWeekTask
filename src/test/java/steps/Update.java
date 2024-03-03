package steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.EntityModel;

import static io.restassured.RestAssured.given;

/**
 * Класс с UPDATE запросами
 */
public class Update {
    private final RequestSpecification requestSpecification;
    public Update(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }
    /**
     * Запрос на обновление сущности по ID
     */
    @Step("Обновление информации сущности по ID")
    public Response updateEntity(EntityModel request, String id) {
        return (given(requestSpecification)
                .when()
                .body(request)
                .patch("patch/" + id)
                .andReturn());
    }
}
