package tests;

import helpers.BaseConfig;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeMethod;
import steps.Steps;

/**
 * Класс с параметрами базовой конфигурации
 */

public class BaseTest {

    private final BaseConfig config = ConfigFactory.create(BaseConfig.class, System.getenv());

    protected final Steps steps = new Steps(getRequestSpecification());
@BeforeMethod
    private RequestSpecification getRequestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(config.url())
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .addFilter(new AllureRestAssured())
                .log(LogDetail.ALL)
                .build();
    }
}