package view.weaponImageViews;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FreezerImageViews {
    private ImageView[] freezerImageSet = new ImageView[4];

    public FreezerImageViews(ImageView[] rocketImageSet) {
        makeFreezerImageSet();
    }

    public void makeFreezerImageSet() {
        try {
            freezerImageSet[0] = new ImageView(new Image(new FileInputStream("images/Freezer/Freezer0.png")));
            freezerImageSet[1] = new ImageView(new Image(new FileInputStream("images/Freezer/Freezer1.png")));
        } catch (FileNotFoundException e) {
            System.out.println("fail loading freezer images");
        }
    }

    public ImageView[] getRocketImageSet() {
        return freezerImageSet;
    }
}
