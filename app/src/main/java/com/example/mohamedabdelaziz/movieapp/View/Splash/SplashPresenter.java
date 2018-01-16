package com.example.mohamedabdelaziz.movieapp.View.Splash;

/**
 * Created by Mohamed Abd Elaziz on 9/15/2017.
 */

public class SplashPresenter {
    private SplashInterface mSplashInterface;
    public SplashPresenter(SplashInterface splashInterface)
    {
        mSplashInterface=splashInterface ;
        mSplashInterface.setTimer();
    }

}
