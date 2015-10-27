package com.muze.data;

public class RequestPosion {

	private Position from;

	private String direction;

	public RequestPosion() {
		super();

	}

	public RequestPosion(Position from, String direction) {
		super();
		this.from = from;
		this.setDirection(direction);
	}

	public Position getFrom() {
		return from;
	}

	public void setFrom(Position from) {
		this.from = from;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}


}
