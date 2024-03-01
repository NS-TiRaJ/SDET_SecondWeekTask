package helpers;

import io.restassured.response.Response;
import lombok.AllArgsConstructor;

/**
 * Класс для работы с телом ответа
 */

@AllArgsConstructor
public class ResponseWrapper {
    private final Response response;

    public int getStatusCode() {
        return response.getStatusCode(); // Получить статус код запроса
    }

    public String getIdCreatedUser() {
        return response.getBody().asString(); // Получение id созданного пользователя из ответа
    }

    public String getUserId() {
        return response.getBody().jsonPath().getString("id"); // Получить id пользователя
    }
}
