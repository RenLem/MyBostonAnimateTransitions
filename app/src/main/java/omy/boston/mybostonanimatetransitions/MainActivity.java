package omy.boston.mybostonanimatetransitions;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    ViewGroup layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = (ViewGroup) findViewById(R.id.touchLayout);

        layout.setOnTouchListener(new RelativeLayout.OnTouchListener(){

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                moveGirl();
                return true;
            }
        });
    }

    public void moveGirl(){
        View girlView = findViewById(R.id.girlView);
        TransitionManager.beginDelayedTransition(layout);

        //Position
        RelativeLayout.LayoutParams positionRules = new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
        girlView.setLayoutParams(positionRules);

        //Size
        ViewGroup.LayoutParams sizeRules = girlView.getLayoutParams();
        sizeRules.width = 1000;
        sizeRules.height = 5200;
        girlView.setLayoutParams(sizeRules);
    }
}
