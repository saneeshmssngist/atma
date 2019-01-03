package com.atmas.saneesh.atma.Ramayana;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.atmas.saneesh.atma.MainActivity;
import com.atmas.saneesh.atma.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class Ramayanavideo extends AppCompatActivity {

    private AdView adMobView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ramayanavideo);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolaction);
        TextView textView = (TextView) findViewById(R.id.txt);
        textView.setText(" Ramayana Videos");

        ImageButton btn1 = (ImageButton) findViewById(R.id.btn1);
        ImageButton btn2 = (ImageButton) findViewById(R.id.btn2);
        ImageButton btn3 = (ImageButton) findViewById(R.id.btn3);
        ImageButton btn4 = (ImageButton) findViewById(R.id.btn4);
        ImageButton btn5 = (ImageButton) findViewById(R.id.btn5);
        ImageButton btn6 = (ImageButton) findViewById(R.id.btn6);
        ImageButton btn7 = (ImageButton) findViewById(R.id.btn7);

//To check internet connection available or not
        Network_connection network_connection = new Network_connection();
        if(!network_connection.isConnected(this)){
            network_connection.buildDialog(this).setPositiveButton("Ok", new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    finish();
                }
            }).show();
        }
        else {

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//vibrating when button clicked
                    Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    vibrator.vibrate(30);

                    Intent int1 = new Intent(Ramayanavideo.this, Video_show.class);
                    int1.putExtra("url", "5r7gcwv9OVI");
                    startActivity(int1);
                }
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//vibrating when button clicked
                    Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    vibrator.vibrate(30);

                    Intent int1 = new Intent(Ramayanavideo.this, Video_show.class);
                    int1.putExtra("url", "R0qizAt-l2M");
                    startActivity(int1);
                }
            });
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//vibrating when button clicked
                    Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    vibrator.vibrate(30);

                    Intent int1 = new Intent(Ramayanavideo.this, Video_show.class);
                    int1.putExtra("url", "CughBgY2iKQ");
                    startActivity(int1);
                }
            });
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//vibrating when button clicked
                    Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    vibrator.vibrate(30);

                    Intent int1 = new Intent(Ramayanavideo.this, Video_show.class);
                    int1.putExtra("url", "IzLf1g7CxWo");
                    startActivity(int1);
                }
            });
            btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//vibrating when button clicked
                    Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    vibrator.vibrate(30);

                    Intent int1 = new Intent(Ramayanavideo.this, Video_show.class);
                    int1.putExtra("url", "0unzT5BMBE8");
                    startActivity(int1);
                }
            });
            btn6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//vibrating when button clicked
                    Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    vibrator.vibrate(30);

                    Intent int1 = new Intent(Ramayanavideo.this, Video_show.class);
                    int1.putExtra("url", "HBSZGV2icbw");
                    startActivity(int1);
                }
            });
            btn7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//vibrating when button clicked
                    Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    vibrator.vibrate(30);

                    Intent int1 = new Intent(Ramayanavideo.this, Video_show.class);
                    int1.putExtra("url", "co4jeyv4ALQ");
                    startActivity(int1);
                }
            });
        }

        setUpAdmob();

    }


    private void setUpAdmob() {

        //admob sync..
        MobileAds.initialize(this, getResources().getString(R.string.APPID));

        adMobView = (AdView) findViewById(R.id.adMobView);
        adMobView.loadAd(new AdRequest.Builder().build());

    }

    public void ImageButton(View view)
    {
        Intent int1 = new Intent(this,MainActivity.class);
        startActivity(int1);
    }
}
