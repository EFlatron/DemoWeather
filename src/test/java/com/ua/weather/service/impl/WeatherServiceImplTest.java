package com.ua.weather.service.impl;

import com.ua.weather.entity.Weather;
import com.ua.weather.repository.WeatherRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WeatherServiceImplTest {

    @Mock
    private WeatherRepository weatherRepository;

    @InjectMocks
    private WeatherServiceImpl weatherService;

    @Test
    public void saveWeather() {
        Weather weather = Weather.builder()
                .build();

        weatherService.saveWeather(weather);

        verify(weatherRepository).save(weather);
    }

    @Test
    public void getAllWeather() {
        Weather weather = Weather.builder()
                .id(1L)
                .build();
        List<Weather> expected = asList(weather);

        when(weatherRepository.findAll()).thenReturn(expected);

        List<Weather> allWeather = weatherService.getAllWeather();

        assertEquals(expected, allWeather);

    }

    @Test
    public void deleteWeather() {
        Weather weather = Weather.builder()
                .build();

        weatherService.deleteWeather(weather.getId());

        verify(weatherRepository).deleteById(weather.getId());

    }
}
