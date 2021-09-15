package com.ua.weather.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "weather")
@Data
@Builder
public class Weather {
    public Weather(Long id, String location, String time, String temperature, String windSpeed, String cloud, String pressure, String humidity, String coordinates) {
        this.id = id;
        this.location = location;
        this.time = time;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.cloud = cloud;
        this.pressure = pressure;
        this.humidity = humidity;
        this.coordinates = coordinates;
    }

    public Weather() {

    }

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "Location", length = 128, nullable = false)
    private String location;

    @Column(name = "Time", length = 128, nullable = false)
    private String time;

    @Column(name = "Temperature", length = 128, nullable = false)
    private String temperature;

    @Column(name = "WindSpeed", length = 128, nullable = false)
    private String windSpeed;

    @Column(name = "Cloud", length = 128, nullable = false)
    private String cloud;

    @Column(name = "Pressure", length = 128, nullable = false)
    private String pressure;

    @Column(name = "Humidity", length = 128, nullable = false)
    private String humidity;

    @Column(name = "Coordinates", length = 128, nullable = false)
    private String coordinates;
}