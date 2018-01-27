package view.weaponImageViews;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MachinGunImageViews {
    private ImageView[] machinGunImageSet = new ImageView[4];

    public MachinGunImageViews() {
        makeMachinGunImageSet();
    }

    public void makeMachinGunImageSet() {
        try {
            machinGunImageSet[0] = new ImageView(new Image(new FileInputStream("images/MachinGun/MachinGun0.png")));
            machinGunImageSet[1] = new ImageView(new Image(new FileInputStream("images/MachinGun/MachinGun1.png")));
            machinGunImageSet[2] = new ImageView(new Image(new FileInputStream("images/MachinGun/MachinGun2.png")));
            machinGunImageSet[3] = new ImageView(new Image(new FileInputStream("images/MachinGun/MachinGun3.png")));
        } catch (FileNotFoundException e) {
            System.out.println("fail loading machin gun images");
        }
    }

    public ImageView[] getMachinGunImageSet() {
        return machinGunImageSet;
    }
}
