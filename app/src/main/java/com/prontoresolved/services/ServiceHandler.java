package com.prontoresolved.services;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

/**
 * Created by nageshk on 11/9/2017.
 */
public class ServiceHandler {
    static String response = null;
    public final static int GET = 1;
    public final static int POST = 2;

    public ServiceHandler() {

    }

    /**
     * Making service call
     *
     * @url - url to make request
     * @method - http request method
     * */
    public String makeServiceCall(String url, int method) {
        return this.makeServiceCall(url, method, null);
    }

    /**
     * Making service call
     *
     * @url - url to make request
     * @method - http request method
     * @params - http request params
     * */
    public String makeServiceCall(String url, int method, String params) {
        try {

            HttpParams httpParameters = new BasicHttpParams();
            int timeoutConnection = 360000;
            HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);
            int timeoutSocket = 420000;
            HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);

            // http client
            DefaultHttpClient httpClient = new DefaultHttpClient(httpParameters);
            HttpEntity httpEntity = null;
            HttpResponse httpResponse = null;

            StringEntity se = new StringEntity(params, HTTP.UTF_8);

            // Checking http request method type
            if (method == POST) {





                HttpPost httpPost = new HttpPost(url);
                // adding post params
                if (params != null) {
                    httpPost.setHeader("Content-Type",
                            "application/json; charset=utf-8");
                    httpPost.setEntity(se);
                }

                httpResponse = httpClient.execute(httpPost);

            } else if (method == GET) {
                // appending params to url
				/*
				 * if (params != null) { String paramString = URLEncodedUtils
				 * .format(params, "utf-8"); url += "?" + paramString; }
				 */
                HttpGet httpGet = new HttpGet(url);

                httpResponse = httpClient.execute(httpGet);

            }
            httpEntity = httpResponse.getEntity();
            response = EntityUtils.toString(httpEntity);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            //e.printStackTrace();
            return "IOE";
        }

        return response;

    }

}
