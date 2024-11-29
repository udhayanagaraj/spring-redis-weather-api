package com.api.weather_api.Weather;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WeatherResponse {
    private Location location;
    private Current current;


    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Location {
        private String name;
        private String region;
        private String country;
        private String lat;
        private String lon;
        private String tz_id;
        private String localtime_epoch;
        private String localtime;
    }


    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Current {
        private String temp_c;
        private String temp_f;
        private Condition condition;


        @Getter
        @Setter
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Condition {
            private String text;
            private String icon;
            private String code;
        }

        private String wind_mph;
        private String wind_kph;
        private String wind_degree;
        private String wind_dir;
        private String NNW;
        private String pressure_mb;
        private String pressure_in;
        private String precip_mm;
        private String humidity;
        private String cloud;
        private String feelslike_c;
        private String feelslike_f;
        private String windchill_c;
        private String windchill_f;
        private String heatindex_c;
        private String heatindex_f;
        private String dewpoint_c;
        private String dewpoint_f;
        private String vis_km;
        private String vis_miles;
        private String uv;
        private String gust_mph;
        private String gust_kph;
    }
}
