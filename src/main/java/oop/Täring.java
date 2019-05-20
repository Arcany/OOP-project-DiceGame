package oop;

import java.util.concurrent.ThreadLocalRandom;

public class Täring {
    private int silmad;

    public Täring(int silmad) {
        this.silmad = silmad;//Mitme silmaline täring on
    }

    public int veereta() {
        int veeretus = ThreadLocalRandom.current().nextInt(1, silmad + 1);//veeretab täringut
        return veeretus;
    }
}

