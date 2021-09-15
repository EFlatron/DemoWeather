package com.ua.weather.service.impl;

import com.ua.weather.entity.Weather;
import com.ua.weather.repository.WeatherRepository;
import com.ua.weather.service.WeatherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService {
    private final WeatherRepository weatherRepository;

    public WeatherServiceImpl(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    @Override
    public void saveWeather(Weather weather) {
        weatherRepository.save(weather);
    }

    @Override
    public List<Weather> getAllWeather() {
        return (List<Weather>) weatherRepository.findAll();
    }

    @Override
    public void deleteWeather(Long id) {
        weatherRepository.deleteById(id);
    }

}
