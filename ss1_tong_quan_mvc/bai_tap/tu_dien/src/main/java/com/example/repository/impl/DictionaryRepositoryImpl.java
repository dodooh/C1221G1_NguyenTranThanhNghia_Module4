package com.example.repository.impl;

import com.example.repository.IDictionaryRepository;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DictionaryRepositoryImpl implements IDictionaryRepository {

    private static Map<String, String> dictionary;
    static {
        dictionary = new HashMap<>();
        dictionary.put("hello", "Chao ban");
        dictionary.put("school", "Chao ban Truong");
        dictionary.put("haha", "cuoi");
        dictionary.put("huhu", "khoc");
    }

    @Override
    public String search(String word) {

        try {

            String url = "https://google-translate1.p.rapidapi.com/language/translate/v2";
            URL obj = new URL(url);

            Map<String,Object> params = new LinkedHashMap<>();
            params.put("q", word);
            params.put("target", "vi");
            params.put("source", "en");
            StringBuilder postData = new StringBuilder();
            for (Map.Entry<String,Object> param : params.entrySet()) {
                if (postData.length() != 0) postData.append('&');
                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }
            byte[] postDataBytes = postData.toString().getBytes("UTF-8");

            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
            conn.setRequestProperty("Accept-Encoding", "application/gzip");
            conn.setRequestProperty("X-RapidAPI-Host", "google-translate1.p.rapidapi.com");
            conn.setRequestProperty("X-RapidAPI-Key", "1fef91d560msh596419d7c9e7952p112d89jsn848542145597");

            conn.setRequestMethod("POST");
            System.out.println(conn.getRequestMethod());
            conn.setDoOutput(true);
            conn.getOutputStream().write(postDataBytes);
            System.out.println(conn);
            Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            System.out.println(conn.getResponseCode());
            String s = "";
                for (int c; (c = in.read()) >= 0;)
                     s += (char)c;
            try {
                JSONObject jsonObject = new JSONObject(s);
                JSONObject get1th = jsonObject.getJSONObject("data");
                JSONArray get2th = get1th.getJSONArray("translations");
                JSONObject text = (JSONObject) get2th.get(0);
                return text.getString("translatedText");
            }catch (JSONException err){
                System.out.println(err.getMessage());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
