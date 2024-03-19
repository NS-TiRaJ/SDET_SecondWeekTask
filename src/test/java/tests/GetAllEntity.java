package tests;

import helpers.ResponseWrapper;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Epic("Тест ID 3")
public class GetAllUsers extends BaseTest {
    @Test(description = "Запрос списка всех пользователей")
    @Feature("Запрос списка всех пользователей")
    public void getAllUsers() {
        SoftAssert softAssert = new SoftAssert();
        ResponseWrapper responseWrapper = steps.showAllUsers();
        //Блок проверок на статус код
        softAssert.assertEquals(responseWrapper.getStatusCode(), 200);
        softAssert.assertNotEquals(responseWrapper.getStatusCode(), 400);
        softAssert.assertNotEquals(responseWrapper.getStatusCode(), 500);
    }
}
