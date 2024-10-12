package com.example.englishlessions.AccountSetup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.englishlessions.R;
import com.example.englishlessions.Welcome;

import java.util.Arrays;
import java.util.List;

public class AccountSetup3 extends AppCompatActivity {

    private ItemListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_account_setup2);

        ListView listView = findViewById(R.id.listView);

        List<String> items = Arrays.asList(
                "I'm a beginner",
                "I known some words & phrases",
                "I can have simple conversations",
                "I'm intermediate or higher"
        );
        adapter = new ItemListAdapter(this, items);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                adapter.toggleSelection(position);
            }
        });

        Button backBtn = findViewById(R.id.backButton);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        String countryItem = getIntent().getStringExtra("country_item");


        TextView noteText = findViewById(R.id.noteText);
        noteText.setText("How much do you know " + countryItem + "?");

        Button contBtn = findViewById(R.id.continueButton);
        contBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> selectedItems = adapter.getSelectedItems();
                if (!selectedItems.isEmpty()) {
                    Intent intent = new Intent(AccountSetup3.this, AccountSetup5.class);
                    intent.putExtra("country_item", countryItem);
                    startActivity(intent);
                }
            }
        });
    }
}