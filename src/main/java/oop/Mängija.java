package oop;

public class Mängija {
    private String nimi;
    private Täring täring;
    private int skoor = 0;
    private int maxSkoor = 0;

    public Mängija(String nimi, Täring täring) {
        this.nimi = nimi;
        this.täring = täring;
    }

    public int veereta() {
        int veeretus = täring.veereta();
        lisaSkoor(veeretus);
        return veeretus;
    }

    public void setMaxSkoor(int maxSkoor) {
        this.maxSkoor = maxSkoor;
    }

    public int getMaxSkoor() {
        return maxSkoor;
    }

    public void lisaSkoor(int lisa) {
        skoor += lisa;
    }

    public int getSkoor() {
        return skoor;
    }

    public void setSkoor(int skoor) {
        this.skoor = skoor;
    }

    public String getNimi() {
        return nimi;
    }

    @Override
    public String toString() {
        System.out.println();
        return "Võitja on: " + nimi;
    }
}
