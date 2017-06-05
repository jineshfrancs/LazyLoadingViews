package test.jinesh.loadingviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Jinesh on 03-03-2017.
 */

public class LoadingImageView extends android.support.v7.widget.AppCompatImageView {
    private boolean isLoading=false;
    private int width,height,x,y,rX,rY,rWidth,rHeight;
    private Paint loadingPaint;
    private Paint ripplePaint;
    public LoadingImageView(Context context) {
        super(context);
        init(context);
    }

    public LoadingImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }
    private void init(Context context) {
        loadingPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        loadingPaint.setColor(Color.parseColor("#ffe2e2e2"));
        ripplePaint=new Paint();
        ripplePaint.setColor(Color.parseColor("#44f0f0f0"));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if(!isLoading) {
            super.onDraw(canvas);
        }else{
            canvas.drawRect(x,y,x+width,y+height,loadingPaint);
            canvas.drawRect(rX,rY,rX+rWidth,rY+rHeight,ripplePaint);
            rX=(rX<width)?rX+5:x-rWidth;
            post(rippleRunner);
        }
    }
    private Runnable rippleRunner=new Runnable() {
        @Override
        public void run() {
            invalidate();
        }
    };
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width=w;
        height=h;
        x=0;
        y=0;
        rWidth=width-5;
        rHeight=height;
    }

    public void startLoading(){
        isLoading=true;
        rX=x-rWidth;
        rY=y;
        invalidate();
    }
    public void stopLoading(){
        isLoading=false;
        invalidate();
    }
}
