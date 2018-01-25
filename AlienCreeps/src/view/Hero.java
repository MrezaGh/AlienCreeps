package view;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Hero {
    private Group root;
    private int energy;
    private int power;
    private int fireRate;
    private double fireRange;
    private int[] coordinate = new int[2];
    public ImageView[] heroMoveLeftPics= new ImageView[4];
    public ImageView[] heroMoveRightPics = new ImageView[4];
    public ImageView[] heroMoveForwardPics = new ImageView[4];
    public ImageView[] heroMoveDownwardPics = new ImageView[4];


    public Hero(Group root) {//todo change variables
        this.energy = 100;
        this.power = 8;
        this.fireRate = 5;
        this.fireRange = 2;
        this.coordinate = new int[]{1056, 872};
        this.root = root;
        try {
            heroMoveLeftPics[0] = new ImageView(new Image(new FileInputStream(new File("images/hero images/MoveLeft1.png"))));
            heroMoveLeftPics[1] = new ImageView(new Image(new FileInputStream(new File("images/hero images/MoveLeft2.png"))));
            heroMoveLeftPics[2] = new ImageView(new Image(new FileInputStream(new File("images/hero images/MoveLeft3.png"))));
            heroMoveLeftPics[3] = new ImageView(new Image(new FileInputStream(new File("images/hero images/MoveLeft4.png"))));

            heroMoveRightPics[0] = new ImageView(new Image(new FileInputStream(new File("images/hero images/MoveRight1.png"))));
            heroMoveRightPics[1] = new ImageView(new Image(new FileInputStream(new File("images/hero images/MoveRight2.png"))));
            heroMoveRightPics[2] = new ImageView(new Image(new FileInputStream(new File("images/hero images/MoveRight3.png"))));
            heroMoveRightPics[3] = new ImageView(new Image(new FileInputStream(new File("images/hero images/MoveRight4.png"))));

            heroMoveForwardPics[0] = new ImageView(new Image(new FileInputStream(new File("images/hero images/MoveForward1.png"))));
            heroMoveForwardPics[1] = new ImageView(new Image(new FileInputStream(new File("images/hero images/MoveForward2.png"))));
            heroMoveForwardPics[2] = new ImageView(new Image(new FileInputStream(new File("images/hero images/MoveForward3.png"))));
            heroMoveForwardPics[3] = new ImageView(new Image(new FileInputStream(new File("images/hero images/MoveForward4.png"))));

            heroMoveDownwardPics[0] = new ImageView(new Image(new FileInputStream(new File("images/hero images/MoveDownward1.png"))));
            heroMoveDownwardPics[1] = new ImageView(new Image(new FileInputStream(new File("images/hero images/MoveDownward2.png"))));
            heroMoveDownwardPics[2] = new ImageView(new Image(new FileInputStream(new File("images/hero images/MoveDownward3.png"))));
            heroMoveDownwardPics[3] = new ImageView(new Image(new FileInputStream(new File("images/hero images/MoveDownward4.png"))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void moveHeroForward(){
        this.setCoordinate(new int[]{getCoordinate()[0],getCoordinate()[1]-5});
        drawHero(heroMoveForwardPics,0);//-------------------------------------------------------------------
    }

    public void drawHero(ImageView[] heroPics, int stateOfWalk) {
        try {
            ImageView hero = heroPics[stateOfWalk];
            hero.relocate(getCoordinate()[0],getCoordinate()[1]);
            root.getChildren().remove(hero);
            root.getChildren().add(hero);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getFireRate() {
        return fireRate;
    }

    public void setFireRate(int fireRate) {
        this.fireRate = fireRate;
    }

    public double getFireRange() {
        return fireRange;
    }

    public void setFireRange(double fireRange) {
        this.fireRange = fireRange;
    }

    public int[] getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(int[] coordinate) {
        this.coordinate = coordinate;
    }
}
