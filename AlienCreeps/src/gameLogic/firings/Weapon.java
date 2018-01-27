package gameLogic.firings;

import controller.TimerOfGame;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public enum Weapon implements Firings {
    AntiAircraft(0, 12, 30, 15, 20, 180, 1, false),
    Freezer(5, 3, 20, 5, 60, 170, 1, true),
    Laser(10, 7, 20, 7, 40, 150, 1, false),
    MachineGun(10, 5, 20, 10, 0, 100, 1, false),
    Rocket(20, 10, 40, 3, 0, 180, 1, true);

    private int[] coordinate;
    private int powerOnGroundUnits;
    private int powerOnAirUnits;
    private double range;
    private int fireRate;
    private int speedReduction;
    private int level;
    private boolean isPogromist;
    private ImageView imageView;

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public int price;

    Weapon(int powerOnGroundUnits, int powerOnAirUnits, double range, int fireRate, int speedReduction, int price, int level, boolean isPogromist)  {
        setPrice(price);
        setPowerOnGroundUnits(powerOnGroundUnits);
        setPowerOnAirUnits(powerOnAirUnits);
        setRange(range);
        setFireRate(fireRate);
        setSpeedReduction(speedReduction);
        setLevel(level);
        setPogromist(isPogromist);
    }

    @Override
    public void shoot(TimerOfGame time) {

    }

    @Override
    public void weaken(TimerOfGame time) {

    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int[] getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(int[] coordinate) {
        this.coordinate = coordinate;
    }

    public int getPowerOnGroundUnits() {
        return powerOnGroundUnits;
    }

    public void setPowerOnGroundUnits(int powerOnGroundUnits) {
        this.powerOnGroundUnits = powerOnGroundUnits;
    }

    public int getPowerOnAirUnits() {
        return powerOnAirUnits;
    }

    public void setPowerOnAirUnits(int powerOnAirUnits) {
        this.powerOnAirUnits = powerOnAirUnits;
    }

    public double getRange() {
        return range;
    }

    public void setRange(double range) {
        this.range = range;
    }

    public int getFireRate() {
        return fireRate;
    }

    public void setFireRate(int fireRate) {
        this.fireRate = fireRate;
    }

    public int getSpeedReduction() {
        return speedReduction;
    }

    public void setSpeedReduction(int speedReduction) {
        this.speedReduction = speedReduction;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isPogromist() {
        return isPogromist;
    }

    public void setPogromist(boolean pogromist) {
        isPogromist = pogromist;
    }

    public int getPrice() {
        return price;
    }
}