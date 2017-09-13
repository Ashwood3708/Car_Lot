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
class Van extends Vehicle{
  private float clearanceHeight;
  private int numWindows;
  
  Van(){
      super();
  clearanceHeight = 0;
  numWindows = 0;
  }
  
  Van(float o, int r){
  clearanceHeight = o;
  numWindows = r;
  }

    /**
     * @return the clearanceHeight
     */
    public float getClearanceHeight() {
        return clearanceHeight;
    }

    /**
     * @param clearanceHeight the clearanceHeight to set
     */
    public void setClearanceHeight(float clearanceHeight) {
        this.clearanceHeight = clearanceHeight;
    }

    /**
     * @return the numWindows
     */
    public int getNumWindows() {
        return numWindows;
    }

    /**
     * @param numWindows the numWindows to set
     */
    public void setNumWindows(int numWindows) {
        this.numWindows = numWindows;
    }
  
  @Override
  public String toString(){
    String h = "";
        String k = System.getProperty("line.separator");
    
        h = clearanceHeight + k + numWindows ;
    return super.toString() + h + k;

    }
  
}
