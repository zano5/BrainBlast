package codetribe.co.za.brainblast;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.github.florent37.viewanimator.ViewAnimator;

import java.io.IOException;


public class SplashScreenActivity extends AppCompatActivity {
    private ImageView ivSplash;
    private MediaPlayer player;
    private static int SPLASH_TIME_OUT = 3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ivSplash = (ImageView) findViewById(R.id.ivSplash);
        ViewAnimator
                .animate(ivSplash).rollIn().start();
        player = MediaPlayer.create(this,R.raw.kkull_kid);
        player.start();


        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);






    }

    public void onDestroy()
    {

        super.onDestroy();
        player.release();
    }

    public void onPause()
    {
        super.onPause();
        player.release();
    }
}
