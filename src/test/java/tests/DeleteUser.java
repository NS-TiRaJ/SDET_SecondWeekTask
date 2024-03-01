package tests;

import helpers.ResponseWrapper;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pojo.UserModel;

import static helpers.UserObjectBuilder.getAddNewUserModel;

@Epic("Тест ID 4")
public class DeleteUser extends BaseTest {
    @Test(description = "Удаление пользователя по ID")
    @Feature("Удаление пользователя по ID")
    public void deleteUser() {
        SoftAssert softAssert = new SoftAssert();
        UserModel request = getAddNewUserModel();
        ResponseWrapper createNewUser = steps.CreateUser(request);
        String id = createNewUser.getIdCreatedUser();
        ResponseWrapper deleteUser = steps.deleteUserById(id);
        //Блок проверок на статус код
        softAssert.assertEquals(deleteUser.getStatusCode(), 204);
        softAssert.assertNotEquals(deleteUser.getStatusCode(), 400, "Bad Request");
        softAssert.assertNotEquals(deleteUser.getStatusCode(), 500, "Internal Server Error");
    }

}
