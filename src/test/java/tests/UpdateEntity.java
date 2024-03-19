package tests;

import helpers.ResponseWrapper;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pojo.entityModel;

import static helpers.UserObjectBuilder.getAddNewUserModel;

@Epic("Тест ID 5")
public class UpdateUser extends BaseTest {
    @Test(description = "Обновление информации о пользователе по ID")
    @Feature("Обновление информации о пользователе по ID")
    public void updateUser() {
        SoftAssert softAssert = new SoftAssert();
        entityModel request = getAddNewUserModel();
        entityModel update = getAddNewUserModel();
        ResponseWrapper createNewUser = steps.CreateUser(request);
        String id = createNewUser.getIdCreatedUser();
        ResponseWrapper updateCustomer = steps.updateUser(update, id);
        //Блок проверок на статус код
        softAssert.assertEquals(updateCustomer.getStatusCode(), 204);
        softAssert.assertNotEquals(updateCustomer.getStatusCode(), 400);
        softAssert.assertNotEquals(updateCustomer.getStatusCode(), 500);
    }
}
