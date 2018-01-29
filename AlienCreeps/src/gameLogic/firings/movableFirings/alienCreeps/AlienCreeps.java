package gameLogic.firings.movableFirings.alienCreeps;

import gameLogic.map.Path;

import java.util.ArrayList;
import java.util.Random;

public class AlienCreeps {
    private static ArrayList<AlienCreeps> allAlienCreeps = new ArrayList<>();
    private AlienCreepTypes alienCreepTypes;
    private int energy;
    private int counterForMove = 0;
    private Path path;
    private int currentHomeNo = 0;

    public AlienCreeps(AlienCreepTypes alienCreepTypes) {
        this.alienCreepTypes = alienCreepTypes;
        this.energy = alienCreepTypes.initEnergy;
        Random random = new Random(4);
        int randomNumber = random.nextInt() + 1;
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
}
