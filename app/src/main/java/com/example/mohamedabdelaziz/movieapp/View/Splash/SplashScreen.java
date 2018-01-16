package com.example.mohamedabdelaziz.movieapp.View.Splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


import com.example.mohamedabdelaziz.movieapp.MainAct.View.Main.MainActivity;
import com.example.mohamedabdelaziz.movieapp.R;

public class SplashScreen extends AppCompatActivity implements SplashInterface{

    private Handler mHandler ;
    private final int SPLASH_TIME =400 ;
    private TextView mTextView ;
    private Runnable mRunnable ;
    int i =0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        mHandler=new Handler();
        setUpView() ;
        new SplashPresenter(this) ;

    }

    private void setUpView() {
        mTextView= (TextView) findViewById(R.id.tv_splash) ;
    }

    @Override
    public void setTimer() {
        final String name="MovieApp" ;

            mRunnable=new Runnable() {
                @Override
                public void run() {
                    mTextView.setText(mTextView.getText()+""+name.charAt(i));
                    i++;
                    if(i< name.length())
                        mHandler.postDelayed(mRunnable,SPLASH_TIME);
                    else
                    {
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        finish();
                    }
                }
            };

            mHandler.postDelayed(mRunnable,SPLASH_TIME);
        }


    @Override
    public void stopTimer() {
        mHandler.removeCallbacks(mRunnable);
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopTimer();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setTimer();
    }
}
