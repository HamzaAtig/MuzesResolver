package com.muze.services;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.muze.data.Maze;
import com.muze.data.Mazes;
import com.muze.data.Position;
import com.muze.data.RequestPosion;
import com.muze.data.ResponsePosition;
import com.muze.data.Solution;
import com.muze.enums.DIRECTION;
import com.muze.http.client.JerseyClientGet;
import com.muze.http.client.JerseyClientPost;

public class MazesResolver {

	final static Logger logger = Logger.getLogger(MazesResolver.class); 
	static JerseyClientGet clientGet = new JerseyClientGet();

	static JerseyClientPost clientPost = new JerseyClientPost();

	public static void main(String[] args) throws JsonParseException,
			JsonMappingException, IOException {
		
		Mazes mazes = clientGet.getMazes();
		for (Maze maze : mazes.getMazes()) {

			String mazeName = maze.getCode();

			SolutionService solutionService = new SolutionService();
			Position start = clientGet.getStart(mazeName);
			if (start == null)
				return;
			solutionService.init(start);
			Solution solution = solutionService.getSolutions().get(0);
			RequestPosion reqPos = new RequestPosion(solution.getPosition(), solution
					.getNextDirections().name());
			ResponsePosition respPos = clientPost.getPosResp(mazeName, reqPos);

			while (solutionService.getSolutions() != null
					&& solutionService.getSolutions().isEmpty() == false
					&& respPos.getField().equals("x") == false) {

				DIRECTION direction = solution.getNextDirections();
				if (direction == null) {
					solutionService.getSolutions().remove(solution);
					if (solutionService.getSolutions().size() > 0) {
						solution = solutionService.getSolutions().get(
								solutionService.getSolutions().size() - 1);
					}
					continue;
				}
				reqPos = new RequestPosion(solution.getPosition(), direction.name());
				respPos = clientPost.getPosResp(mazeName, reqPos);

//				if (respPos.getPosition() != null)
//					logger.info("isDirectionVisited : "
//							+ solutionService.isDirectionVisited(respPos
//									.getPosition()));

				if (respPos.getPosition() != null
						&& solutionService.isDirectionVisited(respPos
								.getPosition()) == false) {
					solution = new Solution(respPos.getPosition(),
							new ArrayList<DIRECTION>());
					solutionService.getSolutions().add(solution);
//					logger.info(respPos);
				}
//				logger.info(solutionService.getSolutions());
			}
			
			logger.info(maze);
			logger.info(solutionService.getSolutions());
		}

	}
}
