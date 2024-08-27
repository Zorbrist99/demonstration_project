package tests.api.models;

import lombok.Data;

import java.util.List;

@Data
public class BadRequestLoginResponseModel {
    Boolean success;
    String error, message;
    List<Errors> errors;

    @Data
    public static class Errors {
        String message, param, value;
    }
}
