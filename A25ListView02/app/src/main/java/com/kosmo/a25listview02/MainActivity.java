package com.kosmo.a25listview02;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "KOSMO123";
    /*
    2가지 형태의 데이터로 사용할 배열
     */
    String[] idolGroup = {"엑소", "방탄소년단", "워너원", "뉴이스트", "갓세븐", "비투비", "빅스"};
    int[] teamCount  = { 9, 7, 11, 5, 7, 7, 6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //개발자가 정의한 어댑터 객체 생성
        final MyAdapter adapter = new MyAdapter();
        //리스트뷰에 어댑터 객체를 설정한 후 리스너 부착
        ListView listView1 = findViewById(R.id.listView1);
        listView1.setAdapter(adapter);
        listView1.setOnItemClickListener(
            new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Log.i(TAG, "선택한index : "+ i);
                    //그룹명과 팀 인원수까지 토스트로 출력함.
                    Toast.makeText(getApplicationContext(),
                            idolGroup[i]+"("+teamCount[i]+") 선택됨",
                            Toast.LENGTH_SHORT).show();
                }
            });
    }
    /*
    개발자정의 커스텀 어뎁터 객체 선언
        : BaseAdapter를 상속받아 선언한다. 그리고 관련 메소드를
        오버라이딩 한다.
     */
    class MyAdapter extends BaseAdapter {
        //어뎁터 객체가 가진 항목의 갯수를 반환
        @Override
        public int getCount() {
            return idolGroup.length;
        }
        //어뎁터가 가진 하나의 항목을 반환
        @Override
        public Object getItem(int position) {
            return idolGroup[position];
        }
        //해당 항목의 인덱스를 반환
        @Override
        public long getItemId(int position) {
            return position;
        }
        //어댑터가 가진 뷰 중에 하나를 반환
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //Java코드를 통해 레이아웃 및 텍스트뷰 생성

            //첫번째 텍스트뷰 : 아이돌 그룹명을 표시
            TextView view1 = new TextView(getApplicationContext());
            view1.setText(idolGroup[position]);//텍스트입력
            view1.setTextSize(40.0f);//크기설정
            view1.setTextColor(Color.BLUE);//컬러설정

            //두번째 텍스트뷰 : 팀의 인원수를 표시
            TextView view2 = new TextView( getApplicationContext() );
            /*
            텍스트뷰에는 기본자료형으로 데이터를 삽입할 수 없으므로 정수를
            Boxing처리해서 삽입한다.
             */
            view2.setText(new Integer(teamCount[position]).toString());
            /* 만약 Boxing처리를 하지 않으면 실행시 런타임 에러가 발생한다. */
            view2.setTextSize(40.0f);
            view2.setTextColor(Color.RED);

            //리니어 레이아웃을 생성한 후 텍스트뷰를 추가한다.
            LinearLayout layout = new LinearLayout(getApplicationContext());
            layout.setOrientation(LinearLayout.VERTICAL);//세로형으로 선언
            layout.addView(view1);//뷰를 추가함.
            layout.addView(view2);
            return layout;
        }
    }
}