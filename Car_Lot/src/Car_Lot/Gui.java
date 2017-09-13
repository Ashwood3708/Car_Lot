/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Car_Lot;

import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Abdul
 */
public class Gui extends Application implements EventHandler {

    private Button save;
    private Button exit;
    private Button load;
    private Button add;
    private Button view;
    private BorderPane pane;
    private Scene scene;
    private Fleet fleet;
    private Label label;
    Stage stage1;

    //For the add btn
    private String letter;
    private TextField inmake;
    private TextField inmodel;
    private TextField invin;
    private TextField inyear;
    private TextField inheight;
    private TextField inNumWindows;
    private TextField inNumSeatRows;
    private TextField inMaxPassengers;
    private TextField inDvdPlayer;
    private TextField inMaxLoad;
    private TextField inCargoArea;
    private TextField inHybrid;
    private TextField inTrunkSpace;
    PassengerVan pVan;
    CargoVan cVan;
    Automobile auto;
    //

    //for save
    Boolean previousSave = false;
    //

    @Override
    public void start(Stage stage) {
        stage1 = stage;
        fleet = new Fleet();
        pane = new BorderPane();
        save = new Button("Save");
        exit = new Button("Exit");
        load = new Button("load");
        add = new Button("Add");
        view = new Button("View");

        HBox HBox = new HBox(load, add, view, save, exit);
        HBox.setAlignment(Pos.CENTER);
        //pane.setBottom(label);
        pane.setCenter(HBox);
        
        pane.setMinSize(300, 0);

        scene = new Scene(pane);
        stage1.setScene(scene);
        stage1.setTitle("Aggie Vehicle Pool");
        stage1.show();

        save.setOnAction(this);
        exit.setOnAction(this);
        load.setOnAction(this);
        add.setOnAction(this);
        view.setOnAction(this);

    }

    void start() {

        launch();
    }

    @Override
    public void handle(Event e) {
        Button b = (Button) e.getSource();

        if (b.getText().equals("Save")) {
            //create output file
            previousSave = true;
            doSave();

        } else if (b.getText().equals("View")) {
            viewThis();

        } else if (b.getText().equals("Go Back")) {
            stage1.setScene(scene);
            stage1.setTitle("Aggie Vehicle Pool");

        } else if (b.getText().equals("Add to file")) {

            addToList();
            stage1.setScene(scene);
            stage1.setTitle("Aggie Vehicle Pool");

        } else if (b.getText().equals("Exit")) {
            //exit the applicationJob
            if (previousSave) {
                System.exit(-1);

            } else {
                int hut = JOptionPane.showConfirmDialog(null, "Do you want to save?");
                if (hut == 0) {
                    doSave();
                    System.exit(-1);
                }
                if (hut == 1) {
                    System.exit(-1);
                }
            }

        } else if (b.getText().equals("load")) {
            String word = "MP2.txt";     //simply put in exact file
//            JFileChooser chooser = new JFileChooser();     // allows user to find file to load from
//            int val = chooser.showOpenDialog(null);
//            if (val == JFileChooser.APPROVE_OPTION) {
//                word = chooser.getSelectedFile().getName();    //turns filename into string then sends to loadBankData parameter
                fleet.LoadFleet(word);

            //}

        } else if (b.getText().equals("Add")) {

            letter = JOptionPane.showInputDialog("What type of vehicle? Type A, C, or P");
            if (letter.equals("P") || letter.equals("p")) {
                GuiNewVehicle();

            } else if (letter.equals("C") || letter.equals("c")) {
                GuiNewVehicle();

            } else if (letter.equals("A") || letter.equals("a")) {
                GuiNewVehicle();
            }else{
            JOptionPane.showMessageDialog(null, "Inncorrect input. Type A, P, or C");
            }
        }

    }

    public void doSave() {
        fleet.SaveFleet(JOptionPane.showInputDialog("Enter a file to save to") + ".txt");
    }

