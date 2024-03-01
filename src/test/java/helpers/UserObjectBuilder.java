package helpers;

import pojo.UserModel;

import java.util.List;

/**
 * Метод для формирования тела запроса
 */
public class UserObjectBuilder {
    public static UserModel getAddNewUserModel() {
        return UserModel.builder()
                .addition(UserModel.Addition.builder()
                        .additionalInfo(GenerateRandomData.generateRandomAdditionalInfo())
                        .additionalNumber(GenerateRandomData.generateRandomAdditionalNumbers())
                        .build())
                .importantNumbers(List.of(GenerateRandomData.generateRandomImportantNumbers().toArray(new Integer[0])))
                .title(GenerateRandomData.generateRandomName())
                .verified(GenerateRandomData.generateRandomVerifiedStatus())
                .build();
    }
}
