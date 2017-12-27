package view;

import controller.ControllerClass;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Graphic extends Application {
    public static void main(String[] args) {
        launch(args);
        ControllerClass controller = new ControllerClass();
        controller.run();
    }

    @Override
    public void init() throws Exception {
        super.init();
    }

    public Stage stage = new Stage();
    public Scene startMenu = new Scene(new Group(), 1280, 960, Color.BLUE);
    public Scene gameScene = new Scene(new Group(), 1280, 960, Color.GRAY);
    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        StartScene startScene = new StartScene(new Group(), 1280, 960, Color.BLUE,stage);
        stage.setScene(startScene);
        stage.setTitle("Alien Creeps");
        stage.show();
    }


}
