package gameLogic.firings.movableFirings;

import gameLogic.Engine;
import gameLogic.firings.movableFirings.alienCreeps.AlienCreeps;

import java.util.ArrayList;
import java.util.Arrays;


public abstract class YourFighters extends MovableFirings {
    private ArrayList<AlienCreeps> alienCreepsKilled = new ArrayList<>();
    protected int experience;
    protected int level = 1;


    public int getExperience() {
        return experience;
    }


    private void checkToIncreaseLevel() {
        if (experience > 50 * level && level < 3) {
            level++;
        }
    }

    protected abstract void increaseExperience();

    private ArrayList<AlienCreeps> updateTargets() {
        return findSomeTarget();
    }

    protected ArrayList<AlienCreeps> manageTargets(ArrayList<AlienCreeps> targets) {
        for (AlienCreeps alienCreep : targets) {
            if (alienCreep.isDead() == true) {
                this.increaseExperience();
                if (this.getClass() == Hero.class) {
                    Engine.getInstance().getAlienCreepsKilledByHero().add(alienCreep);//TODO
                }
                AlienCreeps.getAllAlienCreeps().remove(alienCreep);
                targets.remove(alienCreep);
            }
        }
        if (targets.size() == 0 && isPogromist() == false) {
            targets = updateTargets();
        }
        return targets;
    }

    public static double calculateDistance(int[] coordinate1, int[] coordinate2) {
        int differenceToX = Math.abs(coordinate1[0] - coordinate2[0]);
        int differenceToY = Math.abs(coordinate1[1] - coordinate2[1]);
        double distance = Math.sqrt(Math.pow(differenceToX, 2) + Math.pow(differenceToY, 2));
        return distance;
    }


    public ArrayList<AlienCreeps> findOneTarget() {
        double distance;
        double minDistance = 0;
        ArrayList<AlienCreeps> targets = new ArrayList<>();
        for (AlienCreeps alienCreep : AlienCreeps.getAllAlienCreeps()) {
            distance = calculateDistance(this.getCoordinate(), alienCreep.getCoordinates());
            if (distance < this.getFireRange()) {

                if (alienCreep.getAlienCreepTypes().getType().equals("air") && ((Hero) this).getGun().getPowerOnAirUnits() == 0) {
                    continue;
                }
                if (alienCreep.getAlienCreepTypes().getType().equals("ground") && ((Hero) this).getGun().getPowerOnGroundUnits() == 0) {
                    continue;
                }//TODO refactor

                if (distance < minDistance) { // find mindistance TODO refactor
                    minDistance = distance;
                    targets.set(0, alienCreep);
                }
            }
        }
        return targets;
    }


    public ArrayList<AlienCreeps> findSomeTarget() {
        double distance;
        ArrayList<AlienCreeps> targets = new ArrayList<>();
        for (AlienCreeps alienCreep : AlienCreeps.getAllAlienCreeps()) {
            distance = calculateDistance(this.getCoordinate(), alienCreep.getCoordinates());
            if (distance < getFireRange()) {
                /*if (!(alienCreep.getType().equals(((Hero)this).getGun()))){
                    continue;
                }*/
                if (alienCreep.getAlienCreepTypes().getType().equals("air") && ((Hero) this).getGun().getPowerOnAirUnits() == 0) {
                    continue;
                }
                if (alienCreep.getAlienCreepTypes().getType().equals("ground") && ((Hero) this).getGun().getPowerOnGroundUnits() == 0) {
                    continue;
                }
                //alienCreep.energy -= this.power * fireRate;
                targets.add(alienCreep);
            }
        }
        return targets;
    }

    public void shoot() {
        weaken();
        freeze();
    }

    public abstract void freeze();


    public void findTargetOfAlienCreep(ArrayList<AlienCreeps> targets) {
        if ((this.getClass() == Hero.class) || (this.getClass() == Soldier.class)) {
            if (targets.size() == 0) {
                return;
            }
            AlienCreeps alienCreep = (AlienCreeps) targets.get(0);
            alienCreep.setShooterToThis(new ArrayList<YourFighters>(Arrays.asList(this)));
        }
    }

    public YourFighters() {
        super(0, 0, 300, 6, 20, 0.5 * 20, false);
    }

    public YourFighters(boolean b) {
        super(0, 0, 150, 20, 5, 0.5 * 20,false);
    }
}
