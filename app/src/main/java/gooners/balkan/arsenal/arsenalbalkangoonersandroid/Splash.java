package gooners.balkan.arsenal.arsenalbalkangoonersandroid;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Splash extends Activity {

    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        t= (TextView) findViewById(R.id.textView);
        Typeface myCustomFont=Typeface.createFromAsset(getAssets(), "fonts/Roboto-Bold.ttf");
        t.setTypeface(myCustomFont);

    final ImageView iv = (ImageView) findViewById(R.id.imageView);
    final Animation an = AnimationUtils.loadAnimation(getBaseContext(),R.anim.rotate);
    final Animation an2 = AnimationUtils.loadAnimation(getBaseContext(),R.anim.abc_fade_out);

    iv.startAnimation(an);
    an.setAnimationListener(new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
        iv.startAnimation(an2);
        finish();
        Intent i = new Intent(getBaseContext(),MainActivity.class);
        startActivity(i);
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    });

    }
}
