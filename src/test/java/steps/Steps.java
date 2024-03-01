package steps;

import helpers.ResponseWrapper;
import io.qameta.allure.Step;
import io.restassured.specification.RequestSpecification;
import pojo.UserModel;

import static io.restassured.RestAssured.given;

/**
 * Класс с тестовыми шагами
 */
public class Steps {
    private final RequestSpecification requestSpecification;

    public Steps(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    @Step ("Создание пользователя")
    public ResponseWrapper CreateUser(UserModel request) {
        return new ResponseWrapper(given(requestSpecification)
                .when()
                .body(request)
                .post("create")
                .andReturn());
    }

    @Step ("Получение пользователя по ID")
    public ResponseWrapper getUserById(String id) {
        return new ResponseWrapper(given(requestSpecification)
                .when()
                .get("get/" + id)
                .andReturn());
    }

    @Step ("Удаление пользователя по ID")
    public ResponseWrapper deleteUserById(String id) {
        return new ResponseWrapper(given(requestSpecification)
                .when()
                .delete("delete/" + id)
                .andReturn());
    }

    @Step ("Получение списка всех пользователей")
    public ResponseWrapper showAllUsers() {
        return new ResponseWrapper(given(requestSpecification)
                .when()
                .get("getAll")
                .andReturn());
    }

    @Step ("Обновление информации пользователя по ID")
    public ResponseWrapper updateUser(UserModel request, String id) {
        return new ResponseWrapper(given(requestSpecification)
                .when()
                .body(request)
                .patch("patch/" + id)
                .andReturn());
    }

}
