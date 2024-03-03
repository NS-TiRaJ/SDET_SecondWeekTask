package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pojo.EntityModel;

import static helpers.EntityObjectBuilder.addNewEntityModel;

@Epic("Тесты ID 1, ID 2")
public class CreateAndGetNewEntity extends BaseTest {
    /**Создание переменной ID сущности */
    private String id;
    SoftAssert softAssert = new SoftAssert();

    @Test(description = "Создание новой сущности")
    @Feature("Создание новой сущности")
    public void CreateNewEntity() {
        EntityModel request = addNewEntityModel();
        Response createEntity = create.createEntity(request);
        /** Присваивание переменной ID значения из тела ответа*/
        id = createEntity.getBody().asString();
        /**
         * Проверки на статус код
         */
        softAssert.assertEquals(createEntity.getStatusCode(), 200);
        softAssert.assertNotEquals(createEntity.getStatusCode(), 400, "Bad Request");
        softAssert.assertNotEquals(createEntity.getStatusCode(), 500, "Internal Server Error");
    }

    @Test(description = "Поиск сущности по id")
    @Feature("Поиск сущности по id")
    public void findEntityById() {
        Response searchCreatedUser = read.getEntityById(id);
        /** Проверка на то что ID созданного пользователя соответствует найденному */
        Assert.assertEquals(searchCreatedUser.getBody().jsonPath().getString("id"), id);
        /**
         * Проверки на статус код
         */
        softAssert.assertEquals(searchCreatedUser.getStatusCode(), 200);
        softAssert.assertNotEquals(searchCreatedUser.getStatusCode(), 400, "Bad Request");
        softAssert.assertNotEquals(searchCreatedUser.getStatusCode(), 500, "Internal Server Error");
    }

}
