package comparator01;

import java.util.List;

public class Notenblatt {

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
}
