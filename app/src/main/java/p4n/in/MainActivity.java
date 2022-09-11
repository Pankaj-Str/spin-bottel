package p4n.in;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView bottel;
    Random rnd = new Random();
    boolean spn;
    int last;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottel = findViewById(R.id.btn_btl);

        bottel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinbtl();
            }
        });
    }

    void spinbtl(){
        if(!spn){
                int num = rnd.nextInt(1800);

                float x = bottel.getHeight()/2;

                float y = bottel.getWidth()/2;

            Animation an = new RotateAnimation(last,num,x,y);

            an.setDuration(900);
            an.setFillAfter(true);
            an.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    spn = true;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    spn = false;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });

            last = num;
            bottel.startAnimation(an);

        }
    }
}