package com.ctos.client;

import com.ctos.model.*;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import jdk.nashorn.internal.runtime.JSONFunctions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;



public class CtosClient {
	
	private String url;
	
	public CtosClient(String url){
		this.url = url;
	}

	public URL strToURL(String url){
		try {
			return new URL(url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
        return null;
	}
	
	public HashMap<String,Object> query(){
        return null;
	}

	public static void main(String[] args) {
		CtosClient client = new CtosClient("http://localhost:3000/api/v1");
//		System.out.println(client.query());

        Shape shape = new CircularShape(new Coordinate(10, 5), 7);
        DataInfo dataInfo = new DataInfo("ola ke ase");
        Zone z = new Zone();//"Zona 1", false, null, null, null);

        System.out.println(z.toJson());

        String params = "{\n" +
                "  \"authentication\":{\n" +
                "    \"email\":\"a@b.c\",\n" +
                "    \"user_code\":\"e1011b9dacaa4e1d17fff6ffd6d8\",\n" +
                "    \"app_code\":\"225a97d643150622ee506a397e8ab1f2af2b\"\n" +
                "  },\n" +
                "  \"zone\":" + z.toJson() +
                "}";

        HttpRequest request = new HttpRequest();
        String response = request.postRequest(client.strToURL(client.getUrl() + "/zone/show"), params);
        System.out.println(response);

        JsonObject obj = new JsonParser().parse(response).getAsJsonObject();
        System.out.println(obj.getAsJsonObject("params").getAsJsonArray("zones").get(0).getAsJsonObject().get("name").getAsString());

        System.exit(0);

	}


    public String getUrl() {
        return url;
    }
}
