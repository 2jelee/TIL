package com.kosmo.a08datetimepicker;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    //멤버변수
    Calendar calendar; //캘린더 클래스 (역할 : 시간, 날짜 생성)
    TextView date_tv, time_tv; //텍스트 뷰를 사용하기 위한 변수 (시간, 날짜 표시)
    int yearStr, monthStr, dayStr; //현재날짜
    int hourStr, minuteStr, secondStr; //현재시간

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //텍스트 뷰 위젯 얻어오기
        date_tv = (TextView)findViewById(R.id.date_tv);
        time_tv = (TextView)findViewById(R.id.time_tv);

        //Calendar 클래스를 이용하여 현재의 날짜, 시간을 생성하기 위한 객체 생성
        calendar = Calendar.getInstance(); //Calendar >> 대표적으로 생성자가 없는 메소드이므로 getInstance() 사용 

        yearStr = calendar.get(calendar.YEAR); 
        monthStr = calendar.get(calendar.MONTH); 
        dayStr = calendar.get(calendar.DATE);
        hourStr = calendar.get(calendar.HOUR_OF_DAY);
        minuteStr = calendar.get(calendar.MINUTE);
        secondStr = calendar.get(calendar.SECOND);

        //현재 날짜와 시간을 텍스트뷰에 설정
        date_tv.setText(yearStr + "년" + (monthStr+1) + "월" + dayStr + "일");
        time_tv.setText(hourStr + "시" + minuteStr + "분" + secondStr + "초");

        //날짜선택 버튼에 리스너 부착
        Button btn_datepicker = (Button)findViewById(R.id.btn_datepicker);

        btn_datepicker.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    /*
                    해당 버튼을 누르면 데이트피커 대화창을 띄워줌.
                    형식] new DatePickerDialog(
                                대화창을 띄울 컨텍스트, 리스너, 설정할 연, 월, 일).show()

                    ※ 리스너는 내부, 외부 어디든 설정 가능함!
                    **show()가 있어야 대화창을 띄울 수 있다.
                     */
                    DatePickerDialog dialog = new DatePickerDialog(
                            v.getContext(),
                            listener,
                            yearStr, monthStr, dayStr
                    );
                    dialog.show(); //객체생성 후 show()메소드를 통해 화면에 출력함.
                }
            });
        
        //시간선택 버튼을 눌렀을 때의 리스너 부착
        Button btn_timepiker = (Button)findViewById(R.id.btn_timepicker);
        btn_timepiker.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*
                    버튼 클릭 시 타임피커 대화창을 띄워줌.

                    형식] new TimePickerDialog(컨텍스트, 리스너, 설정할 시간, 분, 24시간 포맷).show();
                    ※ 24시간 포맷은 => true(24시간제로 표시), false(12시간제로 표시)
                     */
                    new TimePickerDialog(
                        v.getContext(),
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                //확인버튼 눌렀을때 처리
                                //선택한 시간을 텍스트뷰와 토스트로 출력함.
                                time_tv.setText(
                                    String.format("설정된 시간%n%d시 %d분",
                                    hourOfDay, minute));

                                Toast.makeText(getApplicationContext(),
                                    String.format("설정된 시간%n%d시 %d분",
                                        hourOfDay, minute),
                                        Toast.LENGTH_LONG).show();
                            }
                        },
                        hourStr,
                        minuteStr,
                        true
                    ).show();
                }
            }
        );
    } ////onCreate 끝
    
    //데이트피커에서 날짜를 선택한 후 확인 버튼을 눌렀을 때를 감지하는 리스너 선언
    private DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            //사용자가 선택한 날짜를 텍스트뷰에 설정함
            date_tv.setText(
                String.format("설정된 날짜%n%d년 %d월 %d일", year, (month+1), dayOfMonth));
            //Calender 클래스를 통해 반환받은 월을 0~11까지이므로 +1을 해야 현재 달을 출력할 수 있다.

            //선택한 날짜를 토스트로 확인
            Toast.makeText(getApplicationContext(),
                year+"년"+(month+1)+"월"+dayOfMonth+"일",
                Toast.LENGTH_LONG).show();
        }
    };
} //// 메인 class 끝