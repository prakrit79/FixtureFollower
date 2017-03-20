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

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private Spinner mSpinner;

    Parser parser;

    String location = HomeActivity.selection;
    int tid = HomeActivity.id;

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
    

    
    public LatLng getLocation(String selectedItem){
        LatLng cur = null;
        if(selectedItem.equals("Arsenal FC"))
        {
            cur = arsenal;
        }
        if(selectedItem.equals("AFC Bournemouth"))
        {
            cur = bournemouth;
        }

        if(selectedItem.equals("Chelsea FC"))
        {
            cur = chelsea;
        }

        if(selectedItem.equals("Crystal Palace"))
        {
            cur = cp;
        }
        if(selectedItem.equals("Everton FC"))
        {
            cur = everton;
        }
        if(selectedItem.equals("Leicester City"))
        {
            cur = leiceister;
        }
        if(selectedItem.equals("Liverpool FC"))
        {
            cur = liverpool;
        }
        if(selectedItem.equals("Manchester City"))
        {
            cur = mancity;
        }
        if(selectedItem.equals("Manchester United"))
        {
            cur = manu;
        }
        if(selectedItem.equals("Southampton FC"))
        {
            cur = south;
        }
        if(selectedItem.equals("Stoke City"))
        {
            cur = stoke;
        }
        if(selectedItem.equals("Sunderland AFC"))
        {
            cur = sunder;
        }
        if(selectedItem.equals("Swansea City"))
        {
            cur = swansea;
        }
        if(selectedItem.equals("Tottenham Hotspur"))
        {
            cur = tottenham;
        }
        if(selectedItem.equals("Watford FC"))
        {
            cur = watford;
        }
        if(selectedItem.equals("West Bromwich Albion"))
        {
            cur = westbrom;
        }
        if(selectedItem.equals("West Ham United"))
        {
            cur = westham;
        }
        return cur; 
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        mSpinner = (Spinner)findViewById(R.id.spinner);
        mSpinner.setEnabled(true);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.matchdays, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(adapter);

//        mSpinner.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                selection = mSpinner.getSelectedItem().toString();
//
//            }
//        });
    }

//
//    public void onClick(View v){
//        selection = mSpinner.getSelectedItem().toString();
//    }
//

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
        LatLng current = getLocation(location);
        // Add a marker in Sydney and move the camera
        mMap.addMarker(new MarkerOptions().position(current).title(location.toString()));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(current));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(current,6));
    }
}
