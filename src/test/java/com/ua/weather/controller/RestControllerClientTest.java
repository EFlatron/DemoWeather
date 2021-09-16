package com.ua.weather.controller;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

class RestControllerClientTest {

    private static final String url = "http://localhost:8080/";

    @Test
    void getCurrentWeatherBySearch() {
        given()
            .baseUri(url)
            .basePath("current-weather-by-location?lat=1&lon=2")
            .contentType(ContentType.JSON)
        .when()
            .get("?lat={lat}&lon={lon}","1", "2")
        .then()
            .statusCode(200);
    }

    @Test
    void getCurrentWeatherByLocation() {
        given()
            .baseUri(url)
            .basePath("current-weather?city=Kharkiv")
            .contentType(ContentType.JSON)
         .when()
            .get("?city={cityName}","Kharkiv")
         .then()
            .statusCode(200);
    }

    @Test
    void getForecastWeatherBySearch() {
        given()
            .baseUri(url)
            .basePath("forecast-weather?city=Kharkiv")
            .contentType(ContentType.JSON)
        .when()
            .get("?city={cityName}","Kharkiv")
        .then()
            .statusCode(200);
    }

    @Test
    void getForecastWeatherByLocation() {
        given()
            .baseUri(url)
            .basePath("forecast-weather-by-location?lat=1&lon=2")
            .contentType(ContentType.JSON)
        .when()
            .get("?lat={lat}&lon={lon}","1", "2")
        .then()
            .statusCode(200);
    }
}

