package helpers;

import pojo.EntityModel;

import java.util.List;

/**
 * Метод для формирования тела запроса
 */
public class EntityObjectBuilder {
    public static EntityModel addNewEntityModel() {
        return EntityModel.builder()
                .addition(EntityModel.Addition.builder()
                        .additionalInfo(GenerateRandomData.generateRandomAdditionalInfo())
                        .additionalNumber(GenerateRandomData.generateRandomAdditionalNumbers())
                        .build())
                .importantNumbers(List.of(GenerateRandomData.generateRandomImportantNumbers().toArray(new Integer[0])))
                .title(GenerateRandomData.generateRandomTitle())
                .verified(GenerateRandomData.generateRandomVerifiedStatus())
                .build();
    }
}
