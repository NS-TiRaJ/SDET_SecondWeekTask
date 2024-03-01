package helpers;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс с генерацией рандомных значений
 */
public class GenerateRandomData {
    private static  final Faker faker = new Faker(); //Экземпляр класса Faker
    public static String generateRandomName(){ // Генерация значения для Title
       return faker.name().name();
    }
    public static  int generateRandomAdditionalNumbers(){ //Генерация значения для AdditionalNumbers
        return faker.number().numberBetween(0,999);
    }
    public static String generateRandomAdditionalInfo(){return faker.job().title();} //Генерация строки для AdditionalInfo

    public static List<Integer> generateRandomImportantNumbers(){ //Генерация значений для ImportantNumbers
        List<Integer> list = new ArrayList<>();
        for (int i =0;i<3;i++){
            int randomNumber = faker.number().numberBetween(0,100);
            list.add(randomNumber);
        }
        return list;
    }
    public static boolean generateRandomVerifiedStatus(){ //Генерация значения True/False
        return faker.bool().bool();
    }
}
