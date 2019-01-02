package com.bwei.liyuekun20190102.HttpUrl;

import android.content.Context;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HttpUtil {
    public static String HttpConn(Context context,String path,String mRam){
        String message="";
        try {
            URL url = new URL(path);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod(mRam);
            urlConnection.setConnectTimeout(5*1000);
            urlConnection.setReadTimeout(5*1000);
            InputStream inputStream = urlConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String str;
            StringBuffer buffer = new StringBuffer();
            if ((str=reader.readLine())!=null){
                buffer.append(str);
            }
            message=buffer.toString().trim();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }
}
