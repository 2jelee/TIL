package com.kosmo.a14lifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/*
Activity의 Lifecyle(수명주기) 메소드 : 아래와 같이 순서대로 메소드가 실행됨.
    -액티비티가 실행되면
     onCreate() → onStart() → onResume()
    -액티비티가 종료되면
     onPause() → onStop() → onDestroy()

    안드로이드에서 수명주기 메소드는 '앱이 비정상적으로 종료'되는 시점의 상태를 저장하거나
    앱이 (처음부터) 실행될 때 자동으로 실행하고자 하는 명령이 있는 경우 사용함.
 */
public class SubActivity extends AppCompatActivity {

    //로그켓 확인을 위한 상수 선언(전역적)
    private static final String TAG = "KOSMO123";

    /*********6가지의 수명주기 함수들 오버라이딩 처리 **********/
    /*** 액티비티 실행 시 ***/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Log.d(TAG,"서브액티비티 시작됨");
        Log.d(TAG,"onCreate() 호출");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(TAG,"onStart() 호출");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG,"onResume() 호출");
    }

    /*** 액티비티 종료 시 ***/
    @Override
    protected void onPause() {
        super.onPause();

        Log.d(TAG,"onPause() 호출");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d(TAG,"onStop() 호출");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(TAG,"onDestroy() 호출");
    }


    public void subBtnClicked(View view){
        Log.d(TAG,"서브액티비티 종료 버튼 클릭");
        finish();
    }
}