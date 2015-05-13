package com.ctos.model;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class Coordinate {

    private double latitude;
    private double longitude;

    public Coordinate(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public JsonArray toJson(){
        JsonArray json = new JsonArray();
        json.add(new JsonPrimitive(latitude));
        json.add(new JsonPrimitive(longitude));
        return json;
    }

    public static Coordinate fromJson(JsonArray jsonArray) {
        return new Coordinate(jsonArray.get(0).getAsDouble(), jsonArray.get(1).getAsDouble());
    }
}
