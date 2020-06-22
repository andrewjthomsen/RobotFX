package robot;

import java.util.Arrays;

public class Robot {
    // 3 private data members: x variable, y variable, and payload variable

    private static int x;
    private static int y;
    private static char payload;
    // Declaring grid class variable
    private static final int XSIZE = 25;
    private static final int YSIZE = 25;
    private static final char[][] grid = new char[XSIZE][YSIZE];
    // Packages
    private static final char package1 = 'A';
    private static final char package2 = 'B';

    // constructor for Robot class to house public content
    // No parameters needed for default constructor
    public Robot() {
    }

    public static void initialize() {
        x = 0;
        y = 0;
        payload = ' ';
        for (char[] arr : grid) {// enhanced for loop
            Arrays.fill(arr, ' ');
        }
        // variable assignment for packages
        grid[9][9] = package1;
        grid[2][2] = package2;
    }


    // setter and getter methods
    public static int getX() {
        return x;
    }

    public static int getY() {
        return y;
    }

    public char getPayload() {
        return payload;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setPayload(char payload) {
        this.payload = payload;
    }

    // function that prints out location of robot and load status
    public static void print() {
        // Ternary conditional used to print the payload or empty if nothing in it.
        System.out.println("Location: (" + x + "," + y + ") " +
                "Load: " + (payload != ' ' ? payload : "Empty"));
    }

    // Function for picking up load
    public static boolean pickup(int lx, int ly) {
        // Examines current location of robot and if at location of pickup
        if (x != lx || y != ly) {
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
            return false;
        }
        payload = grid[lx][ly];
        grid[lx][ly] = ' ';
        return true;
    }

    /////////////////////////// CHECK ROBOT.JAVA IN PART A OF ASSIGNMENT////////////////////////////////////////////////////////////////////
    public static boolean dropOff(int lx, int ly) {
        // Return false if robot not at drop off location
        if (x != lx || y != ly) {
            System.out.println("Robot not at location: (" + lx + "," + ly + ")");
            return false;
        }
        // return false if robot has no payload to drop off
        if (payload == ' ') {
            System.out.println("Robot has no payload to drop off!");
            return false;
        }
        grid[lx][ly] = payload;
        payload = ' ';
        return true;
    }

    public static void moveRight() {
        // Checks if the grid boundary has been reached
        if (x == XSIZE - 1) {
            System.out.println("Right boundary reached.");
        } else {
            x++;
        }
    }

    public static void moveLeft() {
        // Checks if the grid boundary has been reached
        if (x == 0) {
            System.out.println("Left boundary reached.");
        } else {
            x--;
        }
    }

    public static void moveUp() {
        // Checks if the grid boundary has been reached
        if (y == 0) {
            System.out.println("Top boundary reached.");
        } else {
            y--;
        }
    }

    public static void moveDown() {
        // Checks if the grid boundary has been reached
        if (y == YSIZE - 1) {
            System.out.println("Bottom boundary reached.");
        } else {
            y++;
        }
    }

    // Place payloads at locations on map
    public static boolean placePayLoad(int lx, int ly, char payload) {
        // check for valid boundaries
        if (lx < 0 || lx > XSIZE - 1 || ly < 0 || ly > YSIZE - 1) {
            return false;
        } else {
            grid[lx][ly] = payload;
        }
        return true;
    }

    // Need to resolve this nonmember business
    public static void print2D() {
        System.out.println("-----------------------------------------------------------------------------------------------------");
        for (int i = 0; i < XSIZE; i++) {
            System.out.print("|");
            for (int j = 0; j < YSIZE; j++) {
                System.out.print(" " + grid[i][j] + " |");
            }
            // deleted grid parameter because has access to grid and no methods have grid as params
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------------------------------");

        }
    }
}
// TODO FIND PNG FOR ROBOT, PNG FOR PACKAGES A AND B. TRY TO MAKE IMAGES A PERFECT SQUARE. IF POSSIBLE
