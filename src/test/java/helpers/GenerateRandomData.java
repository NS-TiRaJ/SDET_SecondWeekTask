package helpers;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс с генерацией рандомных значений
 */
public class GenerateRandomData {
    private static final Faker faker = new Faker();
    /**
     * Генерация значения строки для Title
     */
    public static String generateRandomTitle() { // Генерация значения для Title
        return faker.name().name();
    }
    /**
     * Генерация значения AdditionalNumbers
     */
    public static int generateRandomAdditionalNumbers() { //Генерация значения для AdditionalNumbers
        return faker.number().numberBetween(0, 999);
    }
    /**
     * Генерация строки для AdditionalInfo
     */
    public static String generateRandomAdditionalInfo() {
        return faker.job().title();
    }
    /**
     * Функция генерации случайных значений ImportNumbers
     */
    public static List<Integer> generateRandomImportantNumbers() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int randomNumber = faker.number().numberBetween(0, 100);
            list.add(randomNumber);
        }
        return list;
    }
    /**
     * Генерация значения True/False для VerifiedStatus
     */
    public static boolean generateRandomVerifiedStatus() {
        return faker.bool().bool();
    }
}
