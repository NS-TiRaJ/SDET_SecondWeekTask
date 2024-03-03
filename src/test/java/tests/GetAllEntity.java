package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Epic("Тест ID 3")
public class GetAllEntity extends BaseTest {
    @Test(description = "Запрос списка всех сущностей")
    @Feature("Запрос списка всех сущностей")
    public void getAllEntity() {
        SoftAssert softAssert = new SoftAssert();
        Response showAllEntity = read.showAllEntity();
        /**
          Проверки на статус код
         */
        softAssert.assertEquals(showAllEntity.getStatusCode(), 200);
        softAssert.assertNotEquals(showAllEntity.getStatusCode(), 400);
        softAssert.assertNotEquals(showAllEntity.getStatusCode(), 500);
    }
}
