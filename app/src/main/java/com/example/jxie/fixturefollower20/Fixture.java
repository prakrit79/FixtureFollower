package com.example.jason.fixture20;

import java.util.ArrayList;

/**
 * Created by jason on 3/18/2017.
 */

public class Fixture {
    String homeTeamName;
    String awayTeamName;
    double lat;
    double lon;
    String date;
    int matchday;

    public Fixture(String htm, String atm, double lat, double lon, String date, int matchday) {
        this.homeTeamName = htm;
        this.awayTeamName = atm;
        this.lat = lat;
        this.lon = lon;
        this.date = date;
        this.matchday = matchday;

    }
}
