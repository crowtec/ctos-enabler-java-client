package com.ctos.model;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class PolygonalShape extends Shape {
    private ArrayList<Coordinate> coordinates;

    public PolygonalShape(ArrayList<Coordinate> coordinates) {
        super("polygonal");
        this.coordinates = coordinates;
    }

    public ArrayList<Coordinate> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(ArrayList<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    public JsonObject toJson(){
        JsonObject json = new JsonObject();
        json.addProperty("type", shapeClass);
        JsonArray coordinates_array = new JsonArray();
        for(Coordinate coordinate: coordinates){
            coordinates_array.add(coordinate.toJson());
        }
        json.add("coordinates", coordinates_array);

        return json;
    }


    public static Shape fromJson(JsonObject jsonObject) {
        JsonArray coordinates_array = jsonObject.getAsJsonArray("coordinates").get(0).getAsJsonArray();

        ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
        for (int i = 0; i < coordinates_array.size(); i++){
            coordinates.add(Coordinate.fromJson(coordinates_array.get(i).getAsJsonArray()));
        }
        PolygonalShape p = new PolygonalShape(coordinates);
        p.shapeClass = jsonObject.get("type").getAsString();
        return p;
    }
}
