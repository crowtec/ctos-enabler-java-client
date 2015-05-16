package com.ctos.model;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;

public abstract class Shape {
    protected String shapeClass;

    public Shape(String shapeClass) {
        this.shapeClass = shapeClass;
    }

    public String getShapeClass() {
        return shapeClass;
    }

    public void setShapeClass(String shapeClass) {
        this.shapeClass = shapeClass;
    }

    public abstract JsonObject toJson();
    public static Shape fromJson(JsonObject jsonObject){
        System.out.println(jsonObject.toString());
        String type = jsonObject.get("type").getAsString();
        if(type.equals("polygon")) {
            return PolygonalShape.fromJson(jsonObject);
        } else if (type.equals("circle")){
            return CircularShape.fromJson(jsonObject);
        }
        return null;
    }
}
