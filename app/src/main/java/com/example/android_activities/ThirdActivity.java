package com.example.android_activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ThirdActivity extends AppCompatActivity {

    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_third);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView tvCount = findViewById(R.id.tvCount);
        Button btnGoToActivity1 = findViewById(R.id.btnGoToActivity1);
        Button btnGoToActivity2 = findViewById(R.id.btnGoToActivity2);

        if (savedInstanceState != null) {
            count = savedInstanceState.getInt("count", 0);
        } else if (getIntent() != null && getIntent().hasExtra("count")) {
            count = getIntent().getIntExtra("count", 0);
        }
        tvCount.setText(String.valueOf(count));

        btnGoToActivity1.setOnClickListener(v -> goToMainActivity());
        btnGoToActivity2.setOnClickListener(v -> goToHelloActivity());

        View mainView = findViewById(R.id.main);
        mainView.setOnTouchListener(new OnSwipeTouchListener(this) {
            @Override
            public void onSwipeLeft() {
                goToMainActivity();
            }

            @Override
            public void onSwipeRight() {
                goToHelloActivity();
            }
        });
    }

    @Override
    protected void onNewIntent(@NonNull Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        if (intent.hasExtra("count")) {
            count = intent.getIntExtra("count", count);
            TextView tvCount = findViewById(R.id.tvCount);
            if (tvCount != null) {
                tvCount.setText(String.valueOf(count));
            }
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count", count);
    }

    private void goToMainActivity() {
        Intent intent = new Intent(ThirdActivity.this, MainActivity.class);
        intent.putExtra("count", count);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

    private void goToHelloActivity() {
        Intent intent = new Intent(ThirdActivity.this, HelloActivity.class);
        intent.putExtra("count", count);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }
}