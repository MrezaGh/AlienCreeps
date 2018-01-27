package view.weaponImageViews;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class AntiAircraftImageViews {
    private ImageView[] antiAircraftImageSet = new ImageView[4];

    public AntiAircraftImageViews() {
        makeAntiAircraftImageSet();
    }

    public void makeAntiAircraftImageSet() {
        try {
            antiAircraftImageSet[0] = new ImageView(new Image(new FileInputStream("images/AntiAircraft/AntiAircraft0.png")));
            antiAircraftImageSet[1] = new ImageView(new Image(new FileInputStream("images/AntiAircraft/AntiAircraft1.png")));
        } catch (FileNotFoundException e) {
            System.out.println("fail loading antiAircraft images");
        }
    }

    public ImageView[] getAntiAircraftImageSet() {
        return antiAircraftImageSet;
    }
}
