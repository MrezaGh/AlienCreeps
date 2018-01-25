package view;

import controller.ControllerClass;
import controller.Timer;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Graphic extends Application {
    private static boolean isMainSceneOrNot = false;

    public static boolean isIsMainSceneOrNot() {
        return isMainSceneOrNot;
    }

    public static void setIsMainSceneOrNot(boolean isMainSceneOrNot) {
        Graphic.isMainSceneOrNot = isMainSceneOrNot;
    }

    public static void main(String[] args) {
        launch(args);
        ControllerClass controller = new ControllerClass();
        controller.run();
    }

    AnimationTimer animationTimer = new AnimationTimer() {
        int counter = 0;

        @Override
        public void handle(long now) {
            if (stage.getScene() instanceof StartScene){
                return;
            }
            if (isMainSceneOrNot == false) {
                return;
            }
            if(((MainScene) stage.getScene()).getPauseState() == true){
                return;
            }
            counter++;

            if (counter % 60 == 0) {
                ((MainScene) stage.getScene()).timer.increaseTimer();
                System.out.println(((MainScene) stage.getScene()).timer);
                ((MainScene) stage.getScene()).getClock().setText(((MainScene) stage.getScene()).timer.toString());
            }
        }
    };

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
        StartScene startScene = new StartScene(new Group(), 1280, 960, Color.BLUE, stage);
        stage.setScene(startScene);
        stage.setTitle("Alien Creeps");
        stage.show();
        Timer clock = new Timer();
        animationTimer.start();
    }


}
