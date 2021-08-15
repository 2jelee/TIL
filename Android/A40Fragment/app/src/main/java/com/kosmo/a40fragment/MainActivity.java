package com.kosmo.a40fragment;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    //프레그먼트 관리자 및 자바코드로 교체할 프레그먼트 객체 선언
    FragmentManager fragmentManager;
    MyFragment1 myFragment1;
    MyFragment2 myFragment2;
    MyFragment3 myFragment3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //상단영역의 프레그먼트에 정의된 버튼을 가져와서 리스너 부착
        Button btn1Frag = (Button) findViewById(R.id.btnFirstFragment);
        Button btn2Frag = (Button) findViewById(R.id.btnSecondFragment);
        Button btn3Frag = (Button) findViewById(R.id.btnThirdFragment);
        btn1Frag.setOnClickListener(listener);
        btn2Frag.setOnClickListener(listener);
        btn3Frag.setOnClickListener(listener);

        //프레그먼트 교체를 위한 메니져 객체생성
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //각 부분화면을 전담할 프레그먼트 객체생성
        myFragment1 = new MyFragment1();
        myFragment2 = new MyFragment2();
        myFragment3 = new MyFragment3();

        //첫번째 프레그먼트로 Bundle객체를 통해 데이터를 전달한다.
        Bundle bundle = new Bundle();
        bundle.putString("KOSMO", "한국소프트웨어인재개발원");
        myFragment1.setArguments(bundle);//프레그먼트1로 데이터를 전송한다.

        /*
        앱이 첫실행일때 fragment1을 화면에 즉시 적용한다.
        replace()는 교체, commit()은 적용을 의미한다.
         */
        fragmentTransaction.replace(R.id.bottomLayout, myFragment1).commit();
    }////onCreate


    //프레그먼트 전환 버튼에 리스너 처리
    View.OnClickListener listener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            /*
            버튼 클릭시 전달된 View객체를 통해 리소스 아이디를 가져올수 있다.
            버튼을 아이디로 구분하여 해당 프레그먼트로 교체 및 적용한다.
             */
            if(view.getId()==R.id.btnFirstFragment){
                fragmentManager.beginTransaction()
                        .replace(R.id.bottomLayout, myFragment1).commit();
            }
            else if(view.getId()==R.id.btnSecondFragment){
                fragmentManager.beginTransaction()
                        .replace(R.id.bottomLayout, myFragment2).commit();
            }
            else if(view.getId()==R.id.btnThirdFragment){
                fragmentManager.beginTransaction()
                        .replace(R.id.bottomLayout, myFragment3).commit();
            }
        }
    };

    //프레그먼트 1,2는 내부클래스로 정의한다.
    public static class MyFragment1 extends Fragment {
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            /*
            자바코드로 프레그먼트를 붙힐경우 세번째 인자는 fasle로 기술한다.
            그렇지 않으면 ANR(앱 응답없음)이 발생한다.
             */
            View view = inflater.inflate(R.layout.my_fragment1,
                    container, false);

            Button button1 = view.findViewById(R.id.button1);
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    /*
                    프레그먼트 교체시 번들객체를 통해 전달되었던 데이터를 아래와
                    같이 받을수 있다.
                     */
                    Bundle bundle = getArguments();//번들객체를 받은 후...
                    String value = bundle.getString("KOSMO");//key값으로 value을 얻어옴.
                    Toast.makeText(view.getContext(), value,
                            Toast.LENGTH_LONG).show();
                }
            });

            return view;
        }
    }
    public static class MyFragment2 extends Fragment {
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            View view = inflater.inflate(R.layout.my_fragment2, container, false);

            ((Button)view.findViewById(R.id.button2)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(),
                            "두번째 프레그먼트 입니다.",
                            Toast.LENGTH_LONG).show();
                }
            });

            return view;
        }
    }
}////MainActivity