package com.example.jxie.fixturefollower20;

import android.os.AsyncTask;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import android.text.Html;
import android.view.View;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;

/**
 * Created by jason on 3/18/2017.
 */

public class Parser{

    public void Parse(JSONObject thisObject) {
        //System.out.println(thisObject);
        try {
            JSONArray fixtures = (JSONArray) thisObject.get("fixtures");
            System.out.println(fixtures);

            for (int i = 0 ; i < fixtures.length() ; i++){
                JSONObject obj = fixtures.getJSONObject(i);
                String hometeamName = obj.get("homeTeamName").toString();
                String awayteamName = obj.get("awayTeamName").toString();
                String date = obj.get("date").toString();


                System.out.print(hometeamName);
                System.out.print(awayteamName);
                System.out.print(date);

                //System.out.print(hometeamName);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
