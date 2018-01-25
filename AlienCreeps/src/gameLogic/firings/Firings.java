package gameLogic.firings;

import controller.TimerOfGame;

public interface Firings {
    void shoot(TimerOfGame time);
    void weaken(TimerOfGame time);

}
