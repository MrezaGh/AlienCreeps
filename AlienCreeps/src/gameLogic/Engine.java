package gameLogic;

public class Engine {
    private Player player;
    private static Engine engine = new Engine(new Player());

    public Engine(Player player) {
        this.player = player;
    }

    public static Engine getInstance() {
        return engine;
    }

    public Player getPlayer() {
        return player;
    }
}
