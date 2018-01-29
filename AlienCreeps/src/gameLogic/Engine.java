package gameLogic;

import gameLogic.firings.movableFirings.Hero;
import gameLogic.firings.movableFirings.alienCreeps.AlienCreeps;

import java.util.ArrayList;

public class Engine {
    private Player player;
    private static ArrayList<AlienCreeps> alienCreepsKilledByHero = new ArrayList<>();
    private static Engine engine = new Engine(new Player());
    public  Hero hero;

    public Engine(Player player) {
        this.player = player;
    }

    public static Engine getInstance() {
        return engine;
    }

    public Player getPlayer() {
        return player;
    }

    public static ArrayList<AlienCreeps> getAlienCreepsKilledByHero() {
        return alienCreepsKilledByHero;
    }
}
