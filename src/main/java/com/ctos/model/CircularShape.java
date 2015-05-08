package com.ctos.model;


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

    public String toJson(){
        String json = "{" +
                "\"shape_class\":\"" + shapeClass + "\"," +
                "\"coordinate\":" + coordinate.toJson() + "," +
                "\"radius\":" + radius +
                "}";

        return json;
    }
}
