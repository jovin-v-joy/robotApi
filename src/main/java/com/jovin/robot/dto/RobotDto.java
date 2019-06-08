package com.jovin.robot.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class RobotDto {
	@JsonInclude(Include.NON_NULL)	
	private Robot robot;
	
	@JsonInclude(Include.NON_NULL)
	private Status status;
	
	public Robot getRobot() {
		return robot;
	}
	public void setRobot(Robot robot) {
		this.robot = robot;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
}