    void GuiNewVehicle() {

        Label make = new Label("make ");
        Label model = new Label("model ");
        Label vin = new Label("vin ");
        Label year = new Label("year ");
        Label height = new Label("Clearance Height ");
        Label numWindows = new Label("number of windows ");
        Label numSeatRows = new Label("number of seat rows ");
        Label MaxPassengers = new Label("max passengers ");
        Label DvdPlayer = new Label("dvd player ");
        Label maxLoad = new Label("max load");
        Label cargoArea = new Label("cargo area");
        Label Hybrid = new Label("Hybrid");
        Label TrunkSpace = new Label("Trunk space");

        inmake = new TextField();
        inmodel = new TextField();
        invin = new TextField();
        inyear = new TextField();
        inheight = new TextField();
        inNumWindows = new TextField();
        inNumSeatRows = new TextField();
        inMaxPassengers = new TextField();
        inDvdPlayer = new TextField();
        inMaxLoad = new TextField();
        inCargoArea = new TextField();
        inHybrid = new TextField();
        inMaxPassengers = new TextField();
        inTrunkSpace = new TextField();

        Button btn = new Button("Add to file");
        Button btn2 = new Button("Go Back");
        GridPane gridPane = new GridPane();

        Insets inset = new Insets(12, 12, 12, 12);
        gridPane.setPadding(inset);

        gridPane.add(make, 0, 0);
        gridPane.add(inmake, 1, 0);
        gridPane.add(model, 0, 1);
        gridPane.add(inmodel, 1, 1);
        gridPane.add(vin, 0, 2);
        gridPane.add(invin, 1, 2);
        gridPane.add(year, 0, 3);
        gridPane.add(inyear, 1, 3);
        gridPane.add(height, 0, 4);
        gridPane.add(inheight, 1, 4);
        gridPane.add(numWindows, 0, 5);
        gridPane.add(inNumWindows, 1, 5);
        gridPane.add(numSeatRows, 0, 6);
        gridPane.add(inNumSeatRows, 1, 6);
        gridPane.add(MaxPassengers, 0, 7);
        gridPane.add(inMaxPassengers, 1, 7);
        gridPane.add(DvdPlayer, 0, 8);
        gridPane.add(inDvdPlayer, 1, 8);
        gridPane.add(maxLoad, 0, 9);
        gridPane.add(inMaxLoad, 1, 9);
        gridPane.add(cargoArea, 0, 10);
        gridPane.add(inCargoArea, 1, 10);
        gridPane.add(Hybrid, 0, 11);
        gridPane.add(inHybrid, 1, 11);
        gridPane.add(TrunkSpace, 0, 12);
        gridPane.add(inTrunkSpace, 1, 12);
        HBox hBox = new HBox(btn,btn2);
        hBox.setSpacing(15);
        gridPane.add(hBox, 1, 13);
        
        btn.setOnAction(this);
        btn2.setOnAction(this);
        gridPane.setMinSize(230, 200);

        Scene scene2 = new Scene(gridPane);
        stage1.setScene(scene2);
        stage1.setTitle("New Vehicle");
        stage1.show();

        if (letter.equals("P") || letter.equals("p")) {
            stage1.setTitle("New Passenger Van");
            inMaxLoad.setDisable(true);
            inCargoArea.setDisable(true);
            inHybrid.setDisable(true);
            inTrunkSpace.setDisable(true);

        } else if (letter.equals("C") || letter.equals("c")) {
            stage1.setTitle("New Cargo Van");
            inNumSeatRows.setDisable(true);
            inMaxPassengers.setDisable(true);
            inDvdPlayer.setDisable(true);
            inHybrid.setDisable(true);
            inTrunkSpace.setDisable(true);

        } else if (letter.equals("A") || letter.equals("a")) {
            stage1.setTitle("New Automobile");
            inNumWindows.setDisable(true);
            inNumSeatRows.setDisable(true);
            inDvdPlayer.setDisable(true);
            inheight.setDisable(true);
            inMaxLoad.setDisable(true);
            inCargoArea.setDisable(true);
        }

    }

