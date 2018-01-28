package gameLogic.firings.movableFirings;

import gameLogic.firings.Firings;

public abstract class MovableFirings  implements Firings {
    private int speedUnmodified;
    private int speedModified;
    private int energy;
    private int power;
    private int fireRate;
    private double fireRange;
    private boolean isPogromist;
    private int[] coordinate = new int[2];


    public MovableFirings(int speedUnmodified, int speedModified, int energy, int power, int fireRate, double fireRange, boolean isPogromist, int[] coordinate) {
        this.speedUnmodified = speedUnmodified;
        this.speedModified = speedModified;
        this.energy = energy;
        this.power = power;
        this.fireRate = fireRate;
        this.fireRange = fireRange;
        this.isPogromist = isPogromist;
        this.coordinate = coordinate;
    }

    public void setPogromist(boolean pogromist) {
        isPogromist = pogromist;
    }

    public boolean isPogromist() {
        return isPogromist;
    }

    public int getSpeedModified() {
        return speedModified;
    }

    public void setSpeedModified(int speedModified) {
        this.speedModified = speedModified;
    }

    public int[] getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(int[] coordinate) {
        this.coordinate[0] = coordinate[0];
        this.coordinate[1] = coordinate[1];
    }



    public boolean isDead() {
        if (this.energy <= 0) {

            return true;
        }
        return false;
    }

    /**
     * tabe e payin faghat vase vaghtie ke yedoone target dashte bashe chon momkene do ta alien ham fasele
     * bahash bashan vali in faghat yekishoono mizane .
     * اگه همه ی همسايه هاش رو بزنه که اگه همه بميرن که ديگه چيزی تو شعاعش نيست .
     */


    // alaki neveshtam ke too soldier gir nade ke constructor benevis
    public MovableFirings() {

    }

    public int getSpeedUnmodified() {
        return speedUnmodified;
    }

    public void setSpeedUnmodified(int speedUnmodified) {
        this.speedUnmodified = speedUnmodified;
    }



    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getFireRate() {
        return fireRate;
    }

    public void setFireRate(int fireRate) {
        this.fireRate = fireRate;
    }

    public double getFireRange() {
        return fireRange;
    }

    public void setFireRange(double fireRange) {
        this.fireRange = fireRange;
    }



}