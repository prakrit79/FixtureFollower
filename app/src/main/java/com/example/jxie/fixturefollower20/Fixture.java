package com.example.jxie.fixturefollower20;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

/**
 * Created by jason on 3/18/2017.
 */

public class Fixture {
    String homeTeamName;
    String awayTeamName;
    LatLng latlng;
    String date;
    String matchday;

    public Fixture(String htm, String atm, LatLng latlng , String date, String matchday) {
        this.homeTeamName = htm;
        this.awayTeamName = atm;
        this.latlng = latlng;
        this.date = date;
        this.matchday = matchday;
    }
}
