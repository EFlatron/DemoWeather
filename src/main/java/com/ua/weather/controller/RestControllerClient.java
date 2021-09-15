package com.ua.weather.controller;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@CrossOrigin("*")
@RestController
public class RestControllerClient {

    @Value("${weather.api.url}")
    private String weatherApi;

    @Value("${weather.api.key}")
    private String weatherApiKey;


    @GetMapping(path = "/current-weather", produces = "application/json")
    public String getCurrentWeatherBySearch(@RequestParam("city") String city) throws URISyntaxException, ClientProtocolException, IOException {
        HttpClient httpclient = HttpClients.createDefault();
        URIBuilder builder = new URIBuilder(weatherApi + "weather");
        builder.setParameter("q", city);
        builder.setParameter("appid", weatherApiKey);
        URI uri = builder.build();
        HttpPost request = new HttpPost(uri);
        HttpResponse response = httpclient.execute(request);
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity);
        System.out.println("Answered!");
        return result;
    }

    @GetMapping(path = "/current-weather-by-location", produces = "application/json")
    public String getCurrentWeatherByLocation(@RequestParam("lat") String lat, @RequestParam("lon") String lon) throws URISyntaxException, ClientProtocolException, IOException {
        HttpClient httpclient = HttpClients.createDefault();
        URIBuilder builder = new URIBuilder(weatherApi + "weather");
        builder.setParameter("lat", lat);
        builder.setParameter("lon", lon);
        builder.setParameter("appid", weatherApiKey);
        URI uri = builder.build();
        HttpPost request = new HttpPost(uri);
        HttpResponse response = httpclient.execute(request);
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity);
        System.out.println("Answered!");
        return result;
    }

    @GetMapping(path = "/forecast-weather", produces = "application/json")
    public String getForecastWeatherBySearch(@RequestParam("city") String city) throws URISyntaxException, ClientProtocolException, IOException {
        HttpClient httpclient = HttpClients.createDefault();
        URIBuilder builder = new URIBuilder(weatherApi + "forecast");
        builder.setParameter("q", city);
        builder.setParameter("appid", weatherApiKey);
        URI uri = builder.build();
        HttpPost request = new HttpPost(uri);
        HttpResponse response = httpclient.execute(request);
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity);
        return result;
    }

    @GetMapping(path = "/forecast-weather-by-location", produces = "application/json")
    public String getForecastWeatherByLocation(@RequestParam("lat") String lat, @RequestParam("lon") String lon) throws URISyntaxException, ClientProtocolException, IOException {
        HttpClient httpclient = HttpClients.createDefault();
        URIBuilder builder = new URIBuilder(weatherApi + "forecast");
        builder.setParameter("lat", lat);
        builder.setParameter("lon", lon);
        builder.setParameter("appid", weatherApiKey);
        URI uri = builder.build();
        HttpPost request = new HttpPost(uri);
        HttpResponse response = httpclient.execute(request);
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity);
        return result;
    }
}
