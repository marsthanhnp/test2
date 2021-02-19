package com.example.aqsolution;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class KynangActivity extends YouTubeBaseActivity
                            implements YouTubePlayer.OnInitializedListener{
    String API_KEY_YOUTUBE="AIzaSyB_kNpWbOiIiOzEyXisxGkK_Z2S5uarsGs";
    YouTubePlayerView youTubePlayerView;
    int REQUEST_VIDEO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kynang);

        youTubePlayerView=findViewById(R.id.ytb_kynang);
        youTubePlayerView.initialize(API_KEY_YOUTUBE,this);

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
//        youTubePlayer.cueVideo("qyuvIbUFtPQ&list=PLUS4wIWtP11mRLAZcirszqjNLdk3kWe0Q&ab_channel=AnIsHere");
        youTubePlayer.cueVideo("qyuvIbUFtPQ");

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if (youTubeInitializationResult.isUserRecoverableError()){
            youTubeInitializationResult.getErrorDialog(KynangActivity.this,REQUEST_VIDEO);
        }else{
            Toast.makeText(KynangActivity.this,"Error!",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==REQUEST_VIDEO){
            youTubePlayerView.initialize(API_KEY_YOUTUBE,KynangActivity.this);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}