    void addToList() {
        if (letter.equals("P") || letter.equals("p")) {
            pVan = new PassengerVan();
            pVan.setMake(inmake.getText());
            pVan.setModel(inmodel.getText());
            pVan.setVin(invin.getText());
            pVan.setYear(Integer.parseInt(inyear.getText()));
            pVan.setClearanceHeight(Float.parseFloat(inheight.getText()));
            pVan.setNumWindows(Integer.parseInt(inNumWindows.getText()));
            pVan.setNumSeatRows(Integer.parseInt(inNumSeatRows.getText()));
            pVan.setMaxPassengers(Integer.parseInt(inMaxPassengers.getText()));
            pVan.setDvdPlayer(Boolean.parseBoolean(inDvdPlayer.getText()));
            fleet.addVehicle(pVan);

        } else if (letter.equals("C") || letter.equals("c")) {
            cVan = new CargoVan();
            cVan.setMake(inmake.getText());
            cVan.setModel(inmodel.getText());
            cVan.setVin(invin.getText());
            cVan.setYear(Integer.parseInt(inyear.getText()));
            cVan.setClearanceHeight(Float.parseFloat(inheight.getText()));
            cVan.setNumWindows(Integer.parseInt(inNumWindows.getText()));
            cVan.setMaxLoad(Float.parseFloat(inMaxLoad.getText()));
            cVan.setCargoArea(Float.parseFloat(inCargoArea.getText()));
            fleet.addVehicle(cVan);

        } else if (letter.equals("A") || letter.equals("a")) {
            auto = new Automobile();
            auto.setMake(inmake.getText());
            auto.setModel(inmodel.getText());
            auto.setVin(invin.getText());
            auto.setYear(Integer.parseInt(inyear.getText()));
            auto.setHybrid(Boolean.parseBoolean(inHybrid.getText()));
            auto.setMaxPassengers(Integer.parseInt(inMaxPassengers.getText()));
            auto.setTrunkSpace(Float.parseFloat(inTrunkSpace.getText()));
            fleet.addVehicle(auto);

        }

    }

    void viewThis() {
        BorderPane pane3 = new BorderPane();

        // label = new Label("You Did it!!");
        //label = new Label(g);
        String k = System.getProperty("line.separator");

        ArrayList<Vehicle> g = fleet.getVehicleList(Automobile.class);
        String hit = "";
        for (int i = 0; i < g.size(); i++) {
            hit += g.get(i).toString() + k;
        }

        ArrayList<Vehicle> j = fleet.getVehicleList(CargoVan.class);
        String hit2 = "";
        for (int i = 0; i < j.size(); i++) {
            hit2 += j.get(i).toString() + k;
        }

        ArrayList<Vehicle> h = fleet.getVehicleList(PassengerVan.class);
        String hit3 = "";
        for (int i = 0; i < h.size(); i++) {
            hit3 += h.get(i).toString() + k;
        }

        ListView<String> list = new ListView<>();
        ObservableList<String> items = FXCollections.observableArrayList(hit);
        list.setItems(items);

        ListView<String> list2 = new ListView<>();
        ObservableList<String> items2 = FXCollections.observableArrayList(hit2);
        list2.setItems(items2);

        ListView<String> list3 = new ListView<>();
        ObservableList<String> items3 = FXCollections.observableArrayList(hit3);
        list3.setItems(items3);

        pane3.setCenter(list);
        pane3.setLeft(list2);
        pane3.setRight(list3);

        int counter1, counter2, counter3;
        counter1 = j.size();
        counter2 = g.size();
        counter3 = h.size();

        Label auto = new Label("Automobiles: " + counter2);
        Label cVan = new Label("Cargo Vans: " + counter1);
        Label pVan = new Label("Passenger Vans: " + counter3);

        HBox hBox = new HBox(cVan, auto, pVan);
        hBox.setSpacing(225);
        hBox.setAlignment(Pos.CENTER);
        
        Button b = new Button("Go Back");
        b.setMinSize(100, 3);
        HBox pBox = new HBox(b);
        pBox.setAlignment(Pos.CENTER);

        pane3.setBottom(pBox);
        pane3.setTop(hBox);

        Scene scene3 = new Scene(pane3);
        stage1.setScene(scene3);
        stage1.setTitle("The View Tab");
        stage1.show();
        b.setOnAction(this);
    }

}
