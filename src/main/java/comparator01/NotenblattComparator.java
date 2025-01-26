package comparator01;

import java.util.Comparator;

public class NotenblattComparator implements Comparator<Notenblatt> {


    @Override
    public int compare(Notenblatt t0, Notenblatt t1) {
        if (t0 == null && t1 == null) {
            return 0;
        }
        if (t0 == null) {
            return -1;
        }
        if (t1 == null) {
            return 1;
        }
        if (t0.getDurchschnitt() < t1.getDurchschnitt()) {
            return -1;
        }
        if (t0.getDurchschnitt() > t1.getDurchschnitt()) {
            return 1;
        }
        return 0;
    }
}
