package com.example.tutorial06;

public class Weather {

    private int weatherID;
    private String cityName;
    private Double cityTemperature;
    private String mainDayStatus;
    private String descDayStatus;

    public Weather(){}

    public Weather(int weatherID, String cityName, Double cityTemperature, String mainDayStatus, String descDayStatus) {
        this.weatherID = weatherID;
        this.cityName = cityName;
        this.cityTemperature = cityTemperature;
        this.mainDayStatus = mainDayStatus;
        this.descDayStatus = descDayStatus;
    }

    public Weather(String cityName, Double cityTemperature, String mainDayStatus, String descDayStatus) {
        this.cityName = cityName;
        this.cityTemperature = cityTemperature;
        this.mainDayStatus = mainDayStatus;
        this.descDayStatus = descDayStatus;
    }

    public int getWeatherID() {
        return weatherID;
    }

    public void setWeatherID(int weatherID) {
        this.weatherID = weatherID;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Double getCityTemperature() {
        return cityTemperature;
    }

    public void setCityTemperature(Double cityTemperature) {
        this.cityTemperature = cityTemperature;
    }

    public String getMainDayStatus() {
        return mainDayStatus;
    }

    public void setMainDayStatus(String mainDayStatus) {
        this.mainDayStatus = mainDayStatus;
    }

    public String getDescDayStatus() {
        return descDayStatus;
    }

    public void setDescDayStatus(String descDayStatus) {
        this.descDayStatus = descDayStatus;
    }
}
