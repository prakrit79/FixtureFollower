package com.example.jxie.fixturefollower20;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import static com.example.jxie.fixturefollower20.R.id.spinner;


public class HomeActivity extends AppCompatActivity {

    public Spinner hSpinner;
    public static int id = 0;
    public static String selection;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        hSpinner = (Spinner) findViewById(R.id.spinner2);
        hSpinner.setEnabled(true);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.teams, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hSpinner.setAdapter(adapter);


        hSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long cid)
            {
                String selectedItem = parent.getItemAtPosition(position).toString();
                selection = selectedItem;
                final Intent intent = new Intent(HomeActivity.this, MapsActivity.class);
                id = 0;

                if(selectedItem.equals("Arsenal FC"))
                {
                    id = 57;
                    System.out.print(id);
                    startActivity(intent);
                }
                if(selectedItem.equals("AFC Bournemouth"))
                {
                    id = 1044;
                    System.out.print(id);
                    startActivity(intent);
                }

                if(selectedItem.equals("Chelsea FC"))
                {
                    id = 61;
                    System.out.print(id);
                    startActivity(intent);
                }

                if(selectedItem.equals("Crystal Palace"))
                {
                    id = 354;
                    startActivity(intent);
                }
                if(selectedItem.equals("Everton FC"))
                {
                    id = 62;
                    startActivity(intent);
                }
                if(selectedItem.equals("Leicester City"))
                {
                    id = 338;
                    startActivity(intent);
                }
                if(selectedItem.equals("Liverpool FC"))
                {
                    id = 64;
                    startActivity(intent);
                }
                if(selectedItem.equals("Manchester City"))
                {
                    id = 65;
                    startActivity(intent);
                }
                if(selectedItem.equals("Manchester United"))
                {
                    id = 66;
                    startActivity(intent);
                }
                if(selectedItem.equals("Southampton FC"))
                {
                    id = 340;
                    startActivity(intent);
                }
                if(selectedItem.equals("Stoke City"))
                {
                    id = 70;
                    startActivity(intent);
                }
                if(selectedItem.equals("Sunderland AFC"))
                {
                    id = 71;
                    startActivity(intent);
                }
                if(selectedItem.equals("Swansea City"))
                {
                    id = 72;
                    startActivity(intent);
                }
                if(selectedItem.equals("Tottenham Hotspur"))
                {
                    id = 73;
                    startActivity(intent);
                }
                if(selectedItem.equals("Watford FC"))
                {
                    id = 346;
                    startActivity(intent);
                }
                if(selectedItem.equals("West Bromwich Albion"))
                {
                    id = 74;
                    startActivity(intent);
                }
                if(selectedItem.equals("West Ham United"))
                {
                    id = 563;
                    startActivity(intent);
                }

            } // to close the onItemSelected
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });

    }

}
