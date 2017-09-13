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
class CargoVan extends Van{
    private float maxLoad;
    private float cargoArea;
    
    CargoVan(){
        super();
    maxLoad = 0;
    cargoArea = 0;
    }
    CargoVan(float h, float j){
    maxLoad = h;
    cargoArea = j;
    }

    /**
     * @return the maxLoad
     */
    public float getMaxLoad() {
        return maxLoad;
    }

    /**
     * @param maxLoad the maxLoad to set
     */
    public void setMaxLoad(float maxLoad) {
        this.maxLoad = maxLoad;
    }

    /**
     * @return the cargoArea
     */
    public float getCargoArea() {
        return cargoArea;
    }

    /**
     * @param cargoArea the cargoArea to set
     */
    public void setCargoArea(float cargoArea) {
        this.cargoArea = cargoArea;
    }
    
    @Override
    public String toString(){
    String h = "";
        String k = System.getProperty("line.separator");
        h = maxLoad + k + cargoArea;

    return "C"+ k+ super.toString()+ h;

    }

    
}
