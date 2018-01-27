package view.weaponImageViews;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TeslaImages extends WeaponImages {

    public TeslaImages() {
        super(1);
    }


    @Override
    protected void makeFiringImages() {
        try {
            firingImages[0] = new Image(new FileInputStream("images/teslaFiring.png"));
        } catch (FileNotFoundException e) {
            System.out.println("fail loading tesla firing image");
        }
    }

    @Override
    protected void makeNonFiringImages() {
        try {
            nonFiringImages[0] = new Image(new FileInputStream("images/tesla.png"));
        } catch (FileNotFoundException e) {
            System.out.println("fail loading tesla image");
        }
    }
}
