package view;

import controller.TimerOfGame;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MainScene extends Scene {


    boolean pauseState = false;
    boolean pauseButtonClicked = false;
    private Label clock;
    TimerOfGame timer = new TimerOfGame();

    public Label getClock() {
        return clock;
    }

    public void setClock(Label clock) {
        this.clock = clock;
    }

    public MainScene(Parent root, double width, double height, Paint fill, Stage stage) {
        super(root, width, height, fill);
        makeMainScene(this,stage);
    }

    private void makeMainScene(Scene mainScene, Stage stage) {
        Group root = (Group) mainScene.getRoot();
        root.getChildren().clear();





        //map image
        ImageView[] weapon = new ImageView[8];
        try {
            ImageView background = new ImageView(new Image(new FileInputStream(new File("images/map.png/"))));
            weapon[0] = new ImageView(new Image(new FileInputStream(new File("images/map images/weaponPlace.png"))));

            weapon[1] = new ImageView(new Image(new FileInputStream(new File("images/map images/weaponPlace.png"))));
            weapon[2] = new ImageView(new Image(new FileInputStream(new File("images/map images/weaponPlace.png"))));
            weapon[3] = new ImageView(new Image(new FileInputStream(new File("images/map images/weaponPlace.png"))));
            weapon[4] = new ImageView(new Image(new FileInputStream(new File("images/map images/weaponPlace.png"))));
            weapon[5] = new ImageView(new Image(new FileInputStream(new File("images/map images/weaponPlace.png"))));
            weapon[6] = new ImageView(new Image(new FileInputStream(new File("images/map images/weaponPlace.png"))));
            weapon[7] = new ImageView(new Image(new FileInputStream(new File("images/map images/weaponPlace.png"))));
            weapon[7].relocate(192,544);
            weapon[6].relocate(384,320);
            weapon[5].relocate(608,320);
            weapon[4].relocate(896,320);
            weapon[3].relocate(800,544);
            weapon[2].relocate(800,736);
            weapon[1].relocate(1056,736);
            weapon[0].relocate(352,64);

            root.getChildren().add(background);
            root.getChildren().addAll(weapon[0],weapon[1],weapon[2],weapon[3],weapon[4],weapon[5],weapon[6],weapon[7]);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        //hero
        Hero hero = new Hero(root);




        //key listener
        EventHandler<KeyEvent> keyListener = event -> {
            if (event.getCode() == KeyCode.UP){
                hero.moveHeroForward();
            }
            event.consume();
        };
        this.addEventHandler(KeyEvent.KEY_PRESSED,keyListener);


        //map buttons



        //pause button
        try {
            ImageView pause = new ImageView(new Image(new FileInputStream(new File("images/map images/pause.png"))));
            pause.relocate(1240,8);
            pause(stage, root, pause);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //test




        //map clock
        clock = new Label(timer.toString());
        clock.relocate(42,42);
        clock.setStyle("-fx-background-color: \n" +
                "        #a6b5c9,\n" +
                "        linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%),\n" +
                "        linear-gradient(#020b02, #3a3a3a),\n" +
                "        linear-gradient(#9d9e9d 0%, #6b6a6b 20%, #343534 80%, #242424 100%),\n" +
                "        radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0));\n" +
                "    -fx-background-radius: 5,4,3,5;\n" +
                "    -fx-background-insets: 0,1,2,0;\n" +
                "    -fx-text-fill: white;\n" +
                "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );\n" +
                "    -fx-font-family: \"Arial\";\n" +
                "    -fx-text-fill: linear-gradient(white, #d0d0d0);\n" +
                "    -fx-font-size: 12px;\n" +
                "    -fx-padding: 10 20 10 20;"+
                "-fx-font-weight: bold;");
        root.getChildren().add(clock);

    }

    private void pause(Stage stage, Group root, ImageView pause) {
        setPauseState(false);
        final ImageView[] resumeButton = {new ImageView()};
        final ImageView[] showStatButton = {new ImageView()};
        final ImageView[] quitButton = {new ImageView()};
        pause.setOnMouseClicked(pauseButtonHandler(stage, root, pause, resumeButton, showStatButton, quitButton));
        root.getChildren().add(pause);
    }


    private EventHandler<MouseEvent> pauseButtonHandler(Stage stage, Group root, ImageView pause, ImageView[] resumeButton, ImageView[] showStatButton, ImageView[] quitButton) {
        return (MouseEvent e) -> {


                   if (!getPauseButtonClicked() ) {
                       //todo injaa zaman bayad pause she ya hame chi sleep she
                       if (!getPauseState())
                       setPauseState(true);
                       //resume button
                       resumeButton[0] = resumeButton(root);
                       //quit button
                       quitButton[0] = quitButton(stage, root);
                       //show stat button
                       showStatButton[0] = showStatButton(root);


                       pause.relocate(1240, 8);
                       setPauseButtonClicked(true);
                   }
                   else if (getPauseButtonClicked() ) {
                           root.getChildren().remove(resumeButton[0]);
                           root.getChildren().remove(showStatButton[0]);
                           root.getChildren().remove(quitButton[0]);
                           setPauseButtonClicked(false);

                   }

        };
    }


    private ImageView showStatButton(Group root) {
        try {
            ImageView showStat = new ImageView(new Image(new FileInputStream(new File("images/map images/showstat.png"))));
            showStat.relocate(1160,42);

            showStat.setOnMouseClicked(e1 ->
                    {
                        //todo inja text box show stat baz mishe
                        TextField showStatTextField = new TextField("showing stats");
                        showStatTextField.relocate(550, 300);
                        showStatTextField.setOnMouseClicked(e2 -> root.getChildren().remove(showStatTextField));
                        root.getChildren().add(showStatTextField);


                    });


            root.getChildren().add(showStat);
            return showStat;
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        return null;
    }

    private ImageView quitButton(Stage stage, Group root) {
        try {
            ImageView quit = new ImageView(new Image(new FileInputStream(new File("images/map images/quit.png"))));
            quit.relocate(1240,42);
            quit.setOnMouseClicked(e1 -> {
                StartScene startScene = new StartScene(new Group(), 1280, 960, Color.BLUE,stage);
                stage.setScene(startScene);
            });
            root.getChildren().add(quit);
            return quit;
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        return null;
    }

    private ImageView resumeButton(Group root) {
        try {
            ImageView resume = new ImageView(new Image(new FileInputStream(new File("images/map images/play.png"))));
            resume.relocate(1200,42);

            resume.setOnMouseClicked(e1 -> {
                //todo inja zaman dobare resume mishe
                TextField resumeTextField = new TextField("resumed");
                resumeTextField.relocate(550, 300);
                resumeTextField.setOnMouseClicked(e2 -> root.getChildren().remove(resumeTextField));
                root.getChildren().add(resumeTextField);

                setPauseState(false);
            });



            root.getChildren().add(resume);
            return resume;
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }

        return null;
    }

    public boolean getPauseState() {
        return pauseState;
    }

    public void setPauseState(boolean pauseState) {
        this.pauseState = pauseState;
    }
    public boolean getPauseButtonClicked() {
        return pauseButtonClicked;
    }

    public void setPauseButtonClicked(boolean pauseButtonClicked) {
        this.pauseButtonClicked = pauseButtonClicked;
    }
}
