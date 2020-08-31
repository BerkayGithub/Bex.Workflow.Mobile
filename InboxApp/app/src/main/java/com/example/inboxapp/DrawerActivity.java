package com.example.inboxapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.inboxapp.Fragments.CalendarFragment;
import com.example.inboxapp.Fragments.DraftFragment;
import com.example.inboxapp.Fragments.InboxFragment;
import com.example.inboxapp.Fragments.SentFragment;
import com.example.inboxapp.Fragments.TrashFragment;
import com.google.android.material.navigation.NavigationView;

public class DrawerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawer;

    DatabaseConnector mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new InboxFragment()).commit();
        getSupportActionBar().setTitle("Gelen Kutusu");
        navigationView.setCheckedItem(R.id.gelenItem);

    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.gelenItem:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new InboxFragment()).commit();
                getSupportActionBar().setTitle("Gelen Kutusu");
                break;
            case R.id.havuzdakiItem:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SentFragment()).commit();
                getSupportActionBar().setTitle("Havuzdaki İşler");
                break;
            case R.id.ParkItem:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new DraftFragment()).commit();
                getSupportActionBar().setTitle("Park Edilen İşler");
                break;
            case R.id.İşaretlediğinItem:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new TrashFragment()).commit();
                getSupportActionBar().setTitle("İşaretlediğin İşler");
                break;
            case R.id.DiğerItem:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CalendarFragment()).commit();
                getSupportActionBar().setTitle("Diğer Süreçlerden Beklediklerim");
                break;
            case R.id.GidenItem:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SentFragment()).commit();
                getSupportActionBar().setTitle("Giden Kutusu");
                break;
            case R.id.ic_is_olustur:
                Intent intent = new Intent(DrawerActivity.this, SendMail.class);
                startActivity(intent);
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_profile) {
            Intent intent = new Intent(DrawerActivity.this, ProfileActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
