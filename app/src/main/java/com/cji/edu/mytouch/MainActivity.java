package com.cji.edu.mytouch;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

class MyView extends View {
    int key;
    String str;
    int x = 100 , y = 100;

    public MyView(Context context){
        super(context);
        setBackgroundColor(Color.YELLOW);
    }

    // 터치 이벤트
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // 터치 좌표 얻어옴
        x = (int)event.getX();
        y = (int)event.getY();

        //터치 액션 체크
        if(event.getAction() == MotionEvent.ACTION_DOWN)
            str = "액션다운";
        if(event.getAction() == MotionEvent.ACTION_MOVE)
            str = "액션무브";
        if(event.getAction() == MotionEvent.ACTION_UP)
            str = "액션업";

        // 화면 그리기
        invalidate();// onDraw()를 간접적으로 호출하는 방법
        return true;
    }

    //화면 그리기
    @Override
    protected void onDraw(Canvas canvas) {//정해진 시점에서만 호출되서 화면 그림
        Paint paint = new Paint();
        paint.setTextSize(50);
        // 동그라미 그리기
        canvas.drawCircle(x, y, 30, paint);
        // 좌표 쓰기
        canvas.drawText("("+x+","+y+") 액션종류 : "+str, 2, 100, paint);
        super.onDraw(canvas);
    }
}
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView myView = new MyView(this);
        setContentView(myView);
    }
}
