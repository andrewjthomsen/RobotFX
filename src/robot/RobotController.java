package robot;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

// File responsible for setting behavior for buttons when pressed
// Implement interface for Robot Controller
public class RobotController implements Initializable {
    // Declare grid
    public GridPane grid;
    // Declare image nodes
    private Node robot = null;
    private Node fish = null;
    private Node egg = null;
    private final Image robotIMG;
    private final Image fishIMG;
    private final Image eggIMG;

    // Constructor for robot controller
    public RobotController() throws FileNotFoundException {
        robotIMG = new Image(new FileInputStream("src/robot/robot.png"));
        fishIMG = new Image(new FileInputStream("src/robot/fish.png"));
        eggIMG = new Image(new FileInputStream("src/robot/egg.png"));
    }

    // Initializing images and setting default positions
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        robot = new ImageView(robotIMG);
        grid.add(robot, 0, 0);
        fish = new ImageView(fishIMG);
        grid.add(fish, 4, 4);
        egg = new ImageView(eggIMG);
        grid.add(egg, 7, 7);
    }

    // Pickup load if valid pickup location, print status to console.
    public void pressPickUp(ActionEvent event) {
        // checking if location is valid
        if (Robot.pickup(Robot.getRobotX(), Robot.getRobotY())) {
            setImages();
        }
        Robot.print();
    }

    public void pressDropOff(ActionEvent event) {
        if (Robot.dropOff(Robot.getRobotX(), Robot.getRobotY())) {
            setImages();
        }
        Robot.print();
    }

    public void pressMoveUp(ActionEvent event) {
        if (Robot.moveUp()) {
            setImages();
        }
        Robot.print();
    }

    public void pressMoveDown(ActionEvent event) {
        if (Robot.moveDown()) {
            setImages();
        }
        Robot.print();
    }

    public void pressMoveRight(ActionEvent event) {
        if (Robot.moveRight()) {
            setImages();
        }
        Robot.print();
    }

    public void pressMoveLeft(ActionEvent event) {
        if (Robot.moveLeft()) {
            setImages();
        }
        Robot.print();
    }

    // Method that sets location for images
    public void setImages() {
        // if image already placed, remove them.
        if (robot != null) {
            grid.getChildren().remove(robot);
            grid.getChildren().remove(fish);
            grid.getChildren().remove(egg);
        }

        // create new images
        robot = new ImageView(robotIMG);
        fish = new ImageView(fishIMG);
        egg = new ImageView(eggIMG);

        // add robot to grid
        grid.add(robot, Robot.getRobotX(), Robot.getRobotY());

        // Add packages only if not picked up
        if (Robot.getEggX() == -1) {
            grid.add(fish, Robot.getFishX(), Robot.getFishY());
        } else if (Robot.getFishX() == -1) {
            grid.add(egg, Robot.getEggX(), Robot.getEggY());
        } else {
            grid.add(fish, Robot.getFishX(), Robot.getFishY());
            grid.add(egg, Robot.getEggX(), Robot.getEggY());
        }
    }
}
