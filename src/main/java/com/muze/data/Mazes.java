package com.muze.data;

import java.util.List;

public class Mazes {

	private List<Maze> mazes ;

	@Override
	public String toString() {
		return "Mazes [mazes=" + mazes + "]";
	}

	public Mazes() {
		super();
	}
	
	public Mazes(List<Maze> mazes) {
		super();
		this.mazes = mazes;
	}

	public List<Maze> getMazes() {
		return mazes;
	}

	public void setMazes(List<Maze> mazes) {
		this.mazes = mazes;
	} 
}
