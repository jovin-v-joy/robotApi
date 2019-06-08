# This is an API set for Robot movement.
# maven clean install  To build the project
# maven spring-boot:run  To Run the project


# All end points are defined in RobotController.java Class

Added a @CrossOrigin(origins = "http://localhost:3000")  to make proper react fetch rest call.

# Sample Requests and response


# Example 1:

PLACE 0,0,NORTH: http://localhost:8080/place?x=0&y=0&position=NORTH

MOVE: http://localhost:8080/move

REPORT: http://localhost:8080/report

Output: {
    "robot": {
        "x": 0,
        "y": 1,
        "position": "NORTH"
    },
    "status": {
        "success": true,
        "error": null     // NULL values are ignored from the latest version.
    }
}


# Example 2:

PLACE 0,0,NORTH: http://localhost:8080/place?x=0&y=0&position=NORTH

LEFT: http://localhost:8080/leftTurn

REPORT: http://localhost:8080/report

Output: {
    "robot": {
        "x": 0,
        "y": 0,
        "position": "WEST"
    },
    "status": {
        "success": true,
        "error": null  // NULL values are ignored from the latest version.
    }
}


# Example 3:

PLACE 1,2,EAST: http://localhost:8080/place?x=1&y=2&position=EAST

MOVE: http://localhost:8080/move

MOVE: http://localhost:8080/move

LEFT: http://localhost:8080/leftTurn

MOVE: http://localhost:8080/move

REPORT: http://localhost:8080/report

Output: {
    "robot": {
        "x": 3,
        "y": 3,
        "position": "NORTH"
    },
    "status": {
        "success": true,
        "error": null
    }
}
