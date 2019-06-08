package com.jovin.robot.service;

import com.jovin.robot.common.Position;
import com.jovin.robot.dto.RobotDto;

public interface RobotService {
	
	public RobotDto place(int newX, int newY, Position f);
    /**
     * Moves the robot in the facing direction
     * @return RobotDto
     */
    public RobotDto move();

    /**
     * Rotates to left
     * @return RobotDto
     */
    public RobotDto left();

    /**
     * Rotates to right
     * @return RobotDto
     */
    public RobotDto right();

    /**
     * Report the current place and facing
     * @return RobotDto
     */
    public RobotDto report();
     

}
