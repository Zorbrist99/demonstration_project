package tests.api.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.ALL;
import static io.restassured.http.ContentType.JSON;

public class SpecRequest {
    public static RequestSpecification userRequestSpec = with()
            .filter(withCustomTemplates())
            .log().body()
            .log().uri()
            .contentType(JSON);

    public static ResponseSpecification userResponseSpec = new ResponseSpecBuilder()
            .log(ALL)
            .build();
}
