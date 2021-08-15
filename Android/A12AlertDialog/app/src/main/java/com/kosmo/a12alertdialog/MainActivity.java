package com.kosmo.a12alertdialog;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //목록형 대화상자에서 사용
    private String[] sports = {"축구","야구","배구","농구"};
    //체크박스, 라디오 대화상자에서 사용
    private String[] girlGroup = {"투애니원", "소녀시대", "원더걸스", "블랙핑크"};
    //선택한 라디오 항목의 인덱스
    private int radio_index = -1;
    
    //선택한 체크박스의 항목 저장
    boolean[] which_checks = {false, true, false, true};

    //진행 대화상자 객체 생성
    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //버튼 위젯 가져오기
        Button btnAlertBasic = (Button)findViewById(R.id.btn_alert_basic);
        Button btnAlertCheck = (Button)findViewById(R.id.btn_alert_checkbox);
        Button btnAlertRadio = (Button)findViewById(R.id.btn_alert_radio);
        Button btnAlertList = (Button)findViewById(R.id.btn_alert_list);
        Button btnAlertProgress = (Button)findViewById(R.id.btn_alert_progress);
        Button btnCustom = (Button)findViewById(R.id.btn_alert_custom);


        //진행대화창 객체생성
        progress = new ProgressDialog(this);
        progress.setCancelable(false);
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER); //로딩이미지
        progress.setIcon(android.R.drawable.ic_menu_day); //기본 아이콘 사용
        progress.setTitle("KOSMO 여러분들");
        progress.setMessage("열심히 공부하는 중입니다.");

        btnAlertProgress.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //버튼을 눌렀을 때 대화상자가 열려있지 않을때만 보임처리
                if (!progress.isShowing()) {
                    progress.show();
                }

                //2초간 대기 후 진행창 닫기
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // .dismiss(), .cancel() 두가지가 크게 차이가 없으므로 둘중 아무거나 사용
                        progress.dismiss(); //열린상태이면 닫아줌.
                        //progress.cancel(); //무조건 닫아줌. 
                    }
                }, 2000);
            }
        });


        //기본 대화상자
        btnAlertBasic.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertBasic =
                    new AlertDialog.Builder(v.getContext());
                alertBasic.setCancelable(false)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("대화상자제목")
                    .setMessage("여기는 메세지가 들어갑니다")
                    .setPositiveButton("확인버튼", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(MainActivity.this,
                                    "확인클릭합니다",
                                    Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("취소버튼", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(MainActivity.this,
                                    "취소클릭합니다",
                                    Toast.LENGTH_SHORT).show();
                        }
                    })
                    .show();
            }
        });


        /*
        목록형 대화상자 : 항목중 하나만 선택가능.
            .setItem(목록에 출력할 배열, 리스너)
                : 배열이 항목에 출력되고 항목을 클릭할 경우, 바로 리스너가 감지하여 콜백함.
                  콜백메소드쪽으로 선택한 항목의 인덱스가 전달됨.

        */
        btnAlertList.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(view.getContext())
                    .setCancelable(false)
                    .setIcon(android.R.drawable.ic_lock_power_off)
                    .setTitle("당신이 좋아하는 스포츠는?")
                    .setItems(sports, new DialogInterface.OnClickListener() {

                        //항목을 클릭할 때 즉시 콜백되어 which를 통해 인덱스가 전달됨.
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this, sports[which],
                                    Toast.LENGTH_SHORT).show();;
                        }
                    })
                    .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this, "목록취소함",
                                    Toast.LENGTH_SHORT).show();
                        }
                    })
                    .show();
            }
        });


        /*
        라디오형 대화상자 : 항목중 하나만 선택가능
            .setSingleChoiceItems(배열, 디폴트로 선택할 인덱스, 리스너)
                두번째 매개변수를 마이너스로 지정하면 선택항목이 없는 상태로
                대화창이 설정된다.
         */
        btnAlertRadio.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(v.getContext())
                    .setIcon(android.R.drawable.ic_dialog_email)
                    .setTitle("당신이 좋아하는 걸그룹은?")
                    .setSingleChoiceItems(girlGroup, radio_index,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //라디오항목을 선택함으로써 전달된 which값을 저장
                                //라디오 항목을 선택했을 때 인덱스가 콜백됨.
                                radio_index = which;
                            }
                        })
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // OK버튼을 누르면 선택한 항목을 토스트로 띄워준다.
                            Toast.makeText(MainActivity.this,
                                girlGroup[radio_index],
                                Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this,
                                "취소하셨습니다.",
                                Toast.LENGTH_SHORT).show();
                        }
                    })
                    .show();
            }
        });


        /*
        체크박스형 대화상자 : 여러개의 항목을 선택할 수 있는 대화상자
            setMultiChoiceItems(배열, 디폴트로 선택될 항목의 boolean값을 담은 배열, 리스너)
                현재 멤버변수로 which_checks가 선언되어 있음.
         */
        btnAlertCheck.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(v.getContext())
                        .setIcon(android.R.drawable.ic_dialog_dialer)
                        .setTitle("당신이 좋아하는 걸그룹은?(여러개 선택)")
                        .setMultiChoiceItems(girlGroup, which_checks,
                                new DialogInterface.OnMultiChoiceClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface,
                                                        int i, boolean b) {
                                        /*
                                        체크박스의 경우, 하나의 항목을 지속적으로 클릭하여
                                        check 혹은 uncheck를 할 수 있으므로 i를 통해 인덱스가 저장되고
                                        b를 통해 check된 상태가 전달됨.
                                         */
                                        Toast.makeText(MainActivity.this,
                                                String.format("which:%d, isChecked:%b",i,b),
                                                Toast.LENGTH_SHORT).show();
                                        //해당 인덱스의 체크박스를 check/uncheck상태로 변경함.
                                        which_checks[i] = b;
                                    }
                                })
                        .setPositiveButton("예스!", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface,int i) {
                                /*
                                항목 체크 후, OK버튼을 누르면 체크된 항목을 StringBuffer 객체에 저장한 후
                                토스트로 출력한다.
                                 */
                                StringBuffer buf = new StringBuffer();
                                for(int x=0 ; x<girlGroup.length ; x++)
                                {
                                    if(which_checks[x]==true)
                                        buf.append(girlGroup[x]+",");
                                }
                                Toast.makeText(MainActivity.this,
                                        buf, Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton("놉", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface,int i) {
                                Toast.makeText(MainActivity.this,
                                        "놉 버튼을 클릭했습니다",
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });


        /*
        커스텀 대화상자
        순서]
            1. layout폴더에 사용자가 정의한 대화상자 xml파일을 생성한다.
            2. inflate()를 통해 레이아웃 인플레이트(전개)한다.
            3. Builder객체를 통해 대화창을 설정할때 setView() 생성자를 통해
                2번에서 전개한 레이아웃을 대화상자에 적용한다.
         */
        btnCustom.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //커스텀 레이아웃을 화면에 전개한다.
                View view = getLayoutInflater().inflate(R.layout.custom_dialog, null);

                //입력상자를 얻어옴
                final EditText sportTxt = (EditText)view.findViewById(R.id.sport_txt);

                //대화창 객체를 생성한다.
                new AlertDialog.Builder(v.getContext())
                    .setView(view) //커스텀뷰를 대화상자에 적용
                    .setIcon(android.R.drawable.ic_media_play)
                    .setTitle("커스텀 대화상자")
                    .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //확인을 눌렀을때는 입력한 내용을 출력함.
                            //대화창에 입력한 내용을 얻어와서 토스트로 출력
                            Toast.makeText(MainActivity.this,
                                sportTxt.getText(),
                                Toast.LENGTH_LONG).show();
                        }
                    })
                    .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this, "취소를 눌렀습니다.",
                                Toast.LENGTH_SHORT).show();
                        }
                    })
                    .show();
            }
        });
    }
}