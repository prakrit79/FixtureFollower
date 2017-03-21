package com.example.jxie.fixturefollower20;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

/**
 * Created by jason on 3/18/2017.
 */

public class Fixture {
    String homeTeamName;
    String awayTeamName;
    String date;
    String matchday;

    public Fixture(String htm, String atm, String date, String matchday) {
        this.homeTeamName = htm;
        this.awayTeamName = atm;
        this.date = date;
        this.matchday = matchday;
    }
}
