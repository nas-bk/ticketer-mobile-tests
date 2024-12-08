package models;

import lombok.Data;

@Data
public class SettingsModel {
    String baseUrl;
    String deviceId;
    String key;
    String parkId;
    EmployeeModel employee;
}
