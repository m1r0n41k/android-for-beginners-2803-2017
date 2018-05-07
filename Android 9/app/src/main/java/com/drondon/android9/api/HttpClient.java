package com.drondon.android9.api;

import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

public class HttpClient {
    private static final String TAG = "HttpClient_";

    public String request(String urlStr) throws IOException, URISyntaxException {
        URL url = new URL(urlStr);
        String schema = url.toURI().getScheme();
        Log.d(TAG, "request: to url: " + urlStr + ", schema: " + schema);

        URLConnection connection = url.openConnection();
        InputStream is = connection.getInputStream();

        InputStreamReader reader = new InputStreamReader(is);

        int data = reader.read();

        StringBuilder builder = new StringBuilder();

        while (data != -1) {
            builder.append((char) data);
            data = reader.read();
        }

        return builder.toString();
    }
}
