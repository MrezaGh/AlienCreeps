package view.weaponImageViews;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class LaserImageViews {
    private ImageView[] laserImageViews = new ImageView[1];

    public LaserImageViews() {
        makeLaserImages();
    }

    public void makeLaserImages() {
        try {
            laserImageViews[0] = new ImageView(new Image(new FileInputStream("images/laser.png")));
        } catch (FileNotFoundException e) {
            System.out.println("fail loading laser image");
        }
    }

    public ImageView[] getLaserImageViews() {
        return laserImageViews;
    }
}
