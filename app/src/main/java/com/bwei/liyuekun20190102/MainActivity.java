package com.bwei.liyuekun20190102;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.bwei.liyuekun20190102.HttpUrl.HttpUtil;
import com.bwei.liyuekun20190102.HttpUrl.MyAsync;
import com.bwei.liyuekun20190102.adapter.MyBaseAdapter;
import com.bwei.liyuekun20190102.bean.User;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private GridView grid_view;
    private MyBaseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grid_view = findViewById(R.id.grid_view);
        new Async().execute();
        grid_view.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                grid_view.removeView(view);
                adapter.notifyDataSetChanged();
                return true;
            }
        });
        grid_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
    class Async extends AsyncTask<Integer,Integer,String>{
        @Override
        protected String doInBackground(Integer... integers) {
            return HttpUtil.HttpConn(MainActivity.this,"http://www.zhaoapi.cn/product/getProductDetail?pid=21","GET");
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Gson gson = new Gson();
            User user = gson.fromJson(s, User.class);
            List<User.DataBean> beans;
            beans= (List<User.DataBean>) user.getData();
            adapter = new MyBaseAdapter(MainActivity.this, beans);
            grid_view.setAdapter(adapter);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
    }
}
