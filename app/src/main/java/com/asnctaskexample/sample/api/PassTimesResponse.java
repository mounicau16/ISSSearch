package com.asnctaskexample.sample.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Mounica on 3/15/2018.
 */

public class PassTimesResponse {
    @SerializedName("message")
    private String message;

    @SerializedName("request")
    private RequestPassTimes request;

    @SerializedName("response")
    private List<PassTime> passTimes;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public RequestPassTimes getRequest() {
        return request;
    }

    public void setRequest(RequestPassTimes request) {
        this.request = request;
    }

    public List<PassTime> getPassTimes() {
        return passTimes;
    }

    public void setPassTimes(List<PassTime> passTimes) {
        this.passTimes = passTimes;
    }
}
