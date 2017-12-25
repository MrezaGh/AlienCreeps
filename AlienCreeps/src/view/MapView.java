package view;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MapView extends Application{
    public Stage stage = new Stage();
    public Scene startMenu = new Scene(new Group(), 1280, 960, Color.BLUE);
    public Scene mainScene = new Scene(new Group(), 1280, 960, Color.GRAY);
    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        stage.setScene(startMenu);
        stage.setTitle("Alien Creeps");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
