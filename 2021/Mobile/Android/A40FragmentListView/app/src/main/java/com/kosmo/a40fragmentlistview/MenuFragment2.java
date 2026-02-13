package com.kosmo.a40fragmentlistview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MenuFragment2 extends Fragment {

    public static final String TAG = "iKosmo";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "MenuFragment2 > onCreateView()");
        View view = inflater.inflate(R.layout.menu_fragment2, container, false);

        ((Button)view.findViewById(R.id.button2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Toast.makeText(view.getContext(),
                        "두번째 프레그먼트 입니다.",
                        Toast.LENGTH_LONG).show();*/

                /*
                커스텀 토스트 : 기본 형식이 아닌 커스텀을 위해서는 별도의 xml파일이
                    필요하다. 레이아웃을 디자인 한 후 inflate하고 필요한 옵션을
                    추가한다.
                 */
                View ct = View.inflate(view.getContext(), R.layout.custom_toast, null);
                TextView textView = ct.findViewById(R.id.message_tv);
                textView.setText("토스트도 커스텀 되네요");//텍스트 설정
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);//크기 설정
                textView.setTextColor(Color.BLACK);//컬러 설정

                Toast toast = new Toast(view.getContext());//토스트 객체 생성
                toast.setDuration(Toast.LENGTH_LONG);//메시지를 띄울 시간
                toast.setView(ct);//커스텀 레이아웃 설정
                toast.show();//메세지 띄우기
            }
        });

        return view;
    }
}
