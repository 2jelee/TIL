package com.kosmo.a20edittext;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "KOSMO123";

    TextView textView1;
    EditText etId;
    EditText etPwd;
    EditText etYear;
    EditText etMonth;
    EditText etDay;
    String sId;
    String sPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = findViewById(R.id.textView1);
        etId = findViewById(R.id.etId);
        etPwd = findViewById(R.id.etPwd);
        etYear = findViewById(R.id.etYear);
        etMonth = findViewById(R.id.etMonth);
        etDay = findViewById(R.id.etDay);
        //비밀번호 입력상자에 텍스트가 변경될때의 리스너를 부착한 후 Watcher를 연결한다.
        etPwd.addTextChangedListener(watcher);
    }

    TextWatcher watcher = new TextWatcher() {
        String beforeText;
        //텍스트가 변경되는 중..
        public void onTextChanged(CharSequence str, int start, int before, int count) {
            byte[] bytes = null;
            try {
                //한글 깨짐 처리
                //bytes = str.toString().getBytes("KSC5601");
                bytes = str.toString().getBytes("8859_1");
                //입력한 텍스트의 길이를 얻어와서..
                int strCount = bytes.length;
                //텍스트뷰에 설정
                textView1.setText(strCount + " / 8 바이트");
            }
            catch(UnsupportedEncodingException ex) {
                ex.printStackTrace();
            }
        }
        //텍스트가 변경되기 전..
        public void beforeTextChanged(CharSequence str, int start, int count, int after) {
            //입력전 텍스트를 얻어와서 로그켓에 출력
            beforeText = str.toString();
            Log.d(TAG, "beforeTextChanged : " + beforeText);
        }
        //텍스트가 변경된 이후..
        public void afterTextChanged(Editable strEditable) {
            String str = strEditable.toString();
            Log.d(TAG, "afterTextChanged : " + str);
            try {
                byte[] strBytes = str.getBytes("8859_1");
                if(strBytes.length > 8) {
                    etPwd.setText(beforeText);
                    /*
                    글자수가 8자를 넘었을때 텍스트를 지정한만큼 블럭으로 지정하여 더이상
                    입력할 수 없도록 만들어준다. setSelection(시작, 끝) 형태로 지정한다.
                     */
                    etPwd.setSelection(0, beforeText.length()-1);
                    //etPwd.setSelection(beforeText.length()-3, beforeText.length()-1);
                }
            }
            catch(Exception ex) {
                ex.printStackTrace();
            }
        }
    };

    //키보드 내리기 버튼
    public void onKeydownClicked(View v) {
        InputMethodManager mgr =
                (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }

    //로그인 버튼을 누를경우 간단한 폼값 체킹
    public void onLoginClicked(View v) {
        //입력상자에 입력된 텍스트를 얻어와서 문자열로 변경한 후
        sId  = etId.getText().toString();
        sPwd = etPwd.getText().toString();

        if (sId.length() < 3) {
            //3글자 미만인 경우 경고창 띄워줌
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("알림")
                    .setMessage("아이디를 입력해 주세요")
                    .setCancelable(false)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setPositiveButton("닫기", null)
                    .show();
            etId.requestFocus();//포커스 이동(JS의 focus()와 동일함)
            return;
        }
        else if (sPwd.length() < 5 ) {
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("알림")
                    .setMessage("비밀번호를 정확히 입력해 주세요")
                    .setCancelable(false)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setPositiveButton("닫기", null)
                    .show();
            etPwd.requestFocus();
            return;
        }
    }
}