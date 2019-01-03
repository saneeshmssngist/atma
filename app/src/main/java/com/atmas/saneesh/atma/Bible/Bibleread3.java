package com.atmas.saneesh.atma.Bible;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.atmas.saneesh.atma.MainActivity;
import com.atmas.saneesh.atma.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class Bibleread3 extends AppCompatActivity {

    private ViewPager viewPager;
    private Pageradapter pagerAdapter = new Pageradapter(this);
    private AdView adMobView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bibleread3);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolaction);
        TextView textView = (TextView) findViewById(R.id.txt);
        textView.setText(" Bible");

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(pagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

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


    public class Pageradapter extends PagerAdapter {

        private LayoutInflater inflater;

        private Context ctx;

        public Pageradapter(Context ctx)
        {
            this.ctx = ctx;
        }
        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return (view ==(LinearLayout)object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v = inflater.inflate(R.layout.contentswipe, container, false);

            WebView webView = (WebView) v.findViewById(R.id.webview);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.setWebChromeClient(new WebChromeClient());
            webView.setBackgroundColor(Color.argb(1, 0, 0, 0));
            webView.loadUrl("file:///android_asset/www/Bible/Biblepart3/biblepart"+(position+1)+".html");
            container.addView(v);
            return v;
        }
        @Override
        public CharSequence getPageTitle(int position)
        {
            switch (position){
                case 0:
                    return "1";
                case 1:
                    return "2";
                case 2:
                    return "3";
                default:
                    return null;
            }
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.invalidate();
        }
    }

}
