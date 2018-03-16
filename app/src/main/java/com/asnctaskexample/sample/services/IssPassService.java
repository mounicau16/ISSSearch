package com.asnctaskexample.sample.services;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.asnctaskexample.sample.api.PassTimesResponse;
import com.asnctaskexample.sample.iss_search.R;
import com.asnctaskexample.sample.utils.IssConstants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

/**
 * Created by Mounica on 3/14/2018.
 */

public class IssPassService  {

    /**
     * It retrieves the ISS Passes list
     * @param latitude
     * @param longitude
     * @param passes
     */
    public static PassTimesResponse getIssPassList(double latitude, double longitude, int passes) {

        String url = IssConstants.ISS_WEBSERVICE_PASS_URL + "?lat=" + latitude +"&lon=" + longitude +"&n=" + passes;

        HttpURLConnection urlConnection = null;
        String response = "";
        StringBuilder result = new StringBuilder();
        PassTimesResponse passTimesResponse = null;
        try {

            URL object = new URL(url);
            urlConnection = (HttpURLConnection) object.openConnection();

            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            final GsonBuilder builder = new GsonBuilder();
            final Gson gson = builder.create();
            passTimesResponse = gson.fromJson(reader, PassTimesResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return passTimesResponse;
    }

    /**
     * It retrieves the ISS Passes list
     * @param latitude
     * @param longitude
     * @param altitude
     * @param passes
     * @return
     */
    public static PassTimesResponse getIssPassList(double latitude, double longitude, double altitude, int passes) {
        {

            String url = IssConstants.ISS_WEBSERVICE_PASS_URL + "?lat=" + latitude +"&lon=" + longitude + "&alt=" + altitude + "&n=" + passes;

            HttpURLConnection urlConnection = null;
            String response = "";
            StringBuilder result = new StringBuilder();
            PassTimesResponse passTimesResponse = null;
            try {

                URL object = new URL(url);
                urlConnection = (HttpURLConnection) object.openConnection();

                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                final GsonBuilder builder = new GsonBuilder();
                final Gson gson = builder.create();
                passTimesResponse = gson.fromJson(reader, PassTimesResponse.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return passTimesResponse;
        }
    }
}
