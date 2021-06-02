package com.example.bareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity4 extends AppCompatActivity {

    private boolean isFabExpand = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        if (isFabExpand) fabClick();
        this.findViewById(R.id.fabMain).setOnClickListener(v -> {
            fabClick();
        });
    }

    private void fabClick() {
        FloatingActionButton fabMain = this.findViewById(R.id.fabMain);
        FloatingActionButton fab1 = this.findViewById(R.id.fab1);
        FloatingActionButton fab2 = this.findViewById(R.id.fab2);
        if (isFabExpand) {
            // do collapse
            fabMain.animate().rotation(45);
            fab1.animate().translationY(0);
            fab2.animate().translationY(0);
            fab1.animate().alpha(0);
            fab2.animate().alpha(0);
            isFabExpand = false;
        } else {
            // do expand
            fabMain.animate().rotation(0);
            fab1.animate().translationY(-150);
            fab2.animate().translationY(-150*2);
            fab1.animate().alpha(1);
            fab2.animate().alpha(1);
            isFabExpand = true;
        }
    }
}