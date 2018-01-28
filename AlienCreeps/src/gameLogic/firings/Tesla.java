package gameLogic.firings;

import controller.TimerOfGame;

public class Tesla implements Firings {
    private static boolean possibleOrNot = false;
    private static Tesla tesla = new Tesla();
    private Tesla() {

    }

    public static boolean isPossibleOrNot() {
        return possibleOrNot;
    }

    public static void setPossibleOrNot(boolean possibleOrNot) {
        Tesla.possibleOrNot = possibleOrNot;
    }

    public static Tesla getInstance() {
        return tesla;
    }

    @Override
    public void shoot(TimerOfGame time) {
        
    }

    @Override
    public void weaken(TimerOfGame time) {

    }
}
