package com.kosmo.a24listview01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "KOSMO";

    //배열 생성 - 항목이 많아지면 자동으로 스크롤바 생성됨
    String[] idolGroup = {
            "엑소", "방탄소년단", "워너원", "뉴이스트", "갓세븐", "비투비", "빅스",
            "엑소2", "방탄소년단2", "워너원2", "뉴이스트2", "갓세븐2", "비투비2", "빅스2",
            "엑소3", "방탄소년단3", "워너원3", "뉴이스트3", "갓세븐3", "비투비3", "빅스3"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        리스트뷰의 데이터로 사용할 어댑터 객체 생성 및 배열 설정
        형식]
            new ArrayAdapter<>(컨텍스트, 리스트뷰의모양, 데이터(배열 혹은 JSON)
        
        **서버통신을 위해 대부분 JSON 사용
        */
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, idolGroup);

        //리스트뷰 위젯을 객체화
        ListView listView1 = findViewById(R.id.listView1);
        //리스트뷰에 어뎁터 설정
        listView1.setAdapter(adapter);
        //리스트뷰에 리스너 부착
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //항목선택시 해당 index 값이 콜백되어 전달된다.
                Toast.makeText(getApplicationContext(),
                        idolGroup[position] + " 선택됨",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}