package com.example.univit;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.example.univit.ebook.EbookActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    private NavController navController;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        navController= Navigation.findNavController(this, R.id.frame_layout);
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigation_view);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.start, R.string.close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        navigationView.setNavigationItemSelectedListener(this);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_notice:
                Toast.makeText(this, "Notice", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigation_ebooks:
                startActivity(new Intent(this, EbookActivity.class));
                break;
            case R.id.navigation_themes:
                Toast.makeText(this, "Themes", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigation_website:
                Intent implicit = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.bmu.edu.in"));
                startActivity(implicit);
                break;
            case R.id.navigation_rate:
                Toast.makeText(this, "Rate Us", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigation_developers:
                Toast.makeText(this, "Developer", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}