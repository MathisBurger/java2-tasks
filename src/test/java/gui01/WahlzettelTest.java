package gui01;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WahlzettelTest {

    private static Wahlzettel wahlzettel;
    private static Stage stage;

    public static class InternalWahlzettel extends Wahlzettel {
        public InternalWahlzettel() {super();}

        @Override
        public void start(Stage primaryStage) throws Exception {
            stage = primaryStage;
            super.start(primaryStage);
            wahlzettel = this;
        }
    }

    private static Thread thread;
    private static final Object startupMonitor = new Object();

    @BeforeClass
    public static void setUpBeforeClass() throws InterruptedException {
        // Start the JavaFX Application thread
        thread = new Thread(() -> {
            Application.launch(InternalWahlzettel.class, new String[]{});
        });
        thread.setDaemon(true);
        thread.start();

        while (wahlzettel == null) {
            Thread.sleep(100);
        }
    }

    @AfterClass
    public static void afterAll() {
        // Stop the application gracefully
        Platform.runLater(Platform::exit);

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testA01InitialMessage() {
        assertEquals("Kein Ergebnis vorhanden", wahlzettel.ergebnisLabel.getText());
    }

    @Test
    public void testA02CorrectLabels() {
        assertEquals("Wahlzettel", stage.getTitle());
        assertEquals("CDU", wahlzettel.cduButton.getText());
        assertEquals("SPD", wahlzettel.spdButton.getText());
        assertEquals("FDP", wahlzettel.fdpButton.getText());
        assertEquals("B90/Grüne", wahlzettel.b90GrueneButton.getText());
        String[] options = new String[] {"CDU", "SPD", "FDP", "B90/Grüne"};
        List<String> optionsList = Arrays.asList(options);
        wahlzettel.parteiChoiceBox.getItems().forEach(str -> {
            assertTrue(optionsList.contains(str));
        });
    }

    @Test
    public void testA03ChoiceBoxUpdateOnBtnClick() {
        wahlzettel.cduButton.getOnAction().handle(null);
        assertEquals("CDU", wahlzettel.parteiChoiceBox.getValue());
        wahlzettel.spdButton.getOnAction().handle(null);
        assertEquals("SPD", wahlzettel.parteiChoiceBox.getValue());
        wahlzettel.fdpButton.getOnAction().handle(null);
        assertEquals("FDP", wahlzettel.parteiChoiceBox.getValue());
        wahlzettel.b90GrueneButton.getOnAction().handle(null);
        assertEquals("B90/Grüne", wahlzettel.parteiChoiceBox.getValue());
    }

    @Test
    public void testA04VoteByChoiceBoxChange() {
        wahlzettel.parteiChoiceBox.setValue("CDU");
        wahlzettel.waehlenButton.getOnAction().handle(null);
        assertEquals("Ergebnis: CDU", wahlzettel.ergebnisLabel.getText());

        wahlzettel.parteiChoiceBox.setValue("SPD");
        wahlzettel.waehlenButton.getOnAction().handle(null);
        assertEquals("Ergebnis: SPD", wahlzettel.ergebnisLabel.getText());

        wahlzettel.parteiChoiceBox.setValue("FDP");
        wahlzettel.waehlenButton.getOnAction().handle(null);
        assertEquals("Ergebnis: FDP", wahlzettel.ergebnisLabel.getText());
    }

    @Test
    public void testA05VoteByButtonClick() {
        wahlzettel.cduButton.getOnAction().handle(null);
        wahlzettel.waehlenButton.getOnAction().handle(null);
        assertEquals("Ergebnis: CDU", wahlzettel.ergebnisLabel.getText());

        wahlzettel.fdpButton.getOnAction().handle(null);
        wahlzettel.waehlenButton.getOnAction().handle(null);
        assertEquals("Ergebnis: FDP", wahlzettel.ergebnisLabel.getText());
    }

    @Test
    public void testA06ResetVote() {
        wahlzettel.resetButton.getOnAction().handle(null);
        assertEquals("Kein Ergebnis vorhanden", wahlzettel.ergebnisLabel.getText());
    }

    @Test
    public void testA07WindowSize() {
        assertEquals(400, stage.getScene().getWindow().getHeight(), 30.0);
        assertEquals(600, stage.getScene().getWindow().getWidth(), 30.0);
    }
}
