package com.ctos.model;

import java.util.ArrayList;

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

    public String toJson(){
        String json = "{" +
                "\"shape_class\":\"" + shapeClass + "\"," +
                "\"coordinates\":[";
        boolean first = true;
        for(Coordinate coordinate: coordinates){
            json += first ? coordinate.toJson() : "," + coordinate.toJson();
            first = false;
        }
        json += "]}";

        return json;
    }
}
