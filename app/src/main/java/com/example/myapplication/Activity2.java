package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toolbar;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class Activity2 extends AppCompatActivity {

    private Button captureBtn;

    NavigationView sideMenu;
    DrawerLayout drawerLayout;
    MaterialToolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        sideMenu = findViewById(R.id.sideMenu);
        drawerLayout=findViewById(R.id.drawerLayout);
        toolbar=findViewById(R.id.topAppBar);

        toolbar.setOnClickListener(view->{
            drawerLayout.openDrawer(GravityCompat.START);
        });
        captureBtn = findViewById(R.id.idBtnCapture);
        captureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Activity2.this,ScannerActivity.class);
                startActivity(i);
            }
        });

    }
}