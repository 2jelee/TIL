package com.kosmo.a46fcm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "iKosmo";
    TextView txLog;
    String regId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txLog = (TextView) findViewById(R.id.log);

        Intent intent = getIntent();
        if(intent!=null && intent.getExtras()!=null){
            for(String key : getIntent().getExtras().keySet()){
                String value = getIntent().getExtras().getString(key);
                txLog.append("Noti - "+ key +":"+ value + "\n");
            }
            txLog.append("알림 메세지가 왔습니다.\n");

            String contents = intent.getStringExtra("message");
            if(contents!=null){
                processIntent(contents);
            }
        }

        getRegistrationId();
    }

    //전달된 데이터를 텍스트뷰에 출력
    public void println(String data){
        txLog.append(data + "\n");
    }
    public void processIntent(String contents){
        println("DATA :"+ contents);
    }

    //파이어베이스에서 토큰값을 얻어와서 출력
    public void getRegistrationId(){
        println("getRegistrationId() 호출됨");

        regId = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "regId : "+ regId);
        println("regId : "+ regId);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if(intent!=null){
            String contents = intent.getStringExtra("message");
            processIntent(contents);
        }
    }
}