package com.atmas.saneesh.atma;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;

import com.atmas.saneesh.atma.Bible.Bible;
import com.atmas.saneesh.atma.Quran.Quran;
import com.atmas.saneesh.atma.Ramayana.Ramayana;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private ViewGroup viewGroup;
    private ImageButton button1;
    private ImageButton button2;
    private ImageButton button3;

    private Animation animation1, animation2, animation3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
////Giving transitions to the current activity while launching.
//        if (Build.VERSION.SDK_INT >= 21) {
//            TransitionInflater transitionInflater = TransitionInflater.from(this);
//            Transition transition = transitionInflater.inflateTransition(R.transition.transition_r);
//            getWindow().setExitTransition(transition);
//
////            Slide slide = new Slide();
////            slide.setDuration(2500);
////            slide.setSlideEdge(Gravity.RIGHT);
////            getWindow().setExitTransition(slide);
////            Transition transition1 = transitionInflater.inflateTransition(R.transition.transition_r);
////            getWindow().setExitTransition(transition);
//        }

        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolaction);
        TextView textView = (TextView) findViewById(R.id.txt);
        textView.setText(" Atma");

        viewGroup = (ViewGroup) findViewById(R.id.view);
        button1 = (ImageButton) findViewById(R.id.btn1);
        button2 = (ImageButton) findViewById(R.id.btn2);
        button3 = (ImageButton) findViewById(R.id.btn3);

        animation1 = AnimationUtils.loadAnimation(this, R.anim.sequential);
        animation2 = AnimationUtils.loadAnimation(this, R.anim.sequential);
        animation3 = AnimationUtils.loadAnimation(this, R.anim.sequential);

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
                ActivityOptionsCompat compat = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, null);
                startActivity(new Intent(MainActivity.this, Ramayana.class));

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
                Intent int1 = new Intent(MainActivity.this, Bible.class);
                startActivity(int1);
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
                Intent int1 = new Intent(MainActivity.this, Quran.class);
                startActivity(int1);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

    public void ImageButton(View view) {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onStart() {

        button2.setVisibility(View.VISIBLE);
        button3.setVisibility(View.VISIBLE);

        super.onStart();
    }
}
