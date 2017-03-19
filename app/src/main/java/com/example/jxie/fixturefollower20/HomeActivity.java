package com.example.jxie.fixturefollower20;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class HomeActivity extends AppCompatActivity {
    //Add line
    //You should see this line now dskjndfkjladsklsjdfsklja
    //sadfasdfasdfsd
    private Spinner hSpinner;

    private String selection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Parser parse = new Parser();
        String id;

        hSpinner = (Spinner) findViewById(R.id.spinner2);
        hSpinner.setEnabled(true);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.teams, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hSpinner.setAdapter(adapter);

        switch(selection) {
            case "AFC Bournemouth":
                id = "58";
            case "Arsenal FC":
                id = "563";
//            case "Burnley FC":
//                id = ;
            case "Chelsea FC":
                id = "72";
            case "Crystal Palace":
                id = "61";
            case "Everton FC":
                id  = "346";
//            case "Hull City ":
//                id  = ;
            case "Leicester City":
                id  = "71";
            case "Liverpool FC":
                id  = "74";
            case "Manchester City":
                id  = "65";
            case "Manchester United":
                id  = "73";
//            case "Middlesborough FC":
//                id  = ;
            case "Southampton FC":
                id  = "57";
            case "Stoke City":
                id  = "64";
            case "Sunderland AFC":
                id  = "68";
            case "Swansea City":
                id  = "67";
            case "Totenham Hotspur":
                id  = "1044";
            case "Watford FC":
                id  = "338";
            case "West Bromwich Albion":
                id  = "65";
            case "West Ham United":
                id  = "70";

        }

        hSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selection = hSpinner.getSelectedItem().toString();

            }
        });
    }
}
