package steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
/**
 * Класс с GET запросами
 */
public class Read {
    private final RequestSpecification requestSpecification;
    public Read(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }
    /**
     * Запрос на получение сущности по ID
     */
    @Step("Получение сущности по ID")
    public Response getEntityById(String id) {
        return (given(requestSpecification)
                .when()
                .get("get/" + id)
                .andReturn());
    }
    /**
     * Запрос на получение списка всех сущностей
     */
    @Step("Получение списка всех сущностей")
    public Response showAllEntity() {
        return (given(requestSpecification)
                .when()
                .get("getAll")
                .andReturn());
    }
}
