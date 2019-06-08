package com.jovin.robot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jovin.robot.common.Position;
import com.jovin.robot.dto.RobotDto;
import com.jovin.robot.service.RobotService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class RobotController {
	
	 @Autowired
	    private RobotService robot;

	    @RequestMapping(value = "/place", method = RequestMethod.GET, produces = "application/json")
	    public RobotDto place(@RequestParam(value = "x") int x, @RequestParam(value = "y") int y, @RequestParam(value = "position") Position pos) {
	        return robot.place(x, y, pos);
	    }

	    @RequestMapping(value = "/move", method = RequestMethod.GET, produces = "application/json")
	    public RobotDto move() {
	        return robot.move();
	    }

	    @RequestMapping(value = "/leftTurn", method = RequestMethod.GET, produces = "application/json")
	    public RobotDto left() {
	        return robot.left();
	    }

	    @RequestMapping(value = "/rightTurn", method = RequestMethod.GET, produces = "application/json")
	    public RobotDto right() {
	        return robot.right();
	    }

	    @RequestMapping(value = "/report", method = RequestMethod.GET, produces = "application/json")
	    public RobotDto report() {
	        return robot.report();
	    }

}
