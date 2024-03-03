package steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

/**
 * Класс с DELETE запросами
 */
public class Delete {
    private final RequestSpecification requestSpecification;
    public Delete(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    /**
     * Запрос на удаление сущности по ID
     */
    @Step("Удаление сущности по ID")
    public Response deleteEntityById(String id) {
        return (given(requestSpecification)
                .when()
                .delete("delete/" + id)
                .andReturn());
    }
}

