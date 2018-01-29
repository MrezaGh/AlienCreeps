package view;

import controller.ControllerClass;
import controller.TimerOfGame;
import gameLogic.Engine;
import gameLogic.firings.movableFirings.Hero;
import gameLogic.WeaponPlace;
import gameLogic.firings.Tesla;
import gameLogic.firings.Weapon;
import gameLogic.map.WormHole;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import view.weaponImageViews.weaponImmages.*;

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
    LaserImages laserImages = new LaserImages();
    RocketImages rocketImages = new RocketImages();
    TeslaImages teslaImages = new TeslaImages();
    FreezerImages freezerImages = new FreezerImages();
    MachinGunImages machinGunImages = new MachinGunImages();
    AntiAircraftImages antiAircraftImages = new AntiAircraftImages();
    Label goldLabel = new Label("Gold : " + Engine.getInstance().getPlayer().getGold());
    Hero hero;

    public MainScene(Parent root, double width, double height, Paint fill, Stage stage) {
        super(root, width, height, fill);
        makeMainScene(this, stage);
    }

    private void makeEventHandlerForWeaponButtons(ArrayList<Button> buttons, int numOfWeaponPlace, Stage stage, ImageView[] weaponPlaces) {
        for (Button button : buttons) {
            button.setOnMouseClicked(event -> {
                try {
                    new ControllerClass().setWeapon(numOfWeaponPlace, button.getText());
                } catch (Exception e) {
                    Stage warningStage = new Stage();
                    Scene warningScene = new Scene(new Group(), 300, 300);
                    warningStage.setMaxWidth(300);
                    warningStage.setMaxHeight(300);
                    warningStage.setMinWidth(300);
                    warningStage.setMinHeight(300);
                    Button okButton = new Button("OK");
                    okButton.relocate(150, 150);
                    okButton.setOnMouseClicked(event1 -> {
                        warningStage.close();
                    });
                    warningScene.setFill(Color.BLACK);
                    Label label = new Label(e.getMessage());
                    Font nazanin = new Font("B Nazanin", 20);
                    label.setFont(nazanin);
                    label.relocate(10, 10);
                    label.setTextFill(Color.RED);
                    Group root = (Group) warningScene.getRoot();
                    root.getChildren().addAll(label, okButton);
                    warningStage.setScene(warningScene);
                    warningStage.show();
                    return;
                }

                Group root = (Group) this.getRoot();

                Weapon weapon = Weapon.valueOf(button.getText());
                switch (weapon) {
                    case Laser:
                        weaponPlaces[numOfWeaponPlace].setImage(laserImages.getNonFiringImages()[0]);
                        break;
                    case Rocket:
                        weaponPlaces[numOfWeaponPlace].setImage(rocketImages.getNonFiringImages()[0]);
                        break;
                    case Freezer:
                        weaponPlaces[numOfWeaponPlace].setImage(freezerImages.getNonFiringImages()[0]);
                        break;
                    case MachineGun:
                        weaponPlaces[numOfWeaponPlace].setImage(machinGunImages.getNonFiringImages()[0]);
                        break;
                    case AntiAircraft:
                        weaponPlaces[numOfWeaponPlace].setImage(antiAircraftImages.getNonFiringImages()[0]);
                        break;
                }
                stage.close();
            });
        }
    }


    private void makeAllWeapnPlaceEventHandlers(ImageView[] weaponPlaces) {
        for (int i = 0; i < weaponPlaces.length; i++) {
            int finalI = i;
            weaponPlaces[i].setOnMouseClicked(event -> {
                Stage stage = new Stage();
                stage.setTitle("Enter The Weapon You Want To Put Here");
                Button antiAircraftButton = new Button("AntiAircraft");
                Button freezerButton = new Button("Freezer");
                Button laserButton = new Button("Laser");
                Button machineGunButton = new Button("MachineGun");
                Button rocketButton = new Button("Rocket");
                Button upgradeButton = new Button("Upgrade");

                upgradeButton.setOnMouseClicked(event1 -> {
                    if (WeaponPlace.getWeaponPlaces()[finalI].getWeapon() != null) {
                        //TODO upgrade
                    }
                });
                Button quitButton = new Button("Quit");
                quitButton.setOnMouseClicked(event1 -> {
                    stage.close();
                });

                VBox vBox = new VBox();

                ArrayList<Button> buttons = new ArrayList<>();
                buttons.addAll(Arrays.asList(antiAircraftButton, freezerButton, laserButton, machineGunButton, rocketButton));
                makeEventHandlerForWeaponButtons(buttons, finalI, stage, weaponPlaces);

                vBox.getChildren().addAll(buttons);
                vBox.getChildren().add(upgradeButton);
                vBox.getChildren().add(quitButton);
                Scene scene = new Scene(new Group(), 500, 500, Color.GRAY);
                stage.setScene(scene);
                Group root = (Group) scene.getRoot();
                root.getChildren().addAll(vBox);
                stage.show();
            });
        }
    }

    private void makeEventHandlerForTesla(ImageView teslaImage) {
        Text text2 = new Text();
        text2.setText("0");
        teslaImage.setOnMouseClicked(event -> {
            if (text2.getText().equals("1")) {
                return;
            }
            Stage stage = new Stage();
            Scene scene = new Scene(new Group());
            stage.setScene(scene);
            stage.setTitle("put tesla?");
            stage.setMaxWidth(500);
            stage.setMaxHeight(500);
            stage.setMinWidth(400);
            stage.setMinHeight(400);
            Group root = (Group) scene.getRoot();
            Text text = new Text("Are you sure?");
            text.relocate(5, 50);
            root.getChildren().add(text);
            Button noButton = new Button("No");
            noButton.relocate(150, 100);
            Button yesButton = new Button("Yes");
            yesButton.relocate(10, 100);
            stage.show();
            makeEventHandlerForYesAndNoButtons(yesButton, noButton, teslaImage, stage, text2);
            root.getChildren().addAll(yesButton, noButton);

            event.consume();
        });
    }

    private void makeEventHandlerForYesAndNoButtons(Button yes, Button no, ImageView teslaImage, Stage stage, Text text) {
        yes.setOnMouseClicked(event -> {
            Tesla.getInstance();
            Tesla.setPossibleOrNot(true);
            teslaImage.setImage(teslaImages.getNonFiringImages()[0]);
            teslaImage.removeEventHandler(event.getEventType(), teslaImage.getOnMouseClicked());
            text.setText("1");
            stage.close();
        });
        no.setOnMouseClicked(event -> stage.close());
    }


    private void makeMainScene(Scene mainScene, Stage stage) {
        Group root = (Group) mainScene.getRoot();
        root.getChildren().clear();
        //map image
        buildMapPreview(root);

        //hero
        hero = new Hero(root);

        //key listener
        makeKeyListener(hero);


        //map buttons :

        //pause button
        buildPauseButton(stage, root);


        //map clock

        buildClock(root);
        buildGoldLabel(root);

        makeWormHoleImages(root);

    }

    private void makeWormHoleImages(Group root) {
        for (WormHole wormHole : WormHole.getWormHoles()) {
            try {
                ImageView wormHoleStartImage = new ImageView(new Image(new FileInputStream("images/wormHole2.png")));
                wormHoleStartImage.relocate(wormHole.getStartCoordinates()[0], wormHole.getStartCoordinates()[1]);
                root.getChildren().add(wormHoleStartImage);
                ImageView wormHoleEndImage = new ImageView(new Image(new FileInputStream("images/wormHole2.png")));
                wormHoleEndImage.relocate(wormHole.getEndCoordinates()[0], wormHole.getEndCoordinates()[1]);
                root.getChildren().add(wormHoleEndImage);
            } catch (FileNotFoundException e) {
                System.out.println("fail loading wormHole image");
            }
        }
    }

    private void buildGoldLabel(Group root) {

        goldLabel.relocate(1100, 1);
        goldLabel.setStyle("-fx-background-color: \n" +
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
        root.getChildren().add(goldLabel);
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
            ImageView teslaPlace = new ImageView(new Image(new FileInputStream(new File("images/map images/weaponPlace.png"))));
            teslaPlace.relocate(18 * 32, 960 - (12 * 32));
            ImageView putTeslaHere = new ImageView(new Image(new FileInputStream(new File("images/place_tesla_here.png"))));
            putTeslaHere.relocate(14 * 32, 960 - (12 * 32));
            makeEventHandlerForTesla(teslaPlace);
            root.getChildren().addAll(weaponplaces[0], weaponplaces[1], weaponplaces[2], weaponplaces[3], weaponplaces[4], weaponplaces[5], weaponplaces[6], weaponplaces[7], teslaPlace, putTeslaHere);

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
        this.addEventHandler(KeyEvent.KEY_PRESSED, keyListener);
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
        } else if (event.getCode() == KeyCode.UP) {
            hero.moveHeroForward(4);
        }
        if (downShift.match(event)) {
            hero.moveHeroDownward(10);
        } else if (event.getCode() == KeyCode.DOWN) {
            hero.moveHeroDownward(4);
        }
        if (rightShift.match(event)) {
            hero.moveHeroRight(10);
        } else if (event.getCode() == KeyCode.RIGHT) {
            hero.moveHeroRight(4);
        }
        if (leftShift.match(event)) {
            hero.moveHeroLeft(10);
        }
        if (event.getCode() == KeyCode.LEFT) {
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
