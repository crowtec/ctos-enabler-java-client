package com.ctos.model;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class Coordinate {

    private float latitude;
    private float longitude;

    public Coordinate(float latitude, float longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public JsonArray toJson(){
        JsonArray json = new JsonArray();
        json.add(new JsonPrimitive(latitude));
        json.add(new JsonPrimitive(longitude));
        return json;
    }

    public static Coordinate fromJson(JsonArray jsonArray) {
        return new Coordinate(jsonArray.get(0).getAsFloat(), jsonArray.get(1).getAsFloat());
    }

    public boolean equals(Coordinate coordinate){
        return (this.latitude == coordinate.getLatitude() && this.longitude == coordinate.getLongitude());
    }
}
