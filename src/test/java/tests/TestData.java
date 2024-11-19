package tests;

import com.github.javafaker.Faker;

public class TestData {
    Faker faker = new Faker();
    String employeePhone = faker.phoneNumber().subscriberNumber(10);
    String employeePassword = faker.internet().password();

    String baseUrl = "http://127.0.0.1";
    String deviceId = "TK1";
    String apiKey = "9e44e2416-98be-42333";
    String parkId = "DK2";
}
