package com.ctos.model;

import com.google.gson.JsonObject;

public class Zone {

    private String name;
    private Boolean isObject;
    private String zoneClass;
    private DataInfo dataInfo;
    private Shape shape;

    public Zone(){
    }

    public Zone(String name, Boolean isObject, String zoneClass) {
        this.name = name;
        this.isObject = isObject;
        this.zoneClass = zoneClass;
    }

    public Zone(String name, Boolean isObject, String zoneClass, Shape shape, DataInfo dataInfo) {
        this.name = name;
        this.isObject = isObject;
        this.zoneClass = zoneClass;
        this.shape = shape;
        this.dataInfo = dataInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isObject() {
        return isObject;
    }

    public void setIsObject(Boolean isObject) {
        this.isObject = isObject;
    }

    public String getZoneClass() {
        return zoneClass;
    }

    public void setZoneClass(String zoneClass) {
        this.zoneClass = zoneClass;
    }

    public DataInfo getDataInfo() {
        return dataInfo;
    }

    public void setDataInfo(DataInfo dataInfo) {
        this.dataInfo = dataInfo;
    }

    public Shape getShape() {
        return shape;
    }
    public CircularShape getShapeAsCircular() {
        if (shape.getShapeClass().equals("circle")) {
            return (CircularShape) shape;
        }
        return null;
    }
    public PolygonalShape getShapeAsPolygonal() {
        if (shape.getShapeClass().equals("polygon")) {
            return (PolygonalShape) shape;
        }
        return null;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public JsonObject toJson(){
        JsonObject json = new JsonObject();
        if (name != null){
            json.addProperty("name", this.name);
        }
        if (isObject != null){
            json.addProperty("is_object", this.isObject);
        }
        if (zoneClass != null){
            json.addProperty("zone_class", this.zoneClass);
        }
        if (shape != null){
            json.add("shape", this.shape.toJson());
        }
        if (dataInfo != null){
            json.add("data_info", this.dataInfo.toJson());
        }

        return json;
    }

    public static Zone fromJson(JsonObject json){
        //String name, Boolean isObject, String zoneClass, Shape shape, DataInfo dataInfo //
        Zone zone = new Zone(json.get("name").getAsString(), json.get("is_object").getAsBoolean(), json.get("zone_class").getAsString()
        , Shape.fromJson(json.get("shape").getAsJsonObject()), DataInfo.fromJson(json.get("data_info").getAsJsonObject()));

        return zone;

    }


}
