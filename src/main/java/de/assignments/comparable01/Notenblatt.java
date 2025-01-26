package de.assignments.comparable01;

import java.util.List;

public class Notenblatt implements Comparable<Notenblatt> {

    private final List<Float> noten;

    public Notenblatt(List<Float> noten) {
        this.noten = noten;
    }

    public Float getDurchschnitt() {
        float sum = 0f;
        for (float noten : noten) {
            sum += noten;
        }
        return sum / noten.size();
    }


    @Override
    public int compareTo(Notenblatt notenblatt) {
        return this.getDurchschnitt().compareTo(notenblatt.getDurchschnitt());
    }
}
