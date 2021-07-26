package com.kosmo.a26listview03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "KOSMO123";
    //데이터 준비
    String[] idolGroup = {"엑소", "방탄소년단", "워너원", "뉴이스트", "갓세븐", "비투비", "빅스"};
    int[] teamCount  = { 9, 7, 11, 5, 7, 7, 6};
    int[] images = { R.drawable.idol1, R.drawable.idol2, R.drawable.idol3,
            R.drawable.idol4, R.drawable.idol5, R.drawable.idol6, R.drawable.idol7 };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MyAdapter adapter = new MyAdapter();
        ListView listView1 = findViewById(R.id.listView1);
        listView1.setAdapter(adapter);
        listView1.setOnItemClickListener(
            new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view,
                                        int i, long l) {
                    Log.i(TAG, "선택한index : "+ i);
                    Toast.makeText(getApplicationContext(),
                            idolGroup[i] +" 선택됨",
                            Toast.LENGTH_SHORT).show();
                }
            });
    }

    //커스텀 어뎁터 객체 정의
    class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return idolGroup.length;
        }
        @Override
        public Object getItem(int position) {
            return idolGroup[position];
        }
        @Override
        public long getItemId(int position) {
            return position;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //XML리소스 파일로 정의한 레이아웃을 사용하는 IdolView클래스의 객체생성
            IdolView idolView = new IdolView(getApplicationContext());
            //setter()를 통해 각각의 값을 설정
            idolView.setName(idolGroup[position]);
            idolView.setPerson(new Integer(teamCount[position]).toString());
            idolView.setImage(images[position]);
            //항목을 반환
            return idolView;
        }
    }
}