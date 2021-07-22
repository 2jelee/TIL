package com.kosmo.a15intro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.logging.Handler;

/*
Manifest.xml 파일을 수정하여 Intro 액티비티가 가장 먼저 실행되도록 처리함.
*/
public class Intro extends AppCompatActivity {

    //일정시간 이후에 실행하기 위해 Handler 객체를 생성한다.
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            //인트로 화면 이후에 메인액티비티를 실행하기 위해 인텐트 객체 생성
            Intent intent = new Intent(getApplicationContext(),
                    MainActivity.class);
            //액티비티 실행
            startActivity(intent);
            /*
            액티비티가 실행되거나 종료될 때 애니메이션 효과를 부여.
            인자1 : 새롭게 실행되는 액티비티의 애니메이션
            인자2 : 종료되는 액티비티에 적용되는 애니메이션
             */
            overridePendingTransition(R.anim.slide_in_right, R.anim.hold);
            //인트로 액티비티를 종료함.
            finish();
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
    }

    //액티비티 실행 시 3번째로 호출되는 수명주기 메소드
    @Override
    protected void onResume() {
        super.onResume();

        // Intro 액티비티에 진입한 후 2초 후에 runnable 객체를 실행
        handler.postDelayed(runnable, 2000);
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Intro가 종료될 때 handler에 예약해놓은 작업을 취소함.
        handler.removeCallbacks(runnable);
    }
}
