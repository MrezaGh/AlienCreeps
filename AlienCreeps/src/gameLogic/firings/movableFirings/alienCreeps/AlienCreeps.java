package gameLogic.firings.movableFirings.alienCreeps;

import gameLogic.map.Path;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class AlienCreeps {
    private static ArrayList<AlienCreeps> allAlienCreeps = new ArrayList<>();
    private AlienCreepTypes alienCreepTypes;
    private int energy;
    private int counterForMove = 0;
    private Path path;
    private int currentHomeNo = 0;
    private int moved32Pixel = 0;
    private int[] coordinates = new int[2];
    ImageView imageView = new ImageView();

    public AlienCreeps(AlienCreepTypes alienCreepTypes) {
        this.alienCreepTypes = alienCreepTypes;
        this.energy = alienCreepTypes.initEnergy;
        Random random = new Random();
        int randomNumber = random.nextInt(4) + 1;
        switch (randomNumber) {
            case 1:
                path = new Path();
                path.setThisPathHomes(Path.getPathHomes1_1());
                break;
            case 2:
                path = new Path();
                path.setThisPathHomes(Path.getPathHomes1_2());
                break;
            case 3:
                path = new Path();
                path.setThisPathHomes(Path.getPathHomes2_1());
                break;
            case 4:
                path = new Path();
                path.setThisPathHomes(Path.getPathHomes2_2());
                break;
        }
        coordinates = new int[]{path.getThisPathHomes().get(0)[0], path.getThisPathHomes().get(0)[1]};
        allAlienCreeps.add(this);
    }

    public static ArrayList<AlienCreeps> getAllAlienCreeps() {
        return allAlienCreeps;
    }

    public static void setAllAlienCreeps(ArrayList<AlienCreeps> allAlienCreeps) {
        AlienCreeps.allAlienCreeps = allAlienCreeps;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getCounterForMove() {
        return counterForMove;
    }

    public void setCounterForMove(int counterForMove) {
        this.counterForMove = counterForMove;
    }

    public AlienCreepTypes getAlienCreepTypes() {
        return alienCreepTypes;
    }

    public void setAlienCreepTypes(AlienCreepTypes alienCreepTypes) {
        this.alienCreepTypes = alienCreepTypes;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public int getCurrentHomeNo() {
        return currentHomeNo;
    }

    public void setCurrentHomeNo(int currentHomeNo) {
        this.currentHomeNo = currentHomeNo;
    }

    public int getMoved32Pixel() {
        return moved32Pixel;
    }

    public void setMoved32Pixel(int moved32Pixel) {
        this.moved32Pixel = moved32Pixel;
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(int[] coordinates) {
        this.coordinates = coordinates;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }
}
