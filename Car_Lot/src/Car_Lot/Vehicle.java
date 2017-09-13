/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Car_Lot;

/**
 *
 * @author Abdul
 */
class Vehicle {
    
    private String make;
    private String model;
    private String vin;
    private int year;
    
    Vehicle(){
    make ="";
    model = "";
    vin = "";
    year = 0;
    }
    Vehicle(String ma, String mo, String v, int y){
    make = ma;
    model = mo;
    vin = v;
    year = y;
    }

    /**
     * @return the make
     */
    public String getMake() {
        return make;
    }

    /**
     * @param make the make to set
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @return the vin
     */
    public String getVin() {
        return vin;
    }

    /**
     * @param vin the vin to set
     */
    public void setVin(String vin) {
        this.vin = vin;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }
    @Override
    public String toString(){
        String h = "";
        String k = System.getProperty("line.separator");
        h = make + k + model + k + vin + k + year ;
    return h + k;
    }
    
    
    
}
