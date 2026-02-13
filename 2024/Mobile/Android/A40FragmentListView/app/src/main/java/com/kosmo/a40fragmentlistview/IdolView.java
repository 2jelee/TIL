package com.kosmo.a40fragmentlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class IdolView extends LinearLayout {

    TextView textView1;
    TextView textView2;
    /*
    리니어 레이아웃을 상속한 후 생성자에서 레이아웃을 inflate처리 하고,
    텍스트뷰를 얻어온 후 필요한 데이터 삽입 처리함.
     */
    public IdolView(Context context) {
        super(context);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.idol_view, this, true);

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
    }

    public void setName(String name) {
        textView1.setText(name);
    }
    public void setPerson(String pCount) {
        textView2.setText(pCount);
    }
}
