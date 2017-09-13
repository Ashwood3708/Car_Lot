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
class Automobile extends Vehicle {

    private boolean hybrid;
    private int maxPassengers;
    private float trunkSpace;

    Automobile() {
        super();
        hybrid = false;
        maxPassengers = 0;
        trunkSpace = 0;
    }

    Automobile(boolean h, int max, float trunk) {
        hybrid = h;
        maxPassengers = max;
        trunkSpace = trunk;
    }

    /**
     * @return the hybrid
     */
    public boolean isHybrid() {
        return hybrid;
    }

    /**
     * @param hybrid the hybrid to set
     */
    public void setHybrid(boolean hybrid) {
        this.hybrid = hybrid;
    }

    /**
     * @return the maxPassengers
     */
    public int getMaxPassengers() {
        return maxPassengers;
    }

    /**
     * @param maxPassengers the maxPassengers to set
     */
    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    /**
     * @return the trunkSpace
     */
    public float getTrunkSpace() {
        return trunkSpace;
    }

    /**
     * @param trunkSpace the trunkSpace to set
     */
    public void setTrunkSpace(float trunkSpace) {
        this.trunkSpace = trunkSpace;
    }

    @Override

    public String toString(){
    String h = "";
    int num = 0;
    if(hybrid == true){
    num = 1;
    }
        String k = System.getProperty("line.separator");
        h = num + k + maxPassengers + k + trunkSpace;
    return "A"+ k+ super.toString()+ h;

    }

}
