package com.atmas.saneesh.atma;


import android.content.Intent;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;

import static android.graphics.Color.BLACK;


public class Home extends AppCompatActivity implements GestureDetector.OnGestureListener {

    private GestureDetector gestureDetector;
    private LinearLayout linearLayout1;
    private LinearLayout linearLayout2;
    private LinearLayout linearLayout3;

    private ImageView imageView;

    Animation blinkAnimation, upAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if(Build.VERSION.SDK_INT >= 21)
//        {
//            TransitionInflater transitionInflater = TransitionInflater.from(this);
//            Transition transition = transitionInflater.inflateTransition(R.transition.transition_a);
//            getWindow().setExitTransition(transition);
//
////            Slide slide = new Slide();
////            slide.setDuration(2500);
////            slide.setSlideEdge(Gravity.RIGHT);
////            getWindow().setExitTransition(slide);
////            Transition transition1 = transitionInflater.inflateTransition(R.transition.transition_r);
////            getWindow().setExitTransition(transition);
//        }
        setContentView(R.layout.activity_home);
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(BLACK);

        gestureDetector = new GestureDetector(this, this);

//        linearLayout1 = (LinearLayout) findViewById(R.id.layout1);
//        linearLayout2 = (LinearLayout) findViewById(R.id.layout2);
//        linearLayout3 = (LinearLayout) findViewById(R.id.layout3);
//
        imageView = (ImageView) findViewById(R.id.image);

        imageView.setImageResource(R.drawable.trans_on);
        ((TransitionDrawable) imageView.getDrawable()).startTransition(5000);

//        upAnimation = AnimationUtils.loadAnimation(this,R.anim.down_scroll);
//        linearLayout3.setAnimation(upAnimation);
//
//        blinkAnimation = AnimationUtils.loadAnimation(this,R.anim.blink_scroll);
//        linearLayout3.setAnimation(blinkAnimation);

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }

    @Override
    public boolean onDown(MotionEvent e) {

//Starting new activity
        ActivityOptionsCompat compat = ActivityOptionsCompat.makeSceneTransitionAnimation(this, null);
//        startActivity(new Intent(this,MainActivity.class), compat.toBundle());
        startActivity(new Intent(this, MainActivity.class));

        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }


    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {

        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }


}

