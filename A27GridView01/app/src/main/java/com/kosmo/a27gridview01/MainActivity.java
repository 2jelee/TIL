package com.kosmo.a27gridview01;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "KOSMO123";

    //적용할 데이터
    String[] names = {
            "엑소", "방탄소년단", "워너원", "뉴이스트", "갓세븐", "비투비", "빅스",
            "엑소2", "방탄소년단2", "워너원2", "뉴이스트2", "갓세븐2", "비투비2", "빅스2"};
    String[] ages = { "9", "7", "11", "5", "7", "7", "6",
            "92", "72", "112", "52", "72", "72", "62"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //커스텀뷰 객체 생성 및 그리드뷰와 연결
       final MyAdapter adapter = new MyAdapter();
        GridView gridView1 = findViewById(R.id.gridView1);
        gridView1.setAdapter(adapter);
        gridView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,
                                    int i, long arg3) {
                //콜백되는 index를 통해 행과 열을 계산해서 로그로 출력
                int row    = i / 2;
                int column = i % 2;
                Log.d(TAG, "position : " + i);
                Log.d(TAG, "Row index : " + row + " Column index :" + column);
                Log.d(TAG, names[row * 2 + column]);

                Toast.makeText(getApplicationContext(),
                        "그룹명:"+names[i]+",인원수:"+ages[i],
                        Toast.LENGTH_LONG).show();
            }
        });
    }
    //커스텀 어뎁터 클래스 선언
    class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return names.length;
        }
        @Override
        public Object getItem(int position) {
            return names[position];
        }
        @Override
        public long getItemId(int position) {
            return position;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //리니어 레이아웃 생성 및 방향설정
            LinearLayout layout = new LinearLayout(getApplicationContext());
            layout.setOrientation(LinearLayout.VERTICAL);

            //텍스트뷰1 : 그룹명
            TextView view1 = new TextView( getApplicationContext() );
            view1.setText(names[position]);
            view1.setTextSize(25.0f);
            view1.setTextColor(Color.BLUE);

            //텍스트뷰2 : 인원수
            TextView view2 = new TextView( getApplicationContext() );
            view2.setText(ages[position]);
            view2.setTextSize(25.0f);
            view2.setTextColor(Color.RED);

            layout.addView(view1);
            layout.addView(view2);
            return layout;
        }
    }
}