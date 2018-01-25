package gameLogic;
import gameLogic.firings.*;

public class WeaponPlace {
    WeaponPlace[] weaponPlaces = new WeaponPlace[8];
    private int weaponPlaceNumber;
    private int[] coordinates = new int[2];
    Weapon weapon;

    public WeaponPlace(int weaponPlaceNumber, int[] coordinates) {
        this.weaponPlaceNumber = weaponPlaceNumber;
        this.coordinates = coordinates;
        WeaponPlace[] allWeaponPlaces;

    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(String name) {
        this.weapon = Weapon.valueOf(name);
    }

    public int getWeaponPlaceNumber() {
        return weaponPlaceNumber;
    }

    public void setWeaponPlaceNumber(int weaponPlaceNumber) {
        this.weaponPlaceNumber = weaponPlaceNumber;
    }



    public int[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(int[] coordinates) {
        this.coordinates = coordinates;
    }
}
