package com.muze.data;

public class Position {

	private Integer x; 
	private Integer  y;
	
	@Override
	public String toString() {
		return "Pos [x=" + x + ", y=" + y + "]";
	}

	public Position() {
		super();
	}
	
	public Position(Integer x, Integer y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public Integer getX() {
		return x;
	}
	public void setX(Integer x) {
		this.x = x;
	}
	public Integer getY() {
		return y;
	}
	public void setY(Integer y) {
		this.y = y;
	}
	
	
}
