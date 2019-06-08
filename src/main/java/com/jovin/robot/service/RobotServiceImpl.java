package com.jovin.robot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jovin.robot.common.Position;
import com.jovin.robot.common.Table;
import com.jovin.robot.dto.Robot;
import com.jovin.robot.dto.RobotDto;
import com.jovin.robot.dto.Status;

@Service
public class RobotServiceImpl implements RobotService {
	
	@Autowired
	private Table table;
	private Position position;
	private boolean placed;
	private int x;
	private int y;

	/** 
	 * @param newX = X coordinate            
	 * @param newY = Y coordinate           
	 * @param pos - set the initial position            
	 * @return RobotDto
	 */
	public RobotDto place(int newX, int newY, Position pos) {
		RobotDto robotDto = new RobotDto();
		if (table.isPositionValid(newX, newY)) {			
			placed = true;
			x = newX;
			y = newY;
			position = pos;			
			Robot robot = new Robot(newX, newY, position);
			Status status = new Status(true);	
			robotDto.setRobot(robot);
			robotDto.setStatus(status);			
		} else {
			Status status = new Status(false,"ROBOT can't be placed");
			robotDto.setStatus(status);						
		}
		return robotDto;
	}

	/**
	 * Move robot 
	 * @return RobotDto
	 */
	public RobotDto move() {
		RobotDto robotDto = new RobotDto();
		if (!placed) {
			Status status = new Status(false,"ROBOT NOT PLACED");
			robotDto.setStatus(status);
			return robotDto;
		}
		int tmpX = x;
		int tmpY = y;
		switch (position) {
		case NORTH:		
			tmpY++;
			break;
		case SOUTH:
			tmpY--;
			break;
		case EAST:
			tmpX++;
			break;
		case WEST:
			tmpX--;
			break;
		}
		// Trying for the move then store into temp first, if temp coords are valid for move
		if (table.isPositionValid(tmpX, tmpY)) {
			// assign them to the real
			x = tmpX;
			y = tmpY;
			Robot robot = new Robot(x, y, position);
			Status status = new Status(true);	
			robotDto.setRobot(robot);
			robotDto.setStatus(status);
			return robotDto;
		}
		Status status = new Status(false,"ROBOT Can't move"); // + tmpX + "," + tmpY
		robotDto.setStatus(status);
		return robotDto;
	}

	/**
	 * Rotate robot to left 
	 * @return RobotDto
	 */
	public RobotDto left() {
		RobotDto robotDto = new RobotDto();
		if (!placed) {
			Status status = new Status(false,"ROBOT NOT PLACED");
			robotDto.setStatus(status);
			return robotDto;			
		}
		switch (position) {
		case NORTH:
			position = Position.WEST;
			break;
		case SOUTH:
			position = Position.EAST;
			break;
		case EAST:
			position = Position.NORTH;
			break;
		case WEST:
			position = Position.SOUTH;
			break;
		}
		Robot robot = new Robot(x, y, position);
		Status status = new Status(true);	
		robotDto.setRobot(robot);
		robotDto.setStatus(status);
		
		return robotDto;
	}

	/**
	 * Rotate robot to right
	 * 
	 * @return RobotDto
	 */
	public RobotDto right() {
		RobotDto robotDto = new RobotDto();
		if (!placed) {
			Status status = new Status(false,"ROBOT NOT PLACED");
			robotDto.setStatus(status);
			return robotDto;			
		}
		switch (position) {
		case NORTH:
			position = Position.EAST;
			break;
		case SOUTH:
			position = Position.WEST;
			break;
		case EAST:
			position = Position.SOUTH;
			break;
		case WEST:
			position = Position.NORTH;
			break;
		}
		Robot robot = new Robot(x, y, position);
		Status status = new Status(true);	
		robotDto.setRobot(robot);
		robotDto.setStatus(status);
		return robotDto;
	}

	/**
	 * Report the current place
	 * 
	 * @return RobotDto
	 */
	public RobotDto report() {
		RobotDto robotDto = new RobotDto();
		if (!placed) {
			Status status = new Status(false,"ROBOT NOT PLACED");
			robotDto.setStatus(status);
			return robotDto;	
		}
		Robot robot = new Robot(x, y, position);
		Status status = new Status(true);	
		robotDto.setRobot(robot);
		robotDto.setStatus(status);
		return robotDto;
	}
}
