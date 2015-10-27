package com.muze.http.client;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.muze.data.Mazes;
import com.muze.data.Position;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JerseyClientGet {

	// . field
	// # wall
	// @ starting position
	// x exit

	// GET /mazes
	//
	// Lists mazes with their dimensions.
	//
	// Request: GET /mazes
	//
	// Response body:
	//
	// [
	// {
	// "code": "maze-1",
	// "width": 3,
	// "height": 3
	// }
	// ]

	// Request: GET /mazes/maze-1/position/start
	//
	// Response:
	//
	// 200 OK
	// 404 Not found
	// Response body:
	//
	// {
	// "x": 1,
	// "y": 0
	// }

	public Mazes getMazes() throws JsonParseException, JsonMappingException,
			IOException {

		String mazesService = "http://localhost:8080/mazes";
		Client client = Client.create();

		WebResource webResource = client.resource(mazesService);

		ClientResponse response = webResource.accept("application/json").get(
				ClientResponse.class);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}

		String output = response.getEntity(String.class);

		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(output, Mazes.class);
	}
	
	public Position getStart(String mazeName) throws JsonParseException, JsonMappingException, IOException{
		String start ="http://localhost:8080/mazes/"+mazeName+"/position/start";
		Client client = Client.create();
		WebResource webResource = client.resource(start);

		ClientResponse response = webResource.accept("application/json").get(
				ClientResponse.class);

		if (response.getStatus() != 200) {
			return null;
		}

		String output = response.getEntity(String.class);

		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(output, Position.class);
	}

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
	

	}

}