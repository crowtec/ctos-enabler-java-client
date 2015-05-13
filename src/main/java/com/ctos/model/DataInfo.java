package com.ctos.model;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class DataInfo {

    private String data;

    public DataInfo(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public JsonObject toJson(){

        JsonObject json = new JsonObject();
        json.addProperty("data", data);

        return json;
    }

    public static DataInfo fromJson(JsonObject jsonObject) {
        return new DataInfo(jsonObject.get("data").getAsString());
    }
}
