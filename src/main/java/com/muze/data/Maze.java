package com.muze.data;

public class Maze {

	private String code ; 
	
	private Integer width ; 
	
	private Integer height ;

	
	@Override
	public String toString() {
		return "Maze [code=" + code + ", width=" + width + ", height=" + height
				+ "]";
	}

	public Maze() {
		super();
	}
	
	public Maze(String code, Integer width, Integer height) {
		super();
		this.code = code;
		this.width = width;
		this.height = height;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	} 
	
	
}
