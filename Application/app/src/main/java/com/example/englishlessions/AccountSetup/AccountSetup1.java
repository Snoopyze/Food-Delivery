package com.example.englishlessions.AccountSetup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.englishlessions.R;
import com.example.englishlessions.Welcome;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccountSetup1 extends AppCompatActivity {
    private ItemListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_setup1);

        ListView listView = findViewById(R.id.listView);
        Button contBtn = findViewById(R.id.continueButton);

        List<String> items = Arrays.asList("TV", "Friends/Family", "Youtube", "Tiktok", "Google Search", "App Store");
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

        contBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> selectedItems = adapter.getSelectedItems();
                if (!selectedItems.isEmpty()) {

                    Intent intent = new Intent(AccountSetup1.this, AccountSetup2.class);
                    intent.putStringArrayListExtra("selected_items", (ArrayList<String>) selectedItems);
                    startActivity(intent);
                }
            }
        });
    }
}