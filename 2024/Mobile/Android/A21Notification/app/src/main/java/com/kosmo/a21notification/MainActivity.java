package com.kosmo.a21notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    //각 알림을 식별하는 정수형 상수
    public static final int NOTIFICATION_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendNotification(View view) {

        //알림바를 클릭했을 때 이동할 액티비티를 설정
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com/"));
        //intent 생성시 즉시 띄우지 않고 우선 준비만(새로울 페이지로 이동할) 해놓음.
        PendingIntent pendingIntent =
                PendingIntent.getActivity(this, 0, intent, 0);

        //노티 매니저 객체 생성 및 빌더객체 생성
        NotificationManager notificationManager =
                (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        Notification.Builder builder;

        //targetSdkVersion 26(Android 8.0 Oreo) 이상에서는 채널을 설정해주지 않으면 알림창이 뜨지 않으므로
        //Android 8.0(Oreo, API26)이상인 경우 채널 생성
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            //아래는 채널 생성을 위한 패턴
            NotificationChannel notificationChannel = new NotificationChannel("kosmo_id", "kosmo_name",
                    NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.setDescription("코스모 채널입니다.");
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.GREEN);
            notificationChannel.enableVibration(true);
            notificationChannel.setVibrationPattern(new long[]{100, 200, 100, 200});
            notificationChannel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

            notificationManager.createNotificationChannel(notificationChannel);
            
            //채널 생성 시 사용된 채널ID를 인자로 받아서 노티빌더 객체를 생성
            builder = new Notification.Builder(this, "kosmo_id");
        }
        else {
            //Android 7.0(Nougat, API25) 이하일때는 채널 생성필요 X
            builder = new Notification.Builder(this);
        }
        //알림바에 표시되는 아이콘
        builder.setSmallIcon(R.drawable.android);
        //사용자가 알림바를 클릭할 때 실행할 인텐트 지정(여기서는 구글로 이동)
        builder.setContentIntent(pendingIntent);
        //알림바에 표시되는 큰 아이콘
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),
                R.drawable.android));
        //알림제목
        builder.setContentTitle("알려드립니다.");
        //알림내용
        builder.setContentText("서울지역에 호우경보가 발령되었습니다.");
        //알림의 서브메세지로 Android4.1(Jellybin, API26)이상에서만 표시됨
        builder.setSubText("구글에서 날씨정보를 검색하세요!");
        /*
        알림방법]
            DEFAULT_SOUND : 알림소리 O(단말에 설정된 사운드)
            DEFAULT_VIBRATE : 진동으로 알려줌
         */
        builder.setDefaults(Notification.DEFAULT_SOUND);
        /*
        알림바를 클릭했을 때 상태바에서 제거할지 여부
            true : 클릭했을때 제거
            false : 클릭해도 제거되지 않고 유지됨
         */
        builder.setAutoCancel(true);

        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }
}