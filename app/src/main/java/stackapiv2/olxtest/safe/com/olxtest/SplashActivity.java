package stackapiv2.olxtest.safe.com.olxtest;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import stackapiv2.olxtest.safe.com.olxtest.utils.Constants;

/**
 * @author Pudit Prasert
 * safefy@gmail.com
**/

public class SplashActivity extends ActionBarActivity {
    private Handler mHandler;
    private Runnable mRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_splash);
        mHandler = new Handler();
        mRunnable = new Runnable() {
            @Override
            public void run() {
                finish();
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            }
        };

        mHandler.postDelayed(mRunnable, Constants.SPLASH_DUTATION);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mHandler != null) {
            if (mRunnable != null) mHandler.removeCallbacks(mRunnable);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mHandler.postDelayed(mRunnable, Constants.SPLASH_DUTATION);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mHandler != null) {
            if (mRunnable != null) mHandler.removeCallbacks(mRunnable);
        }
    }
}
