package com.example.android_activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private int count = 0;
    private TextView tvCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvCount = findViewById(R.id.tvCount);
        Button btnCount = findViewById(R.id.btnCount);
        Button btnGoToActivity2 = findViewById(R.id.btnGoToActivity2);
        Button btnGoToActivity3 = findViewById(R.id.btnGoToActivity3);

        if (savedInstanceState != null) {
            count = savedInstanceState.getInt("count", 0);
        } else if (getIntent() != null && getIntent().hasExtra("count")) {
            count = getIntent().getIntExtra("count", 0);
        }
        updateCountDisplay();

        btnCount.setOnClickListener(v -> {
            count++;
            updateCountDisplay();
        });

        btnGoToActivity2.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, HelloActivity.class);
            intent.putExtra("count", count);
            startActivity(intent);
        });

        btnGoToActivity3.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
            intent.putExtra("count", count);
            startActivity(intent);
        });
    }

    @Override
    protected void onNewIntent(@NonNull Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        if (intent.hasExtra("count")) {
            count = intent.getIntExtra("count", count);
            updateCountDisplay();
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count", count);
    }

    private void updateCountDisplay() {
        if (tvCount != null) {
            tvCount.setText(String.valueOf(count));
        }
    }
}