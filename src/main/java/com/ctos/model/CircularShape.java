package com.ctos.model;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;

public class CircularShape extends Shape{
    private Coordinate coordinate;
    private float radius;

    public CircularShape(Coordinate coordinate, float radius) {
        super("circular");
        this.coordinate = coordinate;
        this.radius = radius;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public JsonObject toJson(){
        JsonObject json = new JsonObject();
        json.addProperty("type", shapeClass);
        json.add("coordinate", coordinate.toJson());
        json.addProperty("radius", radius);

        return json;
    }

    public static Shape fromJson(JsonObject jsonObject) {
//        System.out.println(jsonObject.toString());
        return new CircularShape(Coordinate.fromJson(jsonObject.get("coordinates").getAsJsonArray()),
                    jsonObject.get("radius").getAsFloat());
    }
}
