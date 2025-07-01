package com.DeepakSalla.tests.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ExampleApiTest {

    @Test
    public void getPostById() {
        Response resp = RestAssured
            .given()
              .baseUri("https://jsonplaceholder.typicode.com")
            .when()
              .get("/posts/1")
            .then()
              .statusCode(200)
              .extract()
              .response();

        int userId = resp.jsonPath().getInt("userId");
        assertThat("userId should be 1", userId, equalTo(1));
    }
}
