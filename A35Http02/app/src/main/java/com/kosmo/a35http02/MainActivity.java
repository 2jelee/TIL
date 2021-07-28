package com.kosmo.a35http02;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    String TAG = "iKOSMO";

    //전역변수
    EditText user_id, user_pw;
    TextView textResult;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //위젯 얻어오기
        textResult = (TextView)findViewById(R.id.text_result);
        user_id = (EditText)findViewById(R.id.user_id);
        user_pw = (EditText)findViewById(R.id.user_pw);
        Button btnLogin = (Button)findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                new AsyncHttpServer().execute(
                    "",
                    "id="+user_id.getText().toString(),
                    "pass="+user_pw.getText().toString()
                );
            }
        });
        dialog = new ProgressDialog(this);
        dialog.setCancelable(true);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER)
        dialog.setIcon(android.R.drawable.ic_dialog_email);
        dialog.setTitle("로그인 처리중");
        dialog.setMessage("서버로부터 응답을 기다리고 있습니다.");
    }

    class AsyncHttpServer extends AsyncTask<String, Void, String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            //응답대기 대화창
            if(!dialog.isShowing()) dialog.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            StringBuffer receiveData = new StringBuffer();

            try{
                URL url = new URL(strings[0]);
                HttpURLConnection conn=
            }
        }
    }
}