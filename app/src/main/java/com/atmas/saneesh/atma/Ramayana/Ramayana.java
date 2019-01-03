package com.atmas.saneesh.atma.Ramayana;

import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.atmas.saneesh.atma.MainActivity;
import com.atmas.saneesh.atma.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class Ramayana extends AppCompatActivity {

    private Toolbar toolbar;

    private Button button1;
    private Button button2;
    private Button button3;

    private Animation animation1,animation2,animation3;
    private AdView adMobView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
////Giving transitions to the current activity while launching.
//        if(Build.VERSION.SDK_INT >= 21)
//        {
//            TransitionInflater transitionInflater = TransitionInflater.from(this);
//            Transition transition = transitionInflater.inflateTransition(R.transition.transition_a);
//            getWindow().setExitTransition(transition);
//
//
////            Slide slide = new Slide();
////            slide.setDuration(2500);
////            slide.setSlideEdge(Gravity.RIGHT);
////            getWindow().setExitTransition(slide);
////            Transition transition1 = transitionInflater.inflateTransition(R.transition.transition_r);
////            getWindow().setExitTransition(transition);
//        }
        setContentView(R.layout.activity_ramayana);


        toolbar = (Toolbar) findViewById(R.id.toolaction);
        TextView textView = (TextView) findViewById(R.id.txt);
        textView.setText(" Ramayana");

        button1 = (Button) findViewById(R.id.btn1);
        button2 = (Button) findViewById(R.id.btn2);
        button3 = (Button) findViewById(R.id.btn3);

        animation1 = AnimationUtils.loadAnimation(this,R.anim.blink);
        animation2 = AnimationUtils.loadAnimation(this,R.anim.blink);
        animation3 = AnimationUtils.loadAnimation(this,R.anim.blink);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//vibrating when button clicked
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(30);

//starting the animation
                button1.startAnimation(animation1);

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//vibrating when button clicked
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(30);
//starting the animation
                button2.startAnimation(animation2);

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//vibrating when button clicked
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(30);

//starting the animation
                button3.startAnimation(animation3);
            }
        });

        animation1.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
//Starting new activity
                ActivityOptionsCompat compat = ActivityOptionsCompat.makeSceneTransitionAnimation(Ramayana.this,null);
                startActivity(new Intent(Ramayana.this,Ramayanashort.class), compat.toBundle());
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        animation2.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                button1.setVisibility(View.VISIBLE);
                startActivity(new Intent(Ramayana.this,Ramayanalong.class));

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        animation3.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                button1.setVisibility(View.VISIBLE);
                startActivity(new Intent(Ramayana.this,Ramayanavideo.class));


            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

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

