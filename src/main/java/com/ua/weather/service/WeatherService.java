package com.ua.weather.service;

import com.ua.weather.entity.Weather;

import java.util.List;

public interface WeatherService {
    public void saveWeather(Weather weather);

    List<Weather> getAllWeather();

    public void deleteWeather(Long id);
}
