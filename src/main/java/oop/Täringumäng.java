package oop;

import javafx.animation.PauseTransition;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;

public class Täringumäng {
    private Mängija esimene;
    private Mängija teine;
    private int veeretus;
    private Mängija kelleKord;

    private Label alumineTekstiriba = new Label(); //Mänguteated
    private Label esimeneMängija = new Label("1. mängija"); //Mängijate tähistus
    private Label teineMängija = new Label("2. mängija:");
    private Label esimeseNimi = new Label(); //Mängijate nimed
    private Label teiseNimi = new Label();
    private Label esimeseMax = new Label("Max skoor: 0"); //Maksimum skoorid
    private Label teiseMax = new Label("Max skoor: 0");
    private Label kelleKäikOn = new Label("Praegu on 1. mängija kord"); //Kelle käik on
    private Label vajatavSkoor = new Label(); //Vajatav skoor
    private Label praeguneSkoor = new Label("Praegune skoor on: 0"); //Praegune skoor
    private Button veeretaNupp = new Button("Veereta");  //Veeretamise nupp, töötab ka ENTERi vajutus
    private Shape täringuRistkülik = new Rectangle();   //Täringu valge külg
    private Shape silmad1 = new Circle();// Täringu silmad
    private Shape silmad2 = new Circle();
    private Shape silmad3 = new Circle();
    private Shape silmad4 = new Circle();
    private Shape silmad5 = new Circle();
    private Shape silmad6 = new Circle();
    private Shape silmad7 = new Circle();

    public Täringumäng(Mängija esimene, Mängija teine) {
        this.esimene = esimene;
        this.teine = teine;
    }

