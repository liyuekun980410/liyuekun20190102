package com.bwei.liyuekun20190102.HttpUrl;

import android.content.Context;
import android.os.AsyncTask;

import okhttp3.Callback;

public class MyAsync {
    String mPath;
    Context mContext;
    String mRam;
    private TaskListener taskListener;

    public MyAsync setTaskListener(TaskListener taskListener) {
        this.taskListener = taskListener;
        return this;
    }
    public MyAsync(String mPath, Context mContext, String mRam) {
        this.mPath = mPath;
        this.mContext = mContext;
        this.mRam = mRam;
    }

    public class MyTask<T> extends AsyncTask<T,T,String>{
        @Override
        protected String doInBackground(T... ts) {
            return HttpUtil.HttpConn(mContext,mPath,mRam);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (s!=null){
                taskListener.result(s);
            }
        }
    }
    public interface TaskListener{
        void result(String t);
    }
}
