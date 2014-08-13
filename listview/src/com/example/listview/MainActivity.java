package com.example.listview;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {


    private ListView myLv;
    private SongsAdapter songsAdapter;

    private  List<Song> songs;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);

        myLv = (ListView) findViewById(R.id.my_lv);

        initSongs();

        songsAdapter = new SongsAdapter(this,songs);

        myLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Log.d("onItemClick","onItemClick");

                songs.get(i).name = "小栗子";

                // 重新设置adapter，便会重绘ListView。滚动条位置重置。
//                myLv.setAdapter(new SongsAdapter(MainActivity.this,songs));

                // 只改变adapter数据，则不会重绘ListView，会刷新。滚动条位置不变。
                songsAdapter.notifyDataSetChanged();


            }
        });

        myLv.setAdapter(songsAdapter);
    }


    private void initSongs(){

        songs = new ArrayList<Song>();

        Song song = new Song();
        song.name = "小苹果";

        Song song1 = new Song();
        song1.name = "小香蕉";

        Song song2 = new Song();
        song2.name = "小桃子";

        songs.add(song);
        songs.add(song1);
        songs.add(song2);

    }

}
