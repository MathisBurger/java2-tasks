package de.assignments.interfaces01;

import java.util.Iterator;
import java.util.List;

public class Leaderboard implements Iterable<Notenblatt> {

    private List<Notenblatt> notenblattList;

    public Leaderboard(List<Notenblatt> notenblattList) {
        this.notenblattList = notenblattList;
    }

    @Override
    public Iterator<Notenblatt> iterator() {
        return this.notenblattList.iterator();
    }
}
