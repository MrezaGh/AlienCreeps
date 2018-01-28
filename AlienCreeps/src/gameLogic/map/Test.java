package gameLogic.map;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import view.MainScene;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Test {
    public static MainScene mainScene;

    public static void testPath() {
        Path path = new Path();
        System.out.println("size : " + Path.getPathHomes1().size());
        for (int i = 0; i < Path.getPathHomes1().size(); i++) {
            for (int[] ints : Path.getPathHomes1().get(i)) {
                try {
                    ImageView imageView = new ImageView(new Image(new FileInputStream("images/wormHole2.png")));
                    imageView.relocate(ints[0], ints[1]);
                    Group root = (Group) mainScene.getRoot();
                    root.getChildren().add(imageView);


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }

        for (int i = 0; i < Path.getPathHomes2().size(); i++) {
            for (int[] ints : Path.getPathHomes2().get(i)) {
                try {
                    ImageView imageView = new ImageView(new Image(new FileInputStream("images/wormHole2.png")));
                    imageView.relocate(ints[0], ints[1]);
                    Group root = (Group) mainScene.getRoot();
                    root.getChildren().add(imageView);


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
