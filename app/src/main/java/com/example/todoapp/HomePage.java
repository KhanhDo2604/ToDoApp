package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.MaterialShapeDrawable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class HomePage extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Calendar calendar;
    SimpleDateFormat dateFormat;
    String date;
    AutoCompleteTextView spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        spinner = findViewById(R.id.autoCompleteTextView);
        calendar = Calendar.getInstance();
        dateFormat = new SimpleDateFormat("MMMM");
        date = dateFormat.format(calendar.getTime());
        spinner.setText(date);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setBackground(null);

        BottomAppBar bottomAppBar = findViewById(R.id.bottomAppBar);
        MaterialShapeDrawable bottomBarBackground = (MaterialShapeDrawable) bottomAppBar.getBackground();
        bottomBarBackground.setShapeAppearanceModel(
                bottomBarBackground.getShapeAppearanceModel()
                        .toBuilder()
                        .setAllCorners(CornerFamily.ROUNDED,56)
                        .build());

        String[] months = getResources().getStringArray(R.array.months);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.dropdown_item, months);
        spinner.setAdapter(adapter);
    }
}