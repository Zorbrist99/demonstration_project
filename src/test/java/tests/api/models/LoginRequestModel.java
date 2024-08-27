package tests.api.models;

import lombok.Data;

@Data
public class LoginRequestModel {
    String username, password;
}
