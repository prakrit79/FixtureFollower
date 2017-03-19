package com.example.jxie.fixturefollower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class MapOverlapActivity extends AppCompatActivity{

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_overlap);

        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        spinner.setEnabled(true);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.matchdays, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

}
