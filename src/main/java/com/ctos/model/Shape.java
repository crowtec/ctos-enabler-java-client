package com.ctos.model;

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

    public abstract String toJson();
}
