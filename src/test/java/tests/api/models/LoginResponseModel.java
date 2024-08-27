package tests.api.models;

import lombok.Data;

@Data
public class LoginResponseModel {
    Boolean success;
    UserData data;
    String appVersion;

    @Data
    public static class UserData {
        String id, apiToken, username;
        Boolean newUser;
    }
}