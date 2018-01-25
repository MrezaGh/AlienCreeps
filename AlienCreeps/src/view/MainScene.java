package view;

import controller.ControllerClass;
import controller.TimerOfGame;
import gameLogic.WeaponPlace;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.input.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import gameLogic.Hero;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class MainScene extends Scene {


    boolean pauseState = false;
    boolean pauseButtonClicked = false;
    private Label clock;
    TimerOfGame timer = new TimerOfGame();
    public MainScene(Parent root, double width, double height, Paint fill, Stage stage) {
        super(root, width, height, fill);
        makeMainScene(this, stage);
    }

    private void makeEventHandlerForWeaponButtons(ArrayList<Button> buttons, int numOfWeaponPlace, Stage stage) {
        System.out.println("che margete");

        for (Button button : buttons) {
            System.out.println("taheshe");
            button.setOnMouseClicked(event -> {
                new ControllerClass().setWeapon(numOfWeaponPlace, button.getText());
                stage.close();
            });
        }
    }

    private void makeAllWeapnPlaceEventHandlers(ImageView[] weaponPlaces) {
        for (int i = 0; i < weaponPlaces.length; i++) {
            int finalI = i;
            weaponPlaces[i].setOnMouseClicked(event -> {
                System.out.println("bezar");
                TextArea textArea = new TextArea();
                Stage stage = new Stage();
                stage.setTitle("Enter The Weapon You Want To Put Here");
                textArea.setMaxWidth(100);
                textArea.setMaxHeight(100);
                Button antiAircraftButton = new Button("AntiAircraft");
                Button freezerButton = new Button("Freezer");

                Button laserButton = new Button("Laser");
                Button machineGunButton = new Button("MachineGun");
                Button rocketButton = new Button("Rocket");
                Button quitButton = new Button("Quit");
                quitButton.setOnMouseClicked(event1 -> {
                    stage.close();
                });
                VBox vBox = new VBox();

                ArrayList<Button> buttons = new ArrayList<>();
                buttons.addAll(Arrays.asList(antiAircraftButton, freezerButton, laserButton, machineGunButton, rocketButton));
                makeEventHandlerForWeaponButtons(buttons, finalI, stage);

                vBox.getChildren().addAll(buttons);
                vBox.getChildren().add(quitButton);
                Scene scene = new Scene(new Group(), 500, 500, Color.GRAY);
                stage.setScene(scene);
                Group root = (Group) scene.getRoot();
                root.getChildren().addAll(vBox);
                stage.show();
            });
        }
    }

    private void makeMainScene(Scene mainScene, Stage stage) {
        Group root = (Group) mainScene.getRoot();
        root.getChildren().clear();
        //map image
        buildMapPreview(root);

        //hero
        Hero hero = new Hero(root);

        //key listener
        makeKeyListener(hero);


        //map buttons :

        //pause button
        buildPauseButton(stage, root);


        //map clock

        buildClock(root);
    }



    private void buildMapPreview(Group root) {
        ImageView[] weaponplaces = new ImageView[8];
        try {
            ImageView background = new ImageView(new Image(new FileInputStream(new File("images/map.png/"))));
            weaponplaces[0] = new ImageView(new Image(new FileInputStream(new File("images/map images/weaponPlace.png"))));

            weaponplaces[1] = new ImageView(new Image(new FileInputStream(new File("images/map images/weaponPlace.png"))));
            weaponplaces[2] = new ImageView(new Image(new FileInputStream(new File("images/map images/weaponPlace.png"))));
            weaponplaces[3] = new ImageView(new Image(new FileInputStream(new File("images/map images/weaponPlace.png"))));
            weaponplaces[4] = new ImageView(new Image(new FileInputStream(new File("images/map images/weaponPlace.png"))));
            weaponplaces[5] = new ImageView(new Image(new FileInputStream(new File("images/map images/weaponPlace.png"))));
            weaponplaces[6] = new ImageView(new Image(new FileInputStream(new File("images/map images/weaponPlace.png"))));
            weaponplaces[7] = new ImageView(new Image(new FileInputStream(new File("images/map images/weaponPlace.png"))));
            weaponplaces[7].relocate(192, 544);
            weaponplaces[6].relocate(384, 320);
            weaponplaces[5].relocate(608, 320);
            weaponplaces[4].relocate(896, 320);
            weaponplaces[3].relocate(800, 544);
            weaponplaces[2].relocate(800, 736);
            weaponplaces[1].relocate(1056, 736);
            weaponplaces[0].relocate(352, 64);
            makeAllWeapnPlaceEventHandlers(weaponplaces);

            root.getChildren().add(background);
            root.getChildren().addAll(weaponplaces[0], weaponplaces[1], weaponplaces[2], weaponplaces[3], weaponplaces[4], weaponplaces[5], weaponplaces[6], weaponplaces[7]);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }





    private void makeKeyListener(Hero hero) {
        EventHandler<KeyEvent> keyListener = event -> {
            moveHero(hero, event);
            //todo inja be har dokme e mitune hassas beshe
            event.consume();
        };
        this.addEventHandler(KeyEvent.KEY_PRESSED,keyListener);
    }

    private void buildPauseButton(Stage stage, Group root) {

        try {
            ImageView pause = new ImageView(new Image(new FileInputStream(new File("images/map images/pause.png"))));
            pause.relocate(1240, 8);
            pause(stage, root, pause);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void buildClock(Group root) {

        clock = new Label(timer.toString());
        clock.relocate(42, 42);
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
                "    -fx-padding: 10 20 10 20;" +
                "-fx-font-weight: bold;");
        root.getChildren().add(clock);
    }

    private void moveHero(Hero hero, KeyEvent event) {
        KeyCombination upShift = new KeyCodeCombination(KeyCode.UP, KeyCodeCombination.SHIFT_DOWN);
        KeyCombination downShift = new KeyCodeCombination(KeyCode.DOWN, KeyCodeCombination.SHIFT_DOWN);
        KeyCombination leftShift = new KeyCodeCombination(KeyCode.LEFT, KeyCodeCombination.SHIFT_DOWN);
        KeyCombination rightShift = new KeyCodeCombination(KeyCode.RIGHT, KeyCodeCombination.SHIFT_DOWN);
        if (upShift.match(event)) {
            hero.moveHeroForward(10);
        }
        else if (event.getCode() == KeyCode.UP){
            hero.moveHeroForward(4);
        }
        if (downShift.match(event)) {
            hero.moveHeroDownward(10);
        }
        else if (event.getCode() == KeyCode.DOWN){
            hero.moveHeroDownward(4);
        }
        if (rightShift.match(event)) {
            hero.moveHeroRight(10);
        }
        else if (event.getCode() == KeyCode.RIGHT){
            hero.moveHeroRight(4);
        }
        if (leftShift.match(event)) {
            hero.moveHeroLeft(10);
        }
        if (event.getCode() == KeyCode.LEFT){
            hero.moveHeroLeft(4);
        }
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


            if (!getPauseButtonClicked()) {
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
            } else if (getPauseButtonClicked()) {
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
            showStat.relocate(1160, 42);

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
            quit.relocate(1240, 42);
            quit.setOnMouseClicked(e1 -> {
                StartScene startScene = new StartScene(new Group(), 1280, 960, Color.BLUE, stage);
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
            resume.relocate(1200, 42);

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
    public Label getClock() {
        return clock;
    }

    public void setClock(Label clock) {
        this.clock = clock;
    }
}