    public void UIElemendid(GridPane juur, int võiduSkoor, Stage peaLava) {
        esimeneMängija.setFont(new Font("Cambria", 24));
        esimeneMängija.setTextFill(Color.DARKTURQUOISE);
        teineMängija.setFont(new Font("Cambria", 24));
        teineMängija.setTextFill(Color.DARKTURQUOISE);

        juur.add(esimeneMängija, 8, 0, 3, 1);
        juur.add(teineMängija, 8, 3, 3, 1);

        esimeseNimi.setText("Nimi: " + esimene.getNimi());
        esimeseNimi.setFont(new Font("Cambria", 16));
        esimeseNimi.setTextFill(Color.DARKTURQUOISE);
        teiseNimi.setText("Nimi: " + teine.getNimi());
        teiseNimi.setFont(new Font("Cambria", 16));
        teiseNimi.setTextFill(Color.DARKTURQUOISE);

        juur.add(esimeseNimi, 9, 1, 2, 1);
        juur.add(teiseNimi, 9, 4, 2, 1);

        esimeseMax.setFont(new Font("Cambria", 16));
        esimeseMax.setTextFill(Color.DARKTURQUOISE);
        teiseMax.setFont(new Font("Cambria", 16));
        teiseMax.setTextFill(Color.DARKTURQUOISE);

        juur.add(esimeseMax, 9, 2, 3, 1);
        juur.add(teiseMax, 9, 5, 3, 1);

        kelleKäikOn.setFont(new Font("Cambria", 25));
        kelleKäikOn.setTextFill(Color.RED);

        juur.add(kelleKäikOn, 1, 0, 7, 1);

        vajatavSkoor.setText("Vaja on saada üle " + võiduSkoor + " punkti.");
        vajatavSkoor.setWrapText(true);
        vajatavSkoor.setFont(new Font("Cambria", 16));
        vajatavSkoor.setTextFill(Color.RED);

        juur.add(vajatavSkoor, 8, 6, 4, 2);

        praeguneSkoor.setFont(new Font("Cambria", 24));
        praeguneSkoor.setTextFill(Color.DARKTURQUOISE);

        juur.add(praeguneSkoor, 1, 1, 7, 2);


        alumineTekstiriba.setFont(new Font("Cambria", 34)); //Mänguteated
        alumineTekstiriba.setTextFill(Color.RED);
        alumineTekstiriba.setWrapText(true);

        juur.add(alumineTekstiriba, 1, 9, 7, 2);

        veeretaNupp.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mängukäik(võiduSkoor, peaLava);
            }
        });
        veeretaNupp.setMinSize(150, 100);
        juur.add(veeretaNupp, 8, 9, 3, 2);

        täringuRistkülik.setFill(Color.WHITE);
        ((Rectangle) täringuRistkülik).setWidth(250);
        ((Rectangle) täringuRistkülik).setHeight(250);
        juur.add(täringuRistkülik, 1, 3, 5, 5);
        silmad1.setFill(Color.WHITE);
        ((Circle) silmad1).setRadius(20);
        silmad2.setFill(Color.WHITE);
        ((Circle) silmad2).setRadius(20);
        silmad3.setFill(Color.WHITE);
        ((Circle) silmad3).setRadius(20);
        silmad4.setFill(Color.WHITE);
        ((Circle) silmad4).setRadius(20);
        silmad5.setFill(Color.WHITE);
        ((Circle) silmad5).setRadius(20);
        silmad6.setFill(Color.WHITE);
        ((Circle) silmad6).setRadius(20);
        silmad7.setFill(Color.WHITE);
        ((Circle) silmad7).setRadius(20);
        juur.add(silmad7, 5, 3, 5, 5);
        juur.add(silmad6, 1, 3, 5, 5);
        juur.add(silmad2, 1, 1, 5, 5);
        juur.add(silmad1, 3, 3, 1, 5);
        juur.add(silmad3, 5, 5, 5, 5);
        juur.add(silmad4, 5, 1, 5, 5);
        juur.add(silmad5, 1, 5, 5, 5);
    }

    private void mängukäik(int võiduSkoor, Stage peaLava) {
        veeretus = kelleKord.veereta();
        if (veeretus == 1) {
            teeValgeks();
            silmad1.setFill(Color.BLACK);
            alumineTekstiriba.setText("Nuuks! :( Veeretasid ühe. Mängijavahetus!");
            praeguneSkoor.setText("Praegune skoor on: 0");

            if (kelleKord.getMaxSkoor() < kelleKord.getSkoor()) {
                kelleKord.setMaxSkoor(kelleKord.getSkoor());
                kelleKord.setSkoor(0);

            } else if (kelleKord.getMaxSkoor() >= kelleKord.getSkoor()) {
                kelleKord.setSkoor(0);
            }


            if (kelleKord.equals(esimene)) {
                kelleKäikOn.setText("Praegu on 2. mängija kord");
                esimeseMax.setText("Max skoor: " + kelleKord.getMaxSkoor());
                kelleKord = teine;
            } else if (kelleKord.equals(teine)) {
                kelleKäikOn.setText("Praegu on 1. mängija kord");
                teiseMax.setText("Max skoor: " + kelleKord.getMaxSkoor());
                kelleKord = esimene;
            }


        } else {
            if (veeretus == 2) {
                teeValgeks();
                silmad2.setFill(Color.BLACK);
                silmad3.setFill(Color.BLACK);
            } else if (veeretus == 3) {
                teeValgeks();
                silmad5.setFill(Color.BLACK);
                silmad1.setFill(Color.BLACK);
                silmad4.setFill(Color.BLACK);
            } else if (veeretus == 4) {
                teeValgeks();
                silmad5.setFill(Color.BLACK);
                silmad2.setFill(Color.BLACK);
                silmad3.setFill(Color.BLACK);
                silmad4.setFill(Color.BLACK);
            } else if (veeretus == 5) {
                teeValgeks();
                silmad1.setFill(Color.BLACK);
                silmad5.setFill(Color.BLACK);
                silmad2.setFill(Color.BLACK);
                silmad3.setFill(Color.BLACK);
                silmad4.setFill(Color.BLACK);
            } else {
                teeValgeks();
                silmad5.setFill(Color.BLACK);
                silmad2.setFill(Color.BLACK);
                silmad3.setFill(Color.BLACK);
                silmad4.setFill(Color.BLACK);
                silmad6.setFill(Color.BLACK);
                silmad7.setFill(Color.BLACK);
            }
            alumineTekstiriba.setText("");
            praeguneSkoor.setText("Praegune skoor on: " + kelleKord.getSkoor());
        }

        if (kelleKord.getSkoor() > võiduSkoor) {
            mänguLõpp(kelleKord, peaLava);
        }
    }

    private void mänguLõpp(Mängija kelleKord, Stage peaLava) {
        peaLava.close();

        VBox paan = new VBox();
        paan.setAlignment(Pos.CENTER);
        paan.setBackground(Background.EMPTY);
        File fileDir = new File("võitja.txt");

        try (Writer out = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(fileDir), "UTF8"))) {
            out.append(kelleKord.getNimi()).append("\r\n");
        } catch (Exception e) {
            e.printStackTrace();
        }


        Label võitja = new Label("Võitja on " + kelleKord.getNimi());
        võitja.setFont(new Font("Cambria", 35));
        võitja.setTextFill(Color.DARKTURQUOISE);

        paan.getChildren().add(võitja);

        Scene stseen = new Scene(paan, 600, 600, Color.LIGHTGOLDENRODYELLOW);
        Stage lava = new Stage();
        lava.setScene(stseen);
        lava.show();

        stseen.setOnKeyPressed(event -> lava.close());
    }

    public void teeValgeks() {
        silmad1.setFill(Color.WHITE);
        silmad2.setFill(Color.WHITE);
        silmad3.setFill(Color.WHITE);
        silmad4.setFill(Color.WHITE);
        silmad5.setFill(Color.WHITE);
        silmad6.setFill(Color.WHITE);
        silmad7.setFill(Color.WHITE);

    }

    public void mäng(int võiduSkoor, GridPane juur, Stage peaLava) throws Exception {
        alustaMängu(võiduSkoor);

        UIElemendid(juur, võiduSkoor, peaLava); //Elemendid, mis ei vaja edasist redigeerimist.

        HBox horisontaalne = new HBox();
        horisontaalne.setAlignment(Pos.CENTER);

        horisontaalne.getChildren().add(juur);
        VBox paan = new VBox();
        paan.setAlignment(Pos.CENTER);

        paan.getChildren().add(horisontaalne);

        Scene stseen = new Scene(paan, 600, 600, Color.LIGHTGOLDENRODYELLOW);  // luuakse stseen
        peaLava.setTitle("Täringumäng");  // lava tiitelribale pannakse tekst
        peaLava.setScene(stseen);  // lavale lisatakse stseen
        peaLava.show();  // lava tehakse nähtavaks

        kelleKord = esimene;

        stseen.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER) {
                    mängukäik(võiduSkoor, peaLava);
                }
            }
        });


    }

    public void vajutaEnteritSissejuhatus(Scene stseen, Stage lava) {
        stseen.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER) {
                    lava.close();
                }
            }
        });
    }

    public void sulgeAken(Stage lava) {
        PauseTransition delay = new PauseTransition(Duration.millis(1500));
        delay.setOnFinished(event -> lava.close());
        delay.play();
        lava.showAndWait();
    }

    public void alustaMängu(int võiduSkoor) throws Exception {
        Stage lava = new Stage();

        VBox vertikaal = new VBox(150);
        vertikaal.setAlignment(Pos.CENTER);

        Label kirjeldus1 = new Label();
        kirjeldus1.setFont(new Font("Cambria", 32));
        kirjeldus1.setTextFill(Color.DARKTURQUOISE);
        kirjeldus1.setWrapText(true);
        kirjeldus1.setTextAlignment(TextAlignment.CENTER);

        Label kirjeldus2 = new Label();
        kirjeldus2.setFont(new Font("Cambria", 32));
        kirjeldus2.setTextFill(Color.DARKTURQUOISE);

        vertikaal.getChildren().addAll(kirjeldus1, kirjeldus2);

        vertikaal.setBackground(Background.EMPTY);
        kirjeldus1.setText("Tegemist on täringumänguga.");
        kirjeldus2.setText("Kui soovid seda mängida, vajuta ENTERIT:");

        Scene stseen = new Scene(vertikaal, 600, 600, Color.LIGHTGOLDENRODYELLOW);

        lava.setScene(stseen);
        lava.setTitle("Sissejuhatus");
        vajutaEnteritSissejuhatus(stseen, lava);

        lava.showAndWait();

        kirjeldus1.setText("Võitmiseks pead veeretades saama kokku üle " + võiduSkoor + " punkti, ilma et veeretaksid vahepeal ühte.");
        kirjeldus2.setText("Kui said aru, vajuta ENTERIT:");

        lava.showAndWait();

        try (BufferedReader sisse = new BufferedReader(new InputStreamReader(new FileInputStream("võitja.txt"), "UTF-8"))) {
            kirjeldus1.setText("Eelmise mängu võitis: " + sisse.readLine());
            kirjeldus2.setText("");
        }

        lava.showAndWait();

        kirjeldus1.setText("Hüva alustame!");
        kirjeldus2.setText("");
        sulgeAken(lava);
    }
}
