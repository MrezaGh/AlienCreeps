package controller;

import gameLogic.WeaponPlace;
import gameLogic.firings.Weapon;

public class ControllerClass {
    public void setWeapon(int numOfWeapnPlace, String name) {
        for (int i = 0; i < WeaponPlace.getWeaponPlaces().length; i++) {
            if (i == numOfWeapnPlace) {
                WeaponPlace.getWeaponPlaces()[i].setWeapon(name);
            }
        }
    }
}
