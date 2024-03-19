package tests;

import helpers.ResponseWrapper;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pojo.entityModel;

import static helpers.UserObjectBuilder.getAddNewUserModel;

@Epic("Тесты ID 1, ID 2")
public class AddNewUser extends BaseTest {
    private String id; //Переменная для id созданного пользователя
    SoftAssert softAssert = new SoftAssert(); //Создание экземлпяра класса SoftAssert

    @Test(description = "Создание нового пользователя")
    @Story("Создание нового пользователя")
    @Feature("Создание нового пользователя")
    public void addNewUser() {
        entityModel request = getAddNewUserModel();
        ResponseWrapper createNewUser = steps.CreateUser(request);
        //Блок проверок на статус код
        softAssert.assertEquals(createNewUser.getStatusCode(), 200);
        softAssert.assertNotEquals(createNewUser.getStatusCode(), 400, "Bad Request");
        softAssert.assertNotEquals(createNewUser.getStatusCode(), 500, "Internal Server Error");
        id = createNewUser.getIdCreatedUser();
    }

    @Test(description = "Поиск пользователя по id")
    @Feature("Поиск пользователя по id")
    public void findUserById() {
        ResponseWrapper searchCreatedUser = steps.getUserById(id);
        Assert.assertEquals(searchCreatedUser.getUserId(), id); //Проверка на то что ID созданного пользователя соответствует найденному
    }

}
