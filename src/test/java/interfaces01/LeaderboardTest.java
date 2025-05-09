package interfaces01;

import de.assignments.interfaces01.Leaderboard;
import de.assignments.interfaces01.Notenblatt;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LeaderboardTest {

    @Test
    public void testLeaderboard() {

        Notenblatt notenblatt = new Notenblatt(new int[] {1,2,3}, "WINF");

        List<Notenblatt> notenblattList = Arrays.asList(notenblatt);

        Leaderboard leaderboard = new Leaderboard(notenblattList);
        for (Notenblatt nb : leaderboard) {
            assertEquals(2f, nb.getDurchschnitt(), 0.3f);
        }
    }
}
