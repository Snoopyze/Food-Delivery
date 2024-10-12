package com.example.englishlessions.AccountSetup;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.englishlessions.R;
import com.example.englishlessions.Welcome;

public class Loading extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_loading);

        String countryItem = getIntent().getStringExtra("country_item");


        TextView setupText = findViewById(R.id.setupText);
        setupText.setText("Sit tight, we're setting up the " + countryItem + " course for you");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Loading.this, Welcome.class);
                intent.putExtra("country_item", countryItem);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}