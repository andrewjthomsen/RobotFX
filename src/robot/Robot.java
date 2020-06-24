package robot;

import java.util.Arrays;

public class Robot {
    // 3 private data members: x variable, y variable, and payload variable
    private static int robotX, robotY, eggX, eggY, fishX, fishY;
    private static char payload;
    // Declaring grid class variable
    private static final int XSIZE = 25;
    private static final int YSIZE = 25;
    private static final char[][] grid = new char[XSIZE][YSIZE];
    // Packages
    private static final char egg = 'E';
    private static final char fish = 'F';

    // constructor for Robot class to house public content
    // No parameters needed for default constructor
    public Robot() {
    }

    public static void initialize() {
        robotX = 0;
        robotY = 0;
        eggX = 4;
        eggY = 4;
        fishX = 7;
        fishY = 7;
        payload = ' ';
        for (char[] arr : grid) {// enhanced for loop
            Arrays.fill(arr, ' ');
        }
        // variable assignment for packages
        grid[4][4] = egg;
        grid[7][7] = fish;
    }


    // setter and getter methods
    public static int getRobotX() {
        return robotX;
    }

    public static int getRobotY() {
        return robotY;
    }

    public static int getEggX() {
        return eggX;
    }

    public static int getEggY() {
        return eggY;
    }

    public static int getFishX() {
        return fishX;
    }

    public static int getFishY() {
        return fishY;
    }

    // function that prints out location of robot and load status
    public static void print() {
        // Ternary conditional used to print the payload or empty if nothing in it.
        System.out.println("Location: (" + robotX + "," + robotY + ") " +
                "Load: " + (payload != ' ' ? payload : "Empty"));
    }

    // Method for picking up load
    public static boolean pickup(int lx, int ly) {
        // Examines current location of robot and if at location of pickup
        if (robotX != lx || robotY != ly) {
            System.out.println("Robot not at location: (" + lx + "," + ly + ")");
            return false;
        }
        // If load is at location or not
        if (grid[lx][ly] == ' ') {
            System.out.println("No load at this location.");
            return false;
        }
        // If payload is empty then pickup load
        if (payload != ' ') {
            System.out.println("Robot already has a load!");
            return false;
        }
        // Set payload to load on grid and remove load value from grid.
        payload = grid[lx][ly];
        grid[lx][ly] = ' ';
        // Prevents package from displaying grid if package has been picked up.
        // Setting variable to sentinel value to prevent display after pickup.
        if (payload == 'E') {
            eggX = -1;
            eggY = -1;
        } else {
            fishX = -1;
            fishY = -1;
        }
        System.out.println("Pickup of load was successful.");
        return true;
    }

    /////////////////////////// CHECK ROBOT.JAVA IN PART A OF ASSIGNMENT////////////////////////////////////////////////////////////////////
    public static boolean dropOff(int lx, int ly) {
        // Return false if robot not at drop off location
        if (robotX != lx || robotY != ly) {
            System.out.println("Robot not at location: (" + lx + "," + ly + ")");
            return false;
        }
        // return false if robot has no payload to drop off
        if (payload == ' ') {
            System.out.println("Robot has no payload to drop off!");
            return false;
        }
        // Setting grid coordinates to payload and remove from payload.
        grid[lx][ly] = payload;
        if (payload == 'E') {
            eggX = lx;
            eggY = ly;
        } else {
            fishX = lx;
            fishY = ly;
        }
        payload = ' ';
        System.out.println("Successful drop off of payload.");
        return true;
    }

    public static boolean moveRight() {
        // Checks if the grid boundary has been reached
        if (robotX == XSIZE - 1) {
            System.out.println("Right boundary reached.");
            return false;
        } else {
            robotX++;
            return true;
        }
    }

    public static boolean moveLeft() {
        // Checks if the grid boundary has been reached
        if (robotX == 0) {
            System.out.println("Left boundary reached.");
            return false;
        } else {
            robotX--;
            return true;
        }
    }

    public static boolean moveUp() {
        // Checks if the grid boundary has been reached
        if (robotY == 0) {
            System.out.println("Top boundary reached.");
            return false;
        } else {
            robotY--;
            return true;
        }
    }

    public static boolean moveDown() {
        // Checks if the grid boundary has been reached
        if (robotY == YSIZE - 1) {
            System.out.println("Bottom boundary reached.");
            return false;
        } else {
            robotY++;
            return true;
        }
    }
}

