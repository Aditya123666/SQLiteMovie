package camp.bso.inf.spinbottle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static  final Random RANDOM = new Random();
    private View main;
    private ImageView bottle;
    private  int lastAngle = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main = findViewById(R.id.main);
        bottle = (ImageView) findViewById(R.id.bottle);

        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinTheBottle();
            }
        });

        Toast.makeText(this,"TOUCH",Toast.LENGTH_SHORT).show();

    }
    private void spinTheBottle(){
        int angle = RANDOM.nextInt(3600-360)+360;
        float pivotX = bottle.getWidth()/2;
        float pivotY = bottle.getHeight()/2;

        final Animation rotateAnimation = new RotateAnimation(lastAngle == -1? 0:lastAngle,angle,pivotX,pivotY);
        lastAngle = angle;
        rotateAnimation.setDuration(2500);
        rotateAnimation.setFillAfter(true);

        bottle.startAnimation(rotateAnimation);
    }
}
