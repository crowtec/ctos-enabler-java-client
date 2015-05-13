package com.ctos.client;

import com.ctos.model.*;
import com.google.gson.*;

import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class CtosClient {
	
	private String url;
	private String email;
	private String userCode;
	private String appCode;

	private CtosClient(String url, String email, String userCode, String appCode){
		this.url = url;
		this.email = email;
		this.userCode = userCode;
		this.appCode = appCode;
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
		CtosClient client = new CtosClient("http://178.62.1.193/api/v1", "a@b.c", "a0066bbcbe25d7029a0e6934e1aa", "49456203c8e64d3690ed0e0dccf151e4e693");
//		System.out.println(client.query());

        Shape shape = new CircularShape(new Coordinate(10, 5), 7);
		ArrayList<Coordinate> polygonalCoordinates = new ArrayList<Coordinate>();
		polygonalCoordinates.add(new Coordinate(3.021, 5.214));
		polygonalCoordinates.add(new Coordinate(3.54, 5.214));
		polygonalCoordinates.add(new Coordinate(3.021, 8.214));

		PolygonalShape polygonalShape = new PolygonalShape(polygonalCoordinates);
        DataInfo dataInfo = new DataInfo("ola ke ase");
        Zone z = new Zone("Polym", true, "zona", polygonalShape, dataInfo);
		boolean zones = client.createZone(z);

//		for (int i = 0; i < zones.size(); i++){
//			System.out.println(zones.get(i).getName());
//		}
//        CircularShape circularShape = ((CircularShape)zones.get(5).getShape());
//        Coordinate coordinate = circularShape.getCoordinate();
//        List<Zone> container = client.coordinateContainerZones(new Coordinate[]{coordinate});
//        System.out.println("CONTAINER");
//        for (int i = 0; i < container.size(); i++){
//            System.out.println(container.get(i).getName());
//        }

        System.exit(0);

	}


    public String getUrl() {
        return url;
    }

	public JsonObject generateAuthentication(){
		JsonObject authentication = new JsonObject();
		authentication.addProperty("email", this.email);
		authentication.addProperty("user_code", this.userCode);
		authentication.addProperty("app_code", this.appCode);

		return  authentication;

	}
	public JsonObject generateQuery(JsonObject query){
		JsonObject final_query = new JsonObject();
		final_query.add("authentication", generateAuthentication());
		final_query.add("query", query);

		return final_query;
	}

    public  List<Zone> getZones(Zone zone){
		JsonObject query = new JsonObject();
		query.add("zone", zone.toJson());
		JsonObject params = generateQuery(query);

		List<Zone> zones = new ArrayList<Zone>();
            HttpRequest request = new HttpRequest();
            String response = request.postRequest(strToURL(getUrl() + "/zone/show"), params.toString());


		JsonObject obj = new JsonParser().parse(response).getAsJsonObject();
		JsonArray zones_array = obj.getAsJsonObject("params").getAsJsonArray("zones");
		for(int i = 0; i < zones_array.size(); i++){
			zones.add(Zone.fromJson(zones_array.get(i).getAsJsonObject()));
		}

		return zones;

    }

    public List<Zone> coordinateContainerZones(Coordinate[] coordinates){
        JsonObject query = new JsonObject();
        JsonArray coordinates_array = new JsonArray();
        for(Coordinate coordinate: coordinates){
            coordinates_array.add(coordinate.toJson());
        }
        query.add("coordinates", coordinates_array);
        JsonObject params = generateQuery(query);


        HttpRequest request = new HttpRequest();
        String response = request.postRequest(strToURL(getUrl() + "/coordinate/container"), params.toString());

        System.out.println(response);
        JsonObject obj = new JsonParser().parse(response).getAsJsonObject();
        JsonArray zones_array = obj.getAsJsonObject("params").getAsJsonArray("zones");
        List<Zone> zones = new ArrayList<Zone>();
        for(int i = 0; i < zones_array.size(); i++){
            zones.add(Zone.fromJson(zones_array.get(i).getAsJsonObject()));
        }

        return zones;
    }

	public boolean createZone(Zone zone){
		JsonObject query = new JsonObject();
		query.add("zone", zone.toJson());
		JsonObject params = generateQuery(query);


		HttpRequest request = new HttpRequest();
		String response = request.postRequest(strToURL(getUrl() + "/zone/create"), params.toString());

		System.out.println(response);
//		JsonObject obj = new JsonParser().parse(response).getAsJsonObject();
//		JsonArray zones_array = obj.getAsJsonObject("params").getAsJsonArray("zones");
//		List<Zone> zones = new ArrayList<Zone>();
//		for(int i = 0; i < zones_array.size(); i++){
//			zones.add(Zone.fromJson(zones_array.get(i).getAsJsonObject()));
//		}
//
//		return zones;
		return true;
	}



}
