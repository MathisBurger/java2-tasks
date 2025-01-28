package gui01;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.control.*;

public class Wahlzettel extends Application {

    public Button cduButton;
    public Button spdButton;
    public Button b90GrueneButton;
    public Button fdpButton;
    public Label ergebnisLabel;
    public ChoiceBox<String> parteiChoiceBox;
    public Button waehlenButton;
    public Button resetButton;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Wahlzettel");

        this.ergebnisLabel = new Label("Kein Ergebnis vorhanden");


        this.cduButton = new Button("CDU");
        this.cduButton.setOnAction(e -> this.setStatus("CDU"));
        this.spdButton = new Button("SPD");
        this.spdButton.setOnAction(e -> this.setStatus("SPD"));
        this.fdpButton = new Button("FDP");
        this.fdpButton.setOnAction(e -> this.setStatus("FDP"));
        this.b90GrueneButton = new Button("B90/Grüne");
        this.b90GrueneButton.setOnAction(e -> this.setStatus("B90/Grüne"));

        this.parteiChoiceBox = new ChoiceBox<>();
        this.parteiChoiceBox.getItems().addAll("CDU", "SPD", "FDP", "B90/Grüne");
        Label orLabel = new Label("oder");
        orLabel.setTextAlignment(TextAlignment.CENTER);

        this.waehlenButton = new Button("Wählen");
        this.waehlenButton.setOnAction(e -> {
            if (this.parteiChoiceBox.getValue() != null) {
                this.ergebnisLabel.setText("Ergebnis: " + this.parteiChoiceBox.getValue());
            }
        });

        this.resetButton = new Button("Reset");
        this.resetButton.setOnAction(e -> {
            this.ergebnisLabel.setText("Kein Ergebnis vorhanden");
        });

        HBox selectionVBox = new HBox();
        selectionVBox.setSpacing(10);
        selectionVBox.getChildren().addAll(this.cduButton, this.spdButton, this.fdpButton, this.b90GrueneButton, orLabel, this.parteiChoiceBox, this.waehlenButton, this.resetButton);


        BorderPane mainPane = new BorderPane();
        mainPane.setCenter(this.ergebnisLabel);
        mainPane.setBottom(selectionVBox);

        Scene scene = new Scene(mainPane, 600, 400);
        stage.setScene(scene);
        stage.show();
    }

    private void setStatus(String status) {
        this.parteiChoiceBox.setValue(status);
    }

}
