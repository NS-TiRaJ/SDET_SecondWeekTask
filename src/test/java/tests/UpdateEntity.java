package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pojo.EntityModel;

import static helpers.EntityObjectBuilder.addNewEntityModel;

@Epic("Тест ID 5")
public class UpdateEntity extends BaseTest {
    @Test(description = "Обновление информации о сущности по ID")
    @Feature("Обновление информации о сущности по ID")
    public void updateUser() {
        SoftAssert softAssert = new SoftAssert();
        EntityModel request = addNewEntityModel();
        EntityModel createNewEntityInfo= addNewEntityModel();
        Response createNewUser = create.createEntity(request);
        String id = createNewUser.getBody().asString();
        Response updateEntity = update.updateEntity(createNewEntityInfo,id);
        /**
          Проверки на статус код
         */
        softAssert.assertEquals(updateEntity.getStatusCode(), 204);
        softAssert.assertNotEquals(updateEntity.getStatusCode(), 400);
        softAssert.assertNotEquals(updateEntity.getStatusCode(), 500);
    }
}
