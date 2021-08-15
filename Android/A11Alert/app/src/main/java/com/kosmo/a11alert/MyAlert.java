package com.kosmo.a11alert;

import android.app.AlertDialog;
import android.content.Context;
import android.view.Gravity;
import android.widget.TextView;

//public static >> 클래스명으로 직접 호출 가능하다는 의미
public class MyAlert {

    //1번 경고창 : 타이틀. 내용, 확인버튼 있음
    public static void AlertShow(Context context, String msg, String title) {
        //경고창을 띄우기 위한 객체 생성
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        //아이콘 설정(기본 이미지 사용)
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setTitle(title); //제목설정
        /*
        AlertDialog를 띄운 상태에서 Back버튼을 눌렀을때 대화창이 닫히지 않게 해준다.
        TRUE로 지정된 경우에는 닫히게 된다.
        또한, 여백을 눌러도 닫히게 된다.
         */
        builder.setCancelable(false); //안드로이드의 물리적 Back버튼에 대한 동작방식 설정
        builder.setMessage("\n"+msg+"\n"+"Back버튼 동작안함");
        builder.setPositiveButton("확인", null); //확인버튼
        //위에서 설정한 내용으로 대화창을 생성하고 화면에 설정한다.
        AlertDialog alert = builder.create();
        alert.show();

        // AlertDialog의 가운데 정렬을 위한 setting
        // Must call Show() prior to fetching text view
        /*
        아래 부분은 메세지를 가운데 정렬하기 위한 코드이다.
        만약 주석으로 처리하면 좌측 정렬이 된다.
        */
        /*
        TextView messageView = (TextView)alert.findViewById(android.R.id.message);
        messageView.setGravity(Gravity.CENTER);
        */
    }

    //2번 경고창 : 내용만 있음. '오버로딩'해서 메소드 정의함.
    public static void  AlertShow(Context context, String msg){

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(true); //back버튼을 누렀을때 대화창이 닫힘
        builder.setMessage("\n"+msg+"\n"+"Back버튼으로 닫힘"); //메세지 설정
        builder.setPositiveButton("확인", null); //확인버튼

        AlertDialog alert = builder.create();
        alert.show();

        //Alert 창에 출력되는 메세지를 가운데 정렬함.
        TextView messageView = (TextView)alert.findViewById(android.R.id.message);
        messageView.setGravity(Gravity.CENTER);
    }
}
