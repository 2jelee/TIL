package com.kosmo.a07resource;

import android.content.res.Resources;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //위젯가져오기
        TextView textViewCode = findViewById(R.id.code_textview);
        ImageView imageViewCode = findViewById(R.id.code_imageview);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);

        //텍스트뷰에 리소스에서 가져온 값 설정하기 위한 Resource객체 생성
        //만약 final을 지운다면 [익명클래스] (new View.OnClickListener(){ 내에서 사용불가
        final Resources resources = getResources();

        //텍스트 설정
        textViewCode.setText(R.string.code_message);
        //텍스트 크기 설정 (COMPLEX_UNIT_PX >> 픽셀단위로 지정)
        textViewCode.setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.dimenXml));
        //텍스트 컬러 설정
        textViewCode.setTextColor(ContextCompat.getColor(this, R.color.colorXml));
        /*
        XML 레이아웃 파일에서 사용하는 속성 앞에 set을 붙이면 대부분 설정메소드가 된다.
        ex) text -> setText
        */
        
        //이미지뷰에 Java코드로 이미지 설정하기
        imageViewCode.setImageResource(R.drawable.grandmother);

        // int형 배열을 출력하는 버튼
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //int형 배열 출력
                /*
                res의 arrays.xml에서 int_array 항목을 가져와서
                문자열로 변경한 후 토스트로 출력한다.
                */
                Toast.makeText(v.getContext(),
                        Arrays.toString(resources.getIntArray(R.array.int_array)),
                        Toast.LENGTH_LONG).show();
            }
        });
        /* String형 배열을 출력하는 버튼 */
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //string형 배열 출력
                /* 리소스를 얻어와서 String형 배열에 저장 */
                String[] idolArr = resources.getStringArray(R.array.str_array);
                /* StringBuffer를 통해 내용을 하나의 문자열로 만들어줌 */
                StringBuffer buf = new StringBuffer();
                for(String idol : idolArr){
                    buf.append(idol + "\r\n");
                }
                Toast.makeText(v.getContext(), buf,
                Toast.LENGTH_LONG).show();
            }
        });
    }
}