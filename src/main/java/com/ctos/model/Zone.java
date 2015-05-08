package com.ctos.model;

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

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public String toJson(){
        String json = "{";
        json += (name != null) ? "\"name\":\"" + name + "\"," : "";
        json += (isObject != null) ? "\"is_object\":" + isObject + "," : "";
        json += (zoneClass != null) ? "\"zone_class\":\"" + zoneClass + "\"," : "";
        json += (shape != null) ? "\"shape\":" + shape.toJson() + "," : "";
        json += (dataInfo != null) ? "\"data_info\":" + dataInfo.toJson() : "";
        if (json.endsWith(",")){
            json = json.substring(0, json.length()-1);
        }
        json += "}";

        return json;
    }


}
