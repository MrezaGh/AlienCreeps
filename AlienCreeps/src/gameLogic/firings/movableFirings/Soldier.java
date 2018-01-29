package gameLogic.firings.movableFirings;

import gameLogic.Barrack;
import gameLogic.Engine;
import gameLogic.firings.movableFirings.alienCreeps.AlienCreeps;

import java.util.ArrayList;

public class Soldier extends YourFighters {

    public Soldier() { // hero behesh ezafe kardam ta too sarbazash adesh konam
        super(true);
        Engine.getInstance().hero.getAllSoldiers().add(this);
    }

    public boolean isDead(Hero hero, Barrack barrack) {
        boolean dead = super.isDead();
        if (dead == true) {
            hero.getAllSoldiers().remove(this);
            Barrack.getInstance().getMinsToCreateASoldier().add(0);
        }
        return dead;
    }

    @Override
    protected void increaseExperience() {
        experience += 5;
    }

    @Override
    public void shoot() {
        weaken();
    }

    @Override
    public void freeze() {

    }

    @Override
    public void weaken() {
        ArrayList<AlienCreeps> targets = findSomeTarget();
            for (AlienCreeps target : targets) {
                target.setEnergy(target.getEnergy() - this.getPower());
                targets = manageTargets(targets);
            }
        findTargetOfAlienCreep(targets);
    }

    public void move(Hero hero) {
        for (int i = 0; i < hero.getAllSoldiers().size(); i++) {
            if (i == 0) {
                setCoordinate(new int[]{hero.getCoordinate()[0] + 20, hero.getCoordinate()[1]});
            }
            if (i == 1) {
                setCoordinate(new int[]{hero.getCoordinate()[0] - 20, hero.getCoordinate()[1]});
            }
            if (i == 2) {
                setCoordinate(new int[]{hero.getCoordinate()[0], hero.getCoordinate()[1] + 20});
            }
        }
    }
}