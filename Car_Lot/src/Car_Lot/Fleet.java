/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Car_Lot;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Abdul
 */
class Fleet {

    private String fleetName;
    private ArrayList<Vehicle> fleetList;

    Fleet() {
        fleetName = "";
        fleetList = new ArrayList<>();
    }

    Fleet(String name) {
        fleetName = name;
    }

    /**
     * @return the fleetName
     */
    public String getFleetName() {
        return fleetName;
    }

    /**
     * @param fleetName the fleetName to set
     */
    public void setFleetName(String fleetName) {
        this.fleetName = fleetName;
    }

    public Vehicle getFleetList(int index) {
        return fleetList.get(index);
    }

    /**
     * @param fleetList the fleetList to set
     */
    public void setVehicle(int index, Vehicle item) {
        fleetList.set(index, item);
    }

    public int getNumVehicles() {
        return fleetList.size();
    }

    public void addVehicle(Vehicle item) {
        fleetList.add(item);
    }

    public Vehicle deleteVehicle(int index) {
        Vehicle k = fleetList.get(index);
        fleetList.remove(index);
        return k;
    }

    public void LoadFleet(String input) {
        try {

            Scanner inFile = new Scanner(new FileReader(input));

            fleetName = inFile.nextLine();

            while (inFile.hasNext()) {
                String letter = inFile.nextLine();

                if (letter.equals("P")) {
                    PassengerVan temp = new PassengerVan();
                    temp.setMake(inFile.nextLine());
                    temp.setModel(inFile.nextLine());
                    temp.setVin(inFile.nextLine());
                    temp.setYear(inFile.nextInt());
                    inFile.nextLine();
                    temp.setClearanceHeight(inFile.nextFloat());
                    inFile.nextLine();
                    temp.setNumWindows(inFile.nextInt());
                    inFile.nextLine();
                    temp.setNumSeatRows(inFile.nextInt());
                    inFile.nextLine();
                    temp.setMaxPassengers(inFile.nextInt());
                    inFile.nextLine();
                    temp.setDvdPlayer(false);
                    if (inFile.nextInt() == 1) {
                        temp.setDvdPlayer(true);
                        inFile.nextLine();

                    }
                    fleetList.add(temp);

                } else if (letter.equals("C")) {
                    CargoVan temp = new CargoVan();
                    temp.setMake(inFile.nextLine());
                    temp.setModel(inFile.nextLine());
                    temp.setVin(inFile.nextLine());
                    temp.setYear(inFile.nextInt());
                    inFile.nextLine();
                    temp.setClearanceHeight(inFile.nextFloat());
                    inFile.nextLine();
                    temp.setNumWindows(inFile.nextInt());
                    inFile.nextLine();
                    temp.setMaxLoad(inFile.nextFloat());
                    inFile.nextLine();
                    temp.setCargoArea(inFile.nextFloat());
                    if (inFile.hasNext()) {
                        inFile.nextLine();
                    }
                    fleetList.add(temp);

                } else if (letter.equals("A")) {
                    Automobile temp = new Automobile();
                    temp.setMake(inFile.nextLine());
                    temp.setModel(inFile.nextLine());
                    temp.setVin(inFile.nextLine());
                    temp.setYear(inFile.nextInt());
                    inFile.nextLine();
                    if (inFile.nextInt() == 1) {
                        temp.setHybrid(true);
                        inFile.nextLine();
                    }
                    temp.setMaxPassengers(inFile.nextInt());
                    inFile.nextLine();
                    temp.setTrunkSpace(inFile.nextFloat());
                    inFile.nextLine();

                    fleetList.add(temp);

                }
            }

        } catch (IOException e) {
            System.err.println("File Not Found ");
            System.exit(-1);
        }
    }

    public void SaveFleet(String output) {
        try {

            PrintWriter ret = new PrintWriter(output, "UTF-8");
            ret.print(this.toString());
            ret.close();

        } catch (IOException e) {
            System.err.println("File Not Found Exception: " + e.getMessage());
            System.exit(-1);
        }
    }

    @Override
    public String toString() {

        String k = System.getProperty("line.separator");

        String hit = "";
        for (int i = 0; i < fleetList.size(); i++) {
            hit += fleetList.get(i).toString() + k;

        }
        return fleetName + k + hit;
    }

    public ArrayList<Vehicle> getVehicleList(Class vehicleClass) {
        ArrayList<Vehicle> autos = new ArrayList();
        for (int i = 0; i < fleetList.size(); i++) {
            if (fleetList.get(i).getClass() == vehicleClass) {
                autos.add(fleetList.get(i));
            }
        }
        
        
        return autos;

    }
    
    public String getStringVehicle(ArrayList<Vehicle> k){
    String hit = "";
        for (int i = 0; i < fleetList.size(); i++) {
            hit += k.get(i).toString();

        }
        return hit;
    }

}
