package com.ctos.model;

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

    public String toJson(){
        String json = "{" +
                "\"data\":\"" + data +
                "\"}";

        return json;
    }
}
