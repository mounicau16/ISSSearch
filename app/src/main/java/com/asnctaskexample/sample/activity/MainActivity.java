package com.asnctaskexample.sample.activity;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.asnctaskexample.sample.iss_search.R;
import com.asnctaskexample.sample.services.IssPassService;

public class MainActivity extends AppCompatActivity {
    Button currentLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setContentView(R.layout.activity_main);
        currentLocation = (Button)findViewById(R.id.currentLocation);

        //Create Button for Current Location
        currentLocation.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //When we click Current Location Buton it will go to another activity.
                Intent i = new Intent(MainActivity.this, ISSPassActivity.class);
                startActivity(i);

            }
        });
    }

    public void toast(String msg){
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }
}
