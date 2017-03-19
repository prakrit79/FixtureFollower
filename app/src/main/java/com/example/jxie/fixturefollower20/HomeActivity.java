package com.example.jxie.fixturefollower20;

import android.support.v4.app.FragmentActivity;
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

        hSpinner = (Spinner) findViewById(R.id.spinner2);
        hSpinner.setEnabled(true);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.teams, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hSpinner.setAdapter(adapter);

        hSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selection = hSpinner.getSelectedItem().toString();

            }
        });
    }
}
