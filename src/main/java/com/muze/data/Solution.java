package com.muze.data;

import java.util.List;

import com.muze.enums.DIRECTION;

public class Solution {

	private Position position ; 
	
	private List<DIRECTION> directions;

	public Solution() {
		super();
	}
	
	public Solution(Position position, List<DIRECTION> directions) {
		super();
		this.position = position;
		this.directions = directions;
	}
	
	public DIRECTION getNextDirections(){
		if(!directions.contains(DIRECTION.EAST)){
			directions.add(DIRECTION.EAST);
			return DIRECTION.EAST ;
		}
		if(!directions.contains(DIRECTION.NORTH)){
			directions.add(DIRECTION.NORTH);
			return DIRECTION.NORTH ;
		}
		if(!directions.contains(DIRECTION.SOUTH)){
			directions.add(DIRECTION.SOUTH);
			return DIRECTION.SOUTH ;
		}
		if(!directions.contains(DIRECTION.WEST)){
			directions.add(DIRECTION.WEST);
			return DIRECTION.WEST ;
		}
		return null ; 
	}

	@Override
	public String toString() {
		return "Solution [position=" + position + ", directions=" + directions
				+ "]";
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public List<DIRECTION> getDirections() {
		return directions;
	}

	public void setDirections(List<DIRECTION> directions) {
		this.directions = directions;
	} 
}
