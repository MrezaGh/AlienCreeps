package view.weaponImageViews;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class RocketImageViews {
    ImageView[] rocketImageSet = new ImageView[11];

    public RocketImageViews(ImageView[] rocketImageSet) {
        this.rocketImageSet = makeRocketImageSet();
    }

    public ImageView[] makeRocketImageSet() {
        try {
            ImageView[] rocketImageSet = new ImageView[11];
            rocketImageSet[0] = new ImageView(new Image(new FileInputStream("images/Rocket/rocket0.png")));
            rocketImageSet[1] = new ImageView(new Image(new FileInputStream("images/Rocket/rocket1.png")));
            rocketImageSet[2] = new ImageView(new Image(new FileInputStream("images/Rocket/rocket2.png")));
            rocketImageSet[3] = new ImageView(new Image(new FileInputStream("images/Rocket/rocket3.png")));
            rocketImageSet[4] = new ImageView(new Image(new FileInputStream("images/Rocket/rocket4.png")));
            rocketImageSet[5] = new ImageView(new Image(new FileInputStream("images/Rocket/rocket5.png")));
            rocketImageSet[6] = new ImageView(new Image(new FileInputStream("images/Rocket/rocket6.png")));
            rocketImageSet[7] = new ImageView(new Image(new FileInputStream("images/Rocket/rocket7.png")));
            rocketImageSet[8] = new ImageView(new Image(new FileInputStream("images/Rocket/rocket8.png")));
            rocketImageSet[9] = new ImageView(new Image(new FileInputStream("images/Rocket/rocket9.png")));
            rocketImageSet[10] = new ImageView(new Image(new FileInputStream("images/Rocket/rocket10.png")));
        } catch (FileNotFoundException e) {
            System.out.println("fail loading rocket images");
        }
        return rocketImageSet;
    }

    public ImageView[] getRocketImageSet() {
        return rocketImageSet;
    }
}
