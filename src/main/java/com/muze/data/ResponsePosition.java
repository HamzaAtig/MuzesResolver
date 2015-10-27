package com.muze.data;

public class ResponsePosition {

	
	private Position position ;
	
	private String field;


	public ResponsePosition() {
		super();
	
	}
	
	public ResponsePosition(Position position, String field) {
		super();
		this.position = position;
		this.field = field;
	}

	@Override
	public String toString() {
		return "RespPos [position=" + position + ", field=" + field + "]";
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	} 
}
