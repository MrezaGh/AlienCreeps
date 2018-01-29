package gameLogic.firings.movableFirings.alienCreeps;

import controller.TimerOfGame;
import gameLogic.map.Path;

import java.util.Random;

public enum AlienCreepTypes {
    Activionion(400, 2, "ground", 40),
    Aironion(200, 5, "air", 20),
    Albertonion(250, 10, "ground", 7),
    Algwasonion(150, 5, "ground", 25);

    private String type;//air or ground
    int initEnergy;
    int speed;
    int power;

    public void shoot(TimerOfGame time) {
        //TODO
    }

    public void weaken(TimerOfGame time) {
        //TODO
    }

    AlienCreepTypes(int energy, int speed, String type, int power) {
        setType(type);
        initEnergy = energy;
        this.speed = speed;
        this.power = power;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    public int getInitEnergy() {
        return initEnergy;
    }

    public void setInitEnergy(int initEnergy) {
        this.initEnergy = initEnergy;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
