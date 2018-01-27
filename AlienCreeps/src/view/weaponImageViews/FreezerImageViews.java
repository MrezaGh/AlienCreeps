package view.weaponImageViews;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FreezerImageViews extends WeaponImages{


    public FreezerImageViews() {
        super(2);
    }

    public void makeFreezerImageSet() {

    }


    @Override
    protected void makeFiringImages() {
        try {
            nonFiringImages[0] = new Image(new FileInputStream("images/Freezer/Freezer0.png"));
            nonFiringImages[1] = new Image(new FileInputStream("images/Freezer/Freezer1.png"));
        } catch (FileNotFoundException e) {
            System.out.println("fail loading freezer images");
        }
    }

    @Override
    protected void makeNonFiringImages() {
        try {
            firingImages[0] = new Image(new FileInputStream("images/Freezer/Freezer0Firing.png"));
            firingImages[1] = new Image(new FileInputStream("images/Freezer/Freezer0Firing.png"));
        } catch (FileNotFoundException e) {
            System.out.println("fail loading firing freezer images");
        }
    }
}
