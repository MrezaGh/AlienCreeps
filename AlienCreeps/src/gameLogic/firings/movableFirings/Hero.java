package gameLogic.firings.movableFirings;

import gameLogic.Engine;
import gameLogic.firings.Gun;
import gameLogic.firings.movableFirings.alienCreeps.AlienCreeps;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Hero extends YourFighters {
    private Group root;
    private int energy;
    private int power;
    private int fireRate;
    private double fireRange;
    private int[] coordinate = new int[2];
    public ImageView[] heroMoveLeftPics = new ImageView[4];
    public ImageView[] heroMoveRightPics = new ImageView[4];
    public ImageView[] heroMoveForwardPics = new ImageView[4];
    public ImageView[] heroMoveDownwardPics = new ImageView[4];
    private int walkState = 0;
    Gun gun;
    private ArrayList<Soldier> allSoldiers = new ArrayList<>();

    public Hero(Group root) {//todo change variables
        super();
        this.energy = 100;
        this.power = 8;
        this.fireRate = 5;
        this.fireRange = 2;
        this.coordinate = new int[]{1056, 872};
        MovableFirings.getAllMovableFirings().add(this);
        this.root = root;
        Engine.getInstance().hero = this;
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
        drawHero(heroMoveLeftPics, walkState);
    }

    public void moveHeroForward(int speed) {
        this.setCoordinate(new int[]{getCoordinate()[0], getCoordinate()[1] - speed});
        walkState++;
        if (walkState == 4)
            walkState = 0;
        drawHero(heroMoveForwardPics, walkState);
    }

    public void moveHeroDownward(int speed) {
        this.setCoordinate(new int[]{getCoordinate()[0], getCoordinate()[1] + speed});
        walkState++;
        if (walkState == 4)
            walkState = 0;
        drawHero(heroMoveDownwardPics, walkState);
    }

    public void moveHeroLeft(int speed) {
        this.setCoordinate(new int[]{getCoordinate()[0] - speed, getCoordinate()[1]});
        walkState++;
        if (walkState == 4)
            walkState = 0;
        drawHero(heroMoveLeftPics, walkState);
    }

    public void moveHeroRight(int speed) {
        this.setCoordinate(new int[]{getCoordinate()[0] + speed, getCoordinate()[1]});
        walkState++;
        if (walkState == 4)
            walkState = 0;
        drawHero(heroMoveRightPics, walkState);
    }

    public void drawHero(ImageView[] heroPics, int stateOfWalk) {

        try {
            ImageView hero = heroPics[stateOfWalk];
            hero.relocate(getCoordinate()[0], getCoordinate()[1]);
            removePreviousHeroPic();
            root.getChildren().add(hero);
        } catch (Exception e) {
            e.printStackTrace();
        }

        setMovableMoved(true);

    }

    private void removePreviousHeroPic() {
        for (ImageView element : heroMoveForwardPics) {
            if (root.getChildren().contains(element))
                root.getChildren().remove(element);
        }
        for (ImageView element : heroMoveDownwardPics) {
            if (root.getChildren().contains(element))
                root.getChildren().remove(element);
        }
        for (ImageView element : heroMoveLeftPics) {
            if (root.getChildren().contains(element))
                root.getChildren().remove(element);
        }
        for (ImageView element : heroMoveRightPics) {
            if (root.getChildren().contains(element))
                root.getChildren().remove(element);
        }
    }

    private ArrayList<AlienCreeps> findHeroTargets() {
        if (gun.isPogromist() == false) {
            return this.findOneTarget();
        } else {
            return this.findSomeTarget();
        }
    }

    @Override
    public void weaken() {
        ArrayList<AlienCreeps> targets = findHeroTargets();
            for (AlienCreeps target : targets) {
                if (target.getAlienCreepTypes().getType().equals("air")) {
                    target.setEnergy(target.getEnergy() - gun.getPowerOnAirUnits());
                } else {
                    target.setEnergy(target.getEnergy() - gun.getPowerOnGroundUnits());
                }

                targets = manageTargets(targets);
            }
        findTargetOfAlienCreep(targets);
    }

    @Override
    public void freeze() {
        ArrayList<AlienCreeps> targets = findSomeTarget();

            for (MovableFirings target : targets) {
                if (target.getSpeedModified() != target.getSpeedUnmodified()) {
                    continue;//TODO
                }

                target.setSpeedModified(((100 - gun.getSpeedReduction()) / 100) * target.getSpeedUnmodified());
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

    public Gun getGun() {
        return gun;
    }

    public ArrayList<Soldier> getAllSoldiers() {
        return allSoldiers;
    }

    @Override
    public void shoot() {

    }


    @Override
    protected void increaseExperience() {

    }


}
