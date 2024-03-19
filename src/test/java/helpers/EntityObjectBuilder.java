package helpers;

import pojo.entityModel;

import java.util.List;

/**
 * Метод для формирования тела запроса
 */
public class UserObjectBuilder {
    public static entityModel getAddNewUserModel() {
        return entityModel.builder()
                .addition(entityModel.Addition.builder()
                        .additionalInfo(GenerateRandomData.generateRandomAdditionalInfo())
                        .additionalNumber(GenerateRandomData.generateRandomAdditionalNumbers())
                        .build())
                .importantNumbers(List.of(GenerateRandomData.generateRandomImportantNumbers().toArray(new Integer[0])))
                .title(GenerateRandomData.generateRandomName())
                .verified(GenerateRandomData.generateRandomVerifiedStatus())
                .build();
    }
}
