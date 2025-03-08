package com.monefy.api.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PetApiTests {

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    @Test
    public void testCreatePet() {
        String petJson = "{"
                + "\"id\": 12345,"
                + "\"name\": \"Buddy\","
                + "\"category\": {\"id\": 1, \"name\": \"Dogs\"},"
                + "\"tags\": [{\"id\": 1, \"name\": \"friendly\"}],"  
                + "\"status\": \"available\""
                + "}";

        given()
            .contentType(ContentType.JSON)
            .body(petJson)
        .when()
            .post("/pet")
        .then()
            .assertThat()
            .statusCode(200)
            .body("name", equalTo("Buddy"));
    }

    @Test
    public void testGetPet() {
        given()
            .contentType(ContentType.JSON)
        .when()
            .get("/pet/12345")
        .then()
            .assertThat()
            .statusCode(200)
            .body("id", equalTo(12345));
    }

    @Test
    public void testUpdatePet() {
        String updatedPetJson = "{"
                + "\"id\": 12345,"
                + "\"name\": \"Max\","
                + "\"category\": {\"id\": 1, \"name\": \"Dogs\"},"
                + "\"tags\": [{\"id\": 1, \"name\": \"friendly\"}],"  
                + "\"status\": \"sold\""
                + "}";

        given()
            .contentType(ContentType.JSON)
            .body(updatedPetJson)
        .when()
            .put("/pet")
        .then()
            .assertThat()
            .statusCode(200)
            .body("name", equalTo("Max"));
    }

    @Test
    public void testDeletePet() {
        // Delete with required API key header
        given()
            .header("api_key", "special-key")
            .contentType(ContentType.JSON)
        .when()
            .delete("/pet/12345")
        .then()
            .assertThat()
            .statusCode(200);

        // Verify deletion
        given()
            .contentType(ContentType.JSON)
        .when()
            .get("/pet/12345")
        .then()
            .assertThat()
            .statusCode(404);
    }
}
