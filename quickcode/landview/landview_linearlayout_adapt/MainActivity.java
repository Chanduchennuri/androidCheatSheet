package com.example.bareapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adaptOrient(getResources().getConfiguration());
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        adaptOrient(newConfig);
    }

    private void adaptOrient(@NonNull Configuration config) {
        LinearLayout layoutBtn = findViewById(R.id.linearLayoutBtn);
        LinearLayout layoutFrame = findViewById(R.id.linearLayoutFrame);
        if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            layoutBtn.setOrientation(LinearLayout.VERTICAL);
            layoutFrame.setOrientation(LinearLayout.HORIZONTAL);
        } else {
            layoutBtn.setOrientation(LinearLayout.HORIZONTAL);
            layoutFrame.setOrientation(LinearLayout.VERTICAL);
        }
    }
}