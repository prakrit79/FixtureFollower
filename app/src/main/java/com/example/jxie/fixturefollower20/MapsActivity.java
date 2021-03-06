package com.example.jxie.fixturefollower20;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private Spinner mSpinner;

    int id = HomeActivity.id;

    Parser parser = new Parser();

    String selection = HomeActivity.selection;

    LatLng club_location = null;

    Map<String, LatLng> cities = new HashMap<>();

    LatLng chelsea = new LatLng(51.4816, -0.191034);
    LatLng bournemouth = new LatLng(50.7352, -1.83839);
    LatLng arsenal = new LatLng(51.5549, -0.108436);
    LatLng cp = new LatLng(51.3983, -0.085455);
    LatLng everton = new LatLng(53.4387, -2.96619);
    LatLng leiceister = new LatLng(52.6203, -1.14217);
    LatLng liverpool = new LatLng(53.4308, -2.96096);
    LatLng mancity = new LatLng(53.483, -2.20024);
    LatLng manu = new LatLng(53.4631, -2.29139);
    LatLng south = new LatLng(50.9058, -1.39114);
    LatLng stoke = new LatLng(52.9884, -2.17542);
    LatLng sunder = new LatLng(54.9146, -1.38837);
    LatLng swansea = new LatLng(51.6428, -3.93473);
    LatLng tottenham = new LatLng(50.7352, -1.83839);
    LatLng watford = new LatLng(51.6498, -0.401569);
    LatLng westbrom = new LatLng(52.509, -1.96418);
    LatLng westham = new LatLng(51.5383, -0.016587);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        intializelocations();
        club_location = cities.get(selection);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        mSpinner = (Spinner)findViewById(R.id.spinner);
        mSpinner.setEnabled(true);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.matchdays, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(adapter);

    }

    private void intializelocations() {
        cities.put("Arsenal FC",arsenal);
        cities.put("AFC Bournemouth",bournemouth);
        cities.put("Chelsea FC",chelsea);
        cities.put("Crystal Palace FC",cp);
        cities.put("Everton FC", everton);
        cities.put("Leicester City FC",leiceister);
        cities.put("Liverpool FC",liverpool);
        cities.put("Manchester City",mancity);
        cities.put("Manchester United FC",manu);
        cities.put("Southampton FC",south);
        cities.put("Stoke City FC",stoke);
        cities.put("Sunderland AFC",sunder);
        cities.put("Swansea City FC",swansea);
        cities.put("Tottenham Hotspur FC",tottenham);
        cities.put("Watford FC",watford);
        cities.put("West Bromwich Albion FC",westbrom);
        cities.put("West Ham United FC",westham);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        parser.Parse(id, new CallBack() {
            @Override
            public void OnSuccess(ArrayList<Fixture> fixtures) {
                System.out.println("success!!");
                System.out.println(fixtures);
                for(Fixture fixture: fixtures ){
                    System.out.print(fixture.homeTeamName);
                    LatLng pos = cities.get(fixture.homeTeamName);
                    System.out.println(pos);
                    mMap.addMarker(new MarkerOptions().position(pos).title(fixture.homeTeamName + " VS " + fixture.awayTeamName)
                            .snippet("Matchday: " + fixture.matchday));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(club_location));
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(club_location,6));
                }
            }
            @Override
            public void OnFail(String msg) {
                System.out.println(msg);

            }
        });



    }
}
