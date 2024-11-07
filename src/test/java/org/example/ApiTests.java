package org.example;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;
import static org.hamcrest.Matchers.equalTo;

public class ApiTests {

    @BeforeTest
    public void config() {
        RestAssured.baseURI = "https://postman-echo.com";
        RestAssured.responseSpecification = expect()
                .body("headers.x-forwarded-proto", equalTo("https"))
                .and().body("headers.x-forwarded-port", equalTo("443"))
                .and().body("headers.host", equalTo("postman-echo.com"))
                .and().body("headers.accept", equalTo("*/*"))
                .and().body("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/11.0.21)"))
                .and().body("headers.accept-encoding", equalTo("gzip,deflate"));
    }

    @Test
    public void testGetRequest() {

        String param1 = "bar1";
        String param2 = "bar2";

        given()
                .queryParam("foo1", param1)
                .queryParam("foo2", param2)
                .expect()
                .spec(responseSpecification)
                .when()
                .get("/get")
                .then()
                .log().body()
                .statusCode(200)
                .body("args.foo1", equalTo(param1))
                .body("args.foo2", equalTo(param2))
                .body("url", equalTo(String.format("https://postman-echo.com/get?foo1=%s&foo2=%s", param1, param2)));
    }

    @Test
    public void testPostRequest() {

        String requestBody = "This is expected to be sent back as part of response body.";

        given()
                .body(requestBody)
                .expect()
                .spec(responseSpecification)
                .when()
                .post("/post")
                .then()
                .log().body()
                .statusCode(200)
                .body("data", equalTo(requestBody))
                .body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    public void testPostDataRequest() {

        given()
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .expect()
                .spec(responseSpecification)
                .when()
                .post("/post")
                .then()
                .log().body()
                .statusCode(200)
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"))
                .body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    public void testPutRequest() {

        String requestBody = "This is expected to be sent back as part of response body.";

        given()
                .body(requestBody)
                .expect()
                .spec(responseSpecification)
                .when()
                .put("/put")
                .then()
                .log().body()
                .statusCode(200)
                .body("data", equalTo(requestBody))
                .body("url", equalTo("https://postman-echo.com/put"));
    }

    @Test
    public void testPatchRequest() {

        String requestBody = "This is expected to be sent back as part of response body.";

        given()
                .body(requestBody)
                .expect()
                .spec(responseSpecification)
                .when()
                .patch("/patch")
                .then()
                .log().body()
                .statusCode(200)
                .body("data", equalTo(requestBody))
                .body("url", equalTo("https://postman-echo.com/patch"));
    }

    @Test
    public void testDeleteRequest() {

        String requestBody = "This is expected to be sent back as part of response body.";

        given()
                .body(requestBody)
                .expect()
                .spec(responseSpecification)
                .when()
                .delete("/delete")
                .then()
                .log().body()
                .statusCode(200)
                .body("data", equalTo(requestBody))
                .body("url", equalTo("https://postman-echo.com/delete"));
    }
}