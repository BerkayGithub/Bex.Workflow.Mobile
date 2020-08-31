package com.example.inboxapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class SendMail extends AppCompatActivity {

    ImageView back, send;
    EditText alıcı, konu, ileti;

    DatabaseConnector mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_mail);

        mydb = new DatabaseConnector(this);

        back = findViewById(R.id.backSend);
        send = findViewById(R.id.finishSend);
        alıcı = findViewById(R.id.Gönderalıcı);
        konu = findViewById(R.id.Gönderkonu);
        ileti = findViewById(R.id.Gönderileti);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMail(alıcı.getText().toString(), konu.getText().toString(), ileti.getText().toString());
            }
        });
    }

    private void sendMail(String alıcı, String konu, String ileti){
        if(TextUtils.isEmpty(alıcı) || TextUtils.isEmpty(konu) || TextUtils.isEmpty(ileti)){
            Toast.makeText(this, "You have to fill all boxes!", Toast.LENGTH_LONG).show();
        }else {
            mydb.insertData(alıcı, konu, ileti);
            finish();
        }
    }
}