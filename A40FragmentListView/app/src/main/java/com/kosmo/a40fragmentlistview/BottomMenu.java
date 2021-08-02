package com.kosmo.a40fragmentlistview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//Fragment 클래스를 상속한 하단의 메뉴 부분
public class BottomMenu extends Fragment {

    private static String TAG = "iKosmo";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "BottomMenu Class > onCreateView() called..");
        return inflater.inflate(R.layout.bottom_menu, container, false);
    }
}
