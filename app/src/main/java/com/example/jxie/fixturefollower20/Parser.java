package com.example.jxie.fixturefollower20;

import android.support.v7.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jason on 3/18/2017.
 */

public class Parser extends AppCompatActivity{

    public Parser() {
    }

    public void Parse(int thisID) {

        final RequestQueue requestQueue = Volley.newRequestQueue(Parser.this);
        String teamid = Integer.toString(thisID);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://api.football-data.org/v1/teams/" + teamid + "/fixtures?timeFrame=n7",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("this is Response!!");
                        //System.out.println(response);
                        try {
                            JSONObject responseObject = new JSONObject(response);
                            //System.out.println(responseObject);
                            //System.out.println(responseObject instanceof JSONObject);
                            Parser p = new Parser();
                            p.ParseHelper(responseObject);
                        }
                        catch(JSONException e){
                            throw new RuntimeException(e);
                        }

                        requestQueue.stop();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        System.out.println("this is Error!!");
                        System.out.println(error);
                        requestQueue.stop();
                    }
                }
        ){
            @Override
            public Map<String,String> getHeaders() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                params.put("X-Auth-Token","c3bde62900244ca8ab734f01650d1f95");
                params.put("X-Response-Control","full");
                return params;
            }
        };
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(10000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue.add(stringRequest);
    }

    public void ParseHelper(JSONObject thisObject){

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
