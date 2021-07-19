package com.kosmo.a04framelayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class FrameActivity extends AppCompatActivity {

    //이미지를 표현할 때 사용하는 객체
    ImageView dream01;
    ImageView dream02;
    
    //이미지 토글을 위한 변수
    int imageToggle = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);

        //res에 저장된 이미지의 id를 통해 얻어온 후 변수에 저장
        dream01 = (ImageView)findViewById(R.id.dream01); /* 형변환하는 부분은 안써도 O (현재 SDK에서 지원됨)*/
        dream02 = findViewById(R.id.dream02); /* 형변환부분 제거 */
        
    }////onCreate 끝

    /*
    버튼의 onclick속성에 호출할 함수를 연결한 상태이므로 별도의 리스너 처리는 필요 X.
    해당 함수를 정의할때는 반드시 View객체를 매개변수로 삽입한다.
    */
    public void imageChange(View v){
        /*
        xml의 android:setVisibility 속성을 Java에서 아래와 같이 변환할 수 있다.
        */
        if(imageToggle==0){
            dream01.setVisibility(v.VISIBLE); //보임처리
            dream02.setVisibility(v.INVISIBLE); //숨김처리
            imageToggle=1;
        }
        else if(imageToggle==1){
            dream01.setVisibility(v.INVISIBLE);
            dream02.setVisibility(v.VISIBLE);
            imageToggle=0;
        }
    }
    //현재 실행중인 액티비티를 종료함.
    public void returnMain(View v){
        finish();
    }
}