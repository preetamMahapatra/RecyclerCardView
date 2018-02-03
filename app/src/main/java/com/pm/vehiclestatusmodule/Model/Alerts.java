package com.pm.vehiclestatusmodule.Model;

/**
 * Created by mahap on 02/02/18.
 */

public class Alerts {
    private String regd_no, timestamp, detail, location,idle_time,speed, lat, longi;

    public Alerts(String regd_no, String timestamp, String detail, String location, String idle_time,String speed, String lat, String longi){
        this.regd_no =regd_no;
        this.timestamp = timestamp;
        this.detail =detail;
        this.location =location;
        this.idle_time =idle_time;
        this.speed =speed;
        this.lat =lat;
        this.longi =longi;
    }

    public String getRegd_no(){
        return regd_no;
    }

    public String getTimestamp(){
        return timestamp;
    }

    public String getDetail(){
        return detail;
    }

    public String getLocation(){
        return location;
    }

    public String getIdle_time(){
        return idle_time;
    }

    public String getSpeed(){
        return speed;
    }

    public String getLat(){
        return lat;
    }

    public String getLongi(){
        return longi;
    }

    public void setRegd_no(String t){
        this.regd_no=t;
    }

    public void setTimestamp(String t){
        this.timestamp=t;
    }

    public void setDetail(String t){
        this.detail=t;
    }

    public void setLocation(String t){
        this.location=t;
    }

    public void setIdle_time(String t){
        this.idle_time=t;
    }

    public void setSpeed(String t){
        this.speed=t;
    }

    public void setLat(String t){
        this.lat=t;
    }

    public void setLongi(String t){
        this.longi=t;
    }
}
