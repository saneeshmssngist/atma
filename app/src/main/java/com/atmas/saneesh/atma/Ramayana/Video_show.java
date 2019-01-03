package com.atmas.saneesh.atma.Ramayana;

import android.os.Bundle;
import android.util.Log;

import com.atmas.saneesh.atma.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class Video_show extends YouTubeBaseActivity {


    public static final String API_KEY = "AIzaSyBACgg-AFWRcIepeBUGPX_BjaReVxeEgu0";
    YouTubePlayerView youTubePlayerView;

    YouTubePlayer.OnInitializedListener onInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_show);



        final String youtube_url = getIntent().getExtras().getString("url");
        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube);

        Log.i("youuu","aaaa");
        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

                youTubePlayer.loadVideo(youtube_url);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
        youTubePlayerView.initialize(API_KEY,onInitializedListener);


    }

}
