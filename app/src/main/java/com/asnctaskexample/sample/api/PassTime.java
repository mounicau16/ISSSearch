package com.asnctaskexample.sample.api;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mounica on 3/15/2018.
 */

public class PassTime {
    @SerializedName("risetime")
    private long riseTime;

    @SerializedName("duration")
    private int duration;

    public long getRiseTime() {
        return riseTime;
    }

    public void setRiseTime(long riseTime) {
        this.riseTime = riseTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
