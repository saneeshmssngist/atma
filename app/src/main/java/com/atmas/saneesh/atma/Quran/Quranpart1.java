package com.atmas.saneesh.atma.Quran;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.TextView;

import com.atmas.saneesh.atma.MainActivity;
import com.atmas.saneesh.atma.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class Quranpart1 extends AppCompatActivity {

    private AdView adMobView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quranpart1);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolaction);
        TextView textView = (TextView) findViewById(R.id.txt);
        textView.setText(" Quran");

        WebView webView = (WebView) findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setBackgroundColor(Color.argb(1, 0, 0, 0));
        webView.loadUrl("file:///android_asset/www/Quran/quranpart1.html");

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
        int1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(int1);
    }

}
