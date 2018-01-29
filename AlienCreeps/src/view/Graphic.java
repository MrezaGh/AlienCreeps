package view;

import controller.ControllerClass;
import gameLogic.Engine;
import gameLogic.firings.movableFirings.Hero;
import gameLogic.firings.movableFirings.MovableFirings;
import gameLogic.map.WormHole;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Graphic extends Application {
    private WormHole crossedWormHole = new WormHole();
    public static boolean movableMoved = false;
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
    }

    AnimationTimer animationTimer = new AnimationTimer() {
        int counter = 0;

        @Override
        public void handle(long now) {
            if (stage.getScene() instanceof StartScene) {
                return;
            }
            if (isMainSceneOrNot == false) {
                return;
            }
            if (((MainScene) stage.getScene()).getPauseState() == true) {
                return;
            }
            ((MainScene) (stage.getScene())).goldLabel.setText("Gold : " + Engine.getInstance().getPlayer().getGold());
            counter++;
            for (MovableFirings movableFirings : MovableFirings.getAllMovableFirings()) {
                for (WormHole wormHole : WormHole.getWormHoles()) {
                    if (crossedWormHole != wormHole || (crossedWormHole == wormHole && movableFirings.isMovableMoved())) {
                        if (movableFirings instanceof Hero) {
                            Hero hero = ((MainScene) stage.getScene()).hero;
                            int xHero = hero.getCoordinate()[0];
                            int yHero = hero.getCoordinate()[1];
                            int xWorm = wormHole.getStartCoordinates()[0];
                            int yWorm = wormHole.getStartCoordinates()[1];
                            if ((xWorm >= xHero + 0 && xWorm + 32 <= xHero + 64 && yWorm >= yHero + 0 && yWorm + 32 <= yHero + 64) || (xWorm >= xHero + 0 && xWorm + 32 <= xHero + 64 && yWorm >= yHero + 32 && yWorm + 32 <= yHero + 32 + 64)) {
                                hero.setCoordinate(new int[]{wormHole.getEndCoordinates()[0] - 35, wormHole.getEndCoordinates()[1] - 35});
                                hero.drawHero(hero.heroMoveLeftPics, 2);
                                crossedWormHole = wormHole;
                                hero.setMovableMoved(false);
                            }
                        }
                    }
                }
            }
            for (MovableFirings movableFirings : MovableFirings.getAllMovableFirings()) {
                for (WormHole wormHole : WormHole.getWormHoles()) {
                    if (crossedWormHole != wormHole || (crossedWormHole == wormHole && movableFirings.isMovableMoved())){
                        if (movableFirings instanceof Hero) {
                            Hero hero = ((MainScene) stage.getScene()).hero;
                            int xHero = hero.getCoordinate()[0] ;
                            int yHero = hero.getCoordinate()[1] ;
                            int xWorm = wormHole.getEndCoordinates()[0];
                            int yWorm = wormHole.getEndCoordinates()[1];
                            if ((xWorm >= xHero + 0 && xWorm + 32 <= xHero + 64 && yWorm >= yHero + 0 && yWorm + 32 <= yHero + 64) || (xWorm >= xHero + 0 && xWorm + 32 <= xHero + 64 && yWorm >= yHero + 32 && yWorm + 32 <= yHero + 32 + 64)) {
                                hero.setCoordinate(new int[]{wormHole.getStartCoordinates()[0] - 35, wormHole.getStartCoordinates()[1] - 35});
                                hero.drawHero(hero.heroMoveLeftPics, 2);
                                hero.setMovableMoved(false);
                            }
                        }
                    }
                }
            }

            if (counter % 60 == 0) {
                //System.out.println(((MainScene) (stage.getScene())).hero.getCoordinate()[0]);
                ((MainScene) stage.getScene()).timer.increaseTimer();
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
        animationTimer.start();
    }


}
