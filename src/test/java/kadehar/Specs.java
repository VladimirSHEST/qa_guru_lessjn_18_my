package kadehar;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.aspectj.weaver.ResolvedPointcutDefinition;

import static io.restassured.RestAssured.with;
import static org.hamcrest.Matchers.containsString;

public class Specs {
    public static RequestSpecification request = with()
            .baseUri("https://reqres.in/")
            .basePath("/api")
            .log().all()
            .contentType(ContentType.JSON);

    public static ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
//            .expectBody(containsString("succes"))
            .build();
}
