package com.kosmo.a45googlemap03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "iKosmo";
    SupportMapFragment mapFragment;
    GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                Log.d(TAG, "GoogleMap is ready.");
                map = googleMap;

                //서울의 대표위치(서울 시청)
                LatLng SEOUL = new LatLng(37.56, 126.97);
                //가산디지털단지역
                LatLng GASAN = new LatLng(37.480379, 126.882744);

                //마커를 출력할 위치를 문자열 배열로 저장
                String[] areaTitles = {"지역1","지역2","지역3","지역4","지역5"};
                ArrayList<LatLng> locations = new ArrayList<>();
                locations.add(new LatLng(37.480280, 126.882356));
                locations.add(new LatLng(37.480135, 126.881015));
                locations.add(new LatLng(37.476967, 126.882319));
                locations.add(new LatLng(37.480280, 126.888912));
                locations.add(new LatLng(37.487497, 126.885145));
                //반복문으로 마커 추가
                for(int i=0 ; i<areaTitles.length ; i++){
                    MarkerOptions markerOptions = new MarkerOptions();
                    markerOptions.position(locations.get(i));
                    markerOptions.title(areaTitles[i]);
                    markerOptions.snippet("여기는 "+ areaTitles[i]);

                    map.addMarker(markerOptions);
                }
                //애니메이션 효과가 있는 카메라를 통해 "가산"으로 이동
                map.animateCamera(CameraUpdateFactory.newLatLngZoom(GASAN, 15));
                map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                //마커에 리스너 부착
                map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(Marker marker) {
                        //타이틀과 위치를 토스트로 출력
                        Toast.makeText(getApplicationContext(),
                                "Marker클릭:"+marker.getTitle()+"\n"
                                        +marker.getPosition(),
                                Toast.LENGTH_SHORT).show();

                        return false;
                    }
                });
                //인포윈도우에 리스너 부착
                map.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                    @Override
                    public void onInfoWindowClick(Marker marker) {
                        //타이틀과 출력정보를 토스트로 출력
                        Toast.makeText(getApplicationContext(),
                                "InfoWindow클릭:"+marker.getTitle()+"\n"
                                        +marker.getSnippet(),
                                Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });////getMapAsync

        try {
            MapsInitializer.initialize(this);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }////onCreate
}

