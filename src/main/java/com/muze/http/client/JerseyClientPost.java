package com.muze.http.client;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.google.gson.Gson;
import com.muze.data.Position;
import com.muze.data.RequestPosion;
import com.muze.data.ResponsePosition;
import com.muze.enums.DIRECTION;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JerseyClientPost {

	// Request: POST /mazes/maze-1/position
	// Request body:
	//
	// {
	// "from": {
	// "x": 1,
	// "y": 0
	// },
	// "direction": "SOUTH"
	// }
	// Response:
	//
	// 200 OK
	// 404 Not found, if the maze is not found
	// 418 I'm a teapot, in case the move is not valid (RFC 2324)
	// Response body (in case of 200 OK):
	//
	// {
	// "position": {
	// "x": 1,
	// "y": 1
	// },
	// "field": "."
	// }

	public ResponsePosition getPosResp(String mazeName, RequestPosion reqPos)
			throws JsonParseException, JsonMappingException, IOException {

		Client client = Client.create();

		WebResource webResource = client
				.resource("http://localhost:8080/mazes/"+mazeName+"/position");

		Gson gson = new Gson();
		String json = gson.toJson(reqPos);
		ClientResponse response = webResource.type("application/json").post(
				ClientResponse.class, json);

		if (response.getStatus() != 200) {
			return new ResponsePosition(null, "#");
		}

		String output = response.getEntity(String.class);

		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(output, ResponsePosition.class);
	}

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {

		String mazeName = "maze-1";

		RequestPosion reqPos = new RequestPosion(new Position(1, 1), DIRECTION.SOUTH.name());

		JerseyClientPost clientPost = new JerseyClientPost(); 
		
		System.out.println(clientPost.getPosResp(mazeName, reqPos));
	}

}
