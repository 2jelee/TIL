package com.kosmo.a28gridview02;


import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

//BaseAdapter를 상속하여 커스텀어뎁터 클래스를 생성
public class CustomAdapter extends BaseAdapter {

    //메인액티비티에서 어댑터 생성시 매개변수로 전달되는 값 사용
    private Context context;//컨텍스트는 메인액티비티가 됨
    private String[] movies;//영화제목
    private int[] resIds;//영화포스터의 아이디 값(정수형 배열로 선언해야함)
    public CustomAdapter(Context context, String[] movies, int[] resIds){
        this.context = context;
        this.movies  = movies;
        this.resIds  = resIds;
    }

    @Override
    public int getCount() {
        return movies.length;
    }

    @Override
    public Object getItem(int position) {
        return movies[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if(convertView==null){
            /*
            생성된 아이템 레이아웃이 없을경우 xml레이아웃 파일을 통해
            인플레이트(전개) 처리한다.
             */
            LayoutInflater inflater=(LayoutInflater)context.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.movie_item, null);
        }
        //레이아웃 전개후 위젯을 가져와서 인덱스에 해당하는 데이터를 설정한다.
        //영화포스터
        ImageView movieImage = (ImageView)convertView.findViewById(R.id.movieImg);
        movieImage.setImageResource(resIds[position]);
        //영화제목
        final TextView movieTitle = (TextView)convertView.findViewById(R.id.movieTitle);
        movieTitle.setText(movies[position]);

        //커스텀 어뎁터의 getView() 메소드 내에서 리스너 부착
        movieImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater inflater=(LayoutInflater)context.getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE);
                View view=inflater.inflate(R.layout.dialog_layout,null);

                //다이얼로그용 이미지에 클릭한 해당 이미지 설정
                ImageView image=(ImageView)view.findViewById(R.id.moviedialog);
                image.setImageResource(resIds[position]);

                //다이얼로그 생성]setView(dialogview)로 위에서 전개한 뷰를
                // 다이얼로그에 설정
                new AlertDialog.Builder(context)
                        .setTitle(movies[position])
                        .setIcon(android.R.drawable.ic_dialog_email)
                        .setView(view)
                        .setPositiveButton("OK",null)
                        .show();

            }
        });

        return convertView;
    }
}

 