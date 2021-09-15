package com.ua.weather.controller;

import com.ua.weather.entity.Datatables;
import com.ua.weather.entity.Weather;
import com.ua.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class RestDatatables {
    @Autowired
    private WeatherService weatherService;

    @GetMapping("/data-bookmark")
    public ResponseEntity<Datatables> getDataBookmarked() {
        List<List<String>> datatables = new ArrayList<List<String>>();
        Iterable<Weather> weathers = this.weatherService.getAllWeather();
        for (Weather weather : weathers) {
            List<String> array = new ArrayList<String>();
            array.add(weather.getId().toString());
            array.add(weather.getLocation());
            array.add(weather.getTime());
            array.add(weather.getTemperature());
            array.add(weather.getWindSpeed());
            array.add(weather.getCloud());
            array.add(weather.getPressure());
            array.add(weather.getHumidity());
            array.add(weather.getCoordinates());
            datatables.add(array);
        }
        Datatables responseObj = new Datatables();
        responseObj.setData(datatables);
        return new ResponseEntity<Datatables>(responseObj, HttpStatus.OK);
    }

    @PostMapping("/insert-bookmark")
    public String insertData(@RequestParam("locations") String locations,
                             @RequestParam("weather") String weather,
                             @RequestParam("windSpeed") String windSpeed, @RequestParam("cloud") String cloud, @RequestParam("pressures") String pressures,
                             @RequestParam("coordinates") String coordinates, @RequestParam("humidities") String humidities) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        Weather b = Weather.builder()
                .location(locations)
                .time(formatter.format(date))
                .temperature(weather)
                .windSpeed(windSpeed)
                .cloud(cloud)
                .pressure(pressures)
                .humidity(humidities)
                .coordinates(coordinates)
                .build();
        this.weatherService.saveWeather(b);
        return "Save the weather successfully!";
    }

    @PostMapping("/delete-bookmark")
    public String deleteData(@RequestParam("id") String id) {
        this.weatherService.deleteWeather(Long.valueOf(id.trim()));
        return "Delete successfully!";
    }
}
