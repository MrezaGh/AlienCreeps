package view.weaponImageViews;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TeslaImageViews {
    private ImageView[] teslaImageViews = new ImageView[1];

    public TeslaImageViews() {
        makeTeslaImages();
    }

    public void makeTeslaImages() {
        try {
            teslaImageViews[0] = new ImageView(new Image(new FileInputStream("images/tesla.png")));
        } catch (FileNotFoundException e) {
            System.out.println("fail loading tesla image");
        }
    }

    public ImageView[] getTeslaImageViews() {
        return teslaImageViews;
    }
}
