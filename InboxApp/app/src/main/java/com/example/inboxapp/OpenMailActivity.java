package com.example.inboxapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class OpenMailActivity extends AppCompatActivity {

    ImageView geri, imgv_popup;
    TextView konu, gönderen, ileti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_mail);

        geri = findViewById(R.id.backOpen);
        konu = findViewById(R.id.konuOpen);
        gönderen = findViewById(R.id.gönderenOpen);
        ileti = findViewById(R.id.İletiOpen);
        imgv_popup = findViewById(R.id.open_mail_pop_up);

        Toolbar toolbar = findViewById(R.id.openmailtoolbar);
        setSupportActionBar(toolbar);

        init();

        geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        imgv_popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(OpenMailActivity.this, imgv_popup);
                popupMenu.getMenuInflater().inflate(R.menu.open_mail_pop_up, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        int id = menuItem.getItemId();
                        switch (id){
                            case R.id.one:
                                Toast.makeText(OpenMailActivity.this,"İşe Paydaş Ekle",Toast.LENGTH_LONG).show();
                            case R.id.two:
                                Toast.makeText(OpenMailActivity.this,"İşaretle", Toast.LENGTH_LONG).show();
                                break;
                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
    }

    private void init(){
        konu.setText(getIntent().getExtras().get("Konu").toString());
        gönderen.setText(getIntent().getExtras().get("Gönderen").toString());
        ileti.setText(getIntent().getExtras().get("İleti").toString());
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.open_mail_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

     */
}
