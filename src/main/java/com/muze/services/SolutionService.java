package com.muze.services;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.muze.data.Position;
import com.muze.data.Solution;
import com.muze.enums.DIRECTION;

public class SolutionService {

	private List<Solution> solutions;

	public SolutionService() {
		super();
	}

	public SolutionService(List<Solution> solutions) {
		super();
		this.solutions = solutions;
	}

	public boolean isDirectionVisited(Position position) {
		if (solutions != null && solutions.isEmpty() == false) {
			for (Solution solution : solutions) {
				if (solution.getPosition().getX().equals(position.getX())
						&& solution.getPosition().getY()
								.equals(position.getY()))
					return true;
			}
		}
		return false;
	}

	void init(Position position) {
		solutions = new LinkedList<Solution>();
		solutions.add(new Solution(position, new ArrayList<DIRECTION>()));
	}

	public List<Solution> getSolutions() {
		return solutions;
	}

	public void setSolutions(List<Solution> solutions) {
		this.solutions = solutions;
	}

}
