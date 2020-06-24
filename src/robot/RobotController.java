package robot;

import javafx.event.ActionEvent;

// File responsible for setting behavior for buttons when pressed
public class RobotController {
    public void pressPickUp(ActionEvent event) {
        Robot.pickup(Robot.getRobotX(), Robot.getRobotY());
        Robot.print();
    }

    public void pressDropOff(ActionEvent event) {
        Robot.dropOff(Robot.getRobotX(), Robot.getRobotY());
        Robot.print();
    }

    public void pressMoveUp(ActionEvent event) {
        Robot.moveUp();
        Robot.print();
    }

    public void pressMoveDown(ActionEvent event) {
        Robot.moveDown();
        Robot.print();
    }

    public void pressMoveRight(ActionEvent event) {
        Robot.moveRight();
        Robot.print();
    }

    public void pressMoveLeft(ActionEvent event) {
        Robot.moveLeft();
        Robot.print();
    }
}
