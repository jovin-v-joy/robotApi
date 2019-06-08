package com.jovin.robot.dto;

import com.jovin.robot.common.Position;

public class Robot {
	private int x;
	private int y;
	private Position position;
	public Robot(int x, int y, Position position) {
		super();
		this.x = x;
		this.y = y;
		this.position = position;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	
	
	
}
