package com.example.a18030021modul4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText phoneNumber;
    private EditText websiteUri;
    private EditText locationUri;
    private EditText textShare;
    private String textWeb;
    private String textloc;
    private String textshr;
    private String textphn;

    Button buttonWebsite;
    Button buttonlocation;
    Button buttonShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phoneNumber = findViewById(R.id.edtPhoneNumber);
        websiteUri = findViewById(R.id.edtWebsiteUri);
        locationUri = findViewById(R.id.edtLocationUri);
        textShare = findViewById(R.id.edtShareText);

        buttonWebsite = findViewById(R.id.btnWebsiteUri);
        buttonWebsite.setOnClickListener(this);
        buttonlocation = findViewById(R.id.btnLocationUri);
        buttonlocation.setOnClickListener(this);
        buttonShare = findViewById(R.id.btnShareText);
        buttonShare.setOnClickListener(this);

    }
    public void openDialPhone (View view){
        validasiData();
        Intent dialPhone = new Intent (Intent.ACTION_DIAL,
                Uri.parse("tel:" +phoneNumber.getText().toString()));
        startActivity(dialPhone);
    }

    @Override
    public void onClick(View v) {
        validasiData();
        switch (v.getId()){
            case R.id.btnWebsiteUri:
                Intent openWebsite = new Intent (Intent.ACTION_VIEW,
                        Uri.parse(websiteUri.getText().toString()));
                startActivity(openWebsite);
                break;
            case R.id.btnLocationUri:
                Intent openLocation = new Intent (Intent.ACTION_VIEW,
                        Uri.parse("geo:0,0?q=" + locationUri.getText().toString()));
                startActivity(openLocation);
                break;
            case R.id.btnShareText:
                ShareCompat.IntentBuilder
                        .from(this)
                        .setType("text/plan")
                        .setChooserTitle("Share this text with : ")
                        .setText(textShare.getText().toString())
                        .startChooser();
                break;
        }
    }
    public void validasiData(){
        textphn = phoneNumber.getText().toString();
        textWeb = websiteUri.getText().toString();
        textloc = locationUri.getText().toString();
        textshr = textShare.getText().toString();
        if (textphn.matches(" ")||textWeb.matches(" ")|| textloc.matches(" ")||textshr.matches(" ")){
            Toast.makeText(this, "Semua Kolom Harus Wajib Diisi",Toast.LENGTH_SHORT).show();
        }

    }
}