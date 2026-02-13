package com.kosmo.a12intent02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    //응답데이터를 보내줄때 사용할 일종의 키값
    //부가데이터에 대한 응답데이터를 보낼 때 사용할 정수형 상수
    public static final int RESULT_CODE_FAIL_ID = 1;
    public static final int RESULT_CODE_FAIL_PWD = 2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //메인에서 전달한 부가데이터를 받은 후 텍스트뷰에 설정
        final Intent intent = getIntent();
        final String user = intent.getStringExtra("USER");
        final String pass = intent.getStringExtra("PASS");

        //텍스트 뷰에 출력하기
        ((TextView)findViewById(R.id.textview_for_result)).setText(
                String.format("아이디:%s, 패스워드:%s", user, pass)
        );

        //결과값 전송 버튼에 리스너 부착
        ((Button)findViewById(R.id.btn_finish_for_result)).setOnClickListener(
            new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    /*
                    아이디/패스워드의 일치여부를 판단한 후 setResult()를 통해
                    결과값을 메인액티비티로 전송.
                    이때, 메인액티비티에 오버라이딩 된 onActivityResult()가 자동으로 콜백됨.
                     */
                    if(!"kosmo".equals(user)){
                        intent.putExtra("FAIL_ID", "아이디 오류");
                        setResult(RESULT_CODE_FAIL_ID, intent);
                    }
                    else if(!"1234".equals(pass)){
                        intent.putExtra("FAIL_PWD", "비번오류");
                        setResult(RESULT_CODE_FAIL_PWD, intent);
                    }
                    else{
                        intent.putExtra("SUCCESS", user+"님 안녕하세요.");
                        setResult(Activity.RESULT_OK, intent);
                    }
                    finish(); //액티비티 종료
                }
            }
        );
    }
}
