package edu.fitchburgstate.staylor.bounce;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by staylor on 2/12/15.
 */
public class Bouncer extends View {
    float cx = 0;  // x, y coordinates of center of ball.
    float cy = 0;
    float r = 50; // pixel length of radius of ball
    int color = Color.RED;
    private Paint paint = new Paint();
    float vx = 10;
    float vy = 10;
    private Ball[] ballList = {new Ball(), new Ball(), new Ball()};

    public Bouncer(Context context) {
        super(context);
    }

    public Bouncer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onDraw(Canvas c) {
        super.onDraw(c);
        int w = getWidth();
        int h = getHeight();

        for (Ball b: ballList) {
            // play with the physics
            b.cx += b.vx;
            b.cy += b.vy;

            //right bounce
            if (b.cx + b.r > w) {
                b.vx = -Math.abs(b.vx);
            }
            if (b.cx < b.r) {// left bounce
                b.vx = Math.abs(b.vx);
            }
            if (b.cy < b.r) { // top bounce
                b.vy = Math.abs(b.vy);
            }
            if (b.cy + b.r > h) { // bottom bounce
                b.vy = -Math.abs(b.vy);
            }

            paint.setColor(b.color);
            c.drawCircle(b.cx, b.cy, b.r, paint);
        }
    }
}
