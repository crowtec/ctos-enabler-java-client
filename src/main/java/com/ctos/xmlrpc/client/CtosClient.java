package com.ctos.xmlrpc.client;

import java.net.URL;
import java.util.HashMap;

import de.timroes.axmlrpc.*;


public class CtosClient {
	
	private String url;
	
	public CtosClient(String url){
		this.url = url;
	}
	
	public HashMap<String,Object> query(){
		try {
		    XMLRPCClient client = new XMLRPCClient(new URL(url));
		    HashMap<String,Object> params = new HashMap<String,Object>();
		    HashMap<String,Object> authentication_map = new HashMap<String,Object>();
		    authentication_map.put("email", "a@b.c");
		    authentication_map.put("user_code", "adafddc4704c1931eed6e14ca7fe");
		    authentication_map.put("app_code", "87c9abbc1f8684f40a96837b6b73bc4fe5a5");
		    params.put("authentication", authentication_map);
		    HashMap<String,Object> res = (HashMap<String,Object>)client.call("ctos.getAllZones", params);
		    

			return res;
		} catch(XMLRPCServerException ex) {
		    // The server throw an error.
		} catch(XMLRPCException ex) {
		    // An error occured in the client.
		} catch(Exception ex) {
		    // Any other exception
		}
		return null;
	}

	public static void main(String[] args) {
		CtosClient client = new CtosClient("http://localhost:3000/api");
		System.out.println(client.query());


	}

}
