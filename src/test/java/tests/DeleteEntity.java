package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pojo.EntityModel;

import static helpers.EntityObjectBuilder.addNewEntityModel;

@Epic("Тест ID 4")
public class DeleteEntity extends BaseTest {
    @Test(description = "Удаление сущности по ID")
    @Feature("Удаление сущности по ID")
    public void deleteUser() {
        SoftAssert softAssert = new SoftAssert();
        EntityModel request = addNewEntityModel();
        Response createEntity = create.createEntity(request);
        String id = createEntity.getBody().asString();
        Response deleteUser = delete.deleteEntityById(id);
        System.out.println("id удаленной сущности"+id);
        /**
          Проверки на статус код
         */
        softAssert.assertEquals(deleteUser.getStatusCode(), 204);
        softAssert.assertNotEquals(deleteUser.getStatusCode(), 400, "Bad Request");
        softAssert.assertNotEquals(deleteUser.getStatusCode(), 500, "Internal Server Error");
    }

}
