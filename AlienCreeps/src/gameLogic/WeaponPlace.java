package gameLogic;
import gameLogic.firings.*;

public class WeaponPlace {
    private static WeaponPlace[] weaponPlaces = new WeaponPlace[8];
    private int weaponPlaceNumber;
    private int[] coordinates = new int[2];
    Weapon weapon;
    static {
        weaponPlaces[0] = new WeaponPlace(0,new int[]{352,64});
        weaponPlaces[1] = new WeaponPlace(1,new int[]{1056,736});
        weaponPlaces[2] = new WeaponPlace(2,new int[]{800, 736});
        weaponPlaces[3] = new WeaponPlace(3,new int[]{800, 544});
        weaponPlaces[4] = new WeaponPlace(4,new int[]{896, 320});
        weaponPlaces[5] = new WeaponPlace(5,new int[]{608, 320});
        weaponPlaces[6] = new WeaponPlace(6,new int[]{384,320});
        weaponPlaces[7] = new WeaponPlace(7,new int[]{192,544});
    }

    public WeaponPlace(int weaponPlaceNumber, int[] coordinates) {
        this.weaponPlaceNumber = weaponPlaceNumber;
        this.coordinates = coordinates;

    }

    public static WeaponPlace[] getWeaponPlaces() {
        return weaponPlaces;
    }

    public static void setWeaponPlaces(WeaponPlace[] weaponPlaces) {
        WeaponPlace.weaponPlaces = weaponPlaces;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(String name) {
        this.weapon = Weapon.valueOf(name);
        System.out.println("gozashtam");
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
