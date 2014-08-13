package com.example.listview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TechBirds
 * @date 14-8-13
 * @time 下午3:54
 * @vsersion 1.0
 */
public class SongsAdapter extends BaseAdapter {


    private LayoutInflater layoutInflater;
    private Context context;

    private List<Song> songs;

    public SongsAdapter(Context context, List<Song> songs) {

        this.songs = songs;
        this.context = context;
        this.layoutInflater =  LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return songs.size();
    }

    @Override
    public Song getItem(int i) {
        return songs.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;

        // 提升ListView运行效率
        // 1.重用view 2.重用ViewHolder
        if(view == null){

            view = layoutInflater.inflate(R.layout.lv_item,viewGroup,false);
            viewHolder = new ViewHolder();
            viewHolder.songNameTv = (TextView)view.findViewById(R.id.song_name_tv);
            viewHolder.clickBtn = (Button)view.findViewById(R.id.click_btn);
            view.setTag(viewHolder);

        }else{
            viewHolder = (ViewHolder)view.getTag();
        }


        Song song = getItem(i);

        viewHolder.songNameTv.setText(song.name);
        viewHolder.clickBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("clickBtn","clickBtn");

            }
        });

        return view;
    }


    class ViewHolder{

        private TextView songNameTv;
        private Button clickBtn;

    }

}
