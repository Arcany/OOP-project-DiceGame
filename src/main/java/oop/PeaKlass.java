package oop;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PeaKlass extends Application {
    public void start(Stage peaLava) throws Exception {
        GridPane juur = new GridPane();

        for (int i = 0; i < 12; i++) {
            juur.getColumnConstraints().add(new ColumnConstraints(50)); // column 0 is 50 wide
        }
        for (int i = 0; i < 12; i++) {
            juur.getRowConstraints().add(new RowConstraints(50));
        }

        //juur.setGridLinesVisible(true);
        juur.setBackground(Background.EMPTY);
        juur.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);

        String mängija1nimi = küsiAndmed("Sisesta esimese mängija nimi");
        String mängija2nimi = küsiAndmed("Sisesta teise mängija nimi");
        String võiduSkoor = küsiAndmed("Sisesta võiduskoori suurus");

        Täring täring = new Täring(6);
        Mängija mängija = new Mängija(mängija1nimi, täring);
        Mängija mängija2 = new Mängija(mängija2nimi, täring);

        Täringumäng täringumäng = new Täringumäng(mängija, mängija2);

        täringumäng.mäng(Integer.parseInt(võiduSkoor), juur, peaLava);
    }

    public static void main(String[] args) {
        launch(args);
    }

    public String küsiAndmed(String misAndmed) {
        Stage lava = new Stage();

        VBox vBox = new VBox(15);
        vBox.setBackground(Background.EMPTY);

        Label küsimus = new Label(misAndmed);
        Label tagasiside = new Label();
        tagasiside.setTextFill(Color.RED);

        TextField tekstiväli = new TextField();
        tekstiväli.setMaxWidth(250);

        Button OKnupp = new Button("OK");
        OKnupp.setDefaultButton(true);
        OKnupp.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (tekstiväli.getText().equals("")) {
                    tagasiside.setText("Palun täida lahter!");
                } else {
                    lava.close();
                }
            }
        });

        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(küsimus, tekstiväli, tagasiside, OKnupp);

        Scene stseen = new Scene(vBox, 300, 300, Color.LIGHTGOLDENRODYELLOW);

        stseen.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER) {
                    if (tekstiväli.getText().equals("")) {
                        tagasiside.setText("Palun täida lahter!");
                    } else {
                        lava.close();
                    }
                }
            }
        });

        lava.setTitle("Algandmete sisestamine");
        lava.setScene(stseen);
        lava.showAndWait();

        return tekstiväli.getText();
    }
}
