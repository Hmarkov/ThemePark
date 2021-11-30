package com.company;

/**
 * SubClass for RollerCoaster which extends Attraction Class .
 */

class RollerCoaster extends  Attraction{
    public int getMinimum_Age() {
        return Minimum_Age;
    }

    public void setMinimum_Age(int minimum_Age) {
        Minimum_Age = minimum_Age;
    }

    public Double getSpeed() {
        return Speed;
    }

    public void setSpeed(Double speed) {
        Speed = speed;
    }

    int Minimum_Age;
    Double Speed;
    @Override
    public String toString() {
        StringBuilder str=new StringBuilder("\n\t Attraction Name:");
        str.append(getAtt_Name()).append("\n\t Base Price:");
        str.append(getBase_Price()).append("\n\t Minimum Age:");
        str.append(Minimum_Age).append("\n\t Speed:");
        str.append(Speed).append("\n");
        return str.toString();
    }

    @Override
    public int getOffPeakPrice() {

        return super.getBase_Price();
    }

    /**
     * Creates a new instance of Attraction.
     *
     * @param Att_Name   Attraction's name.
     * @param Base_Price Attraction's base price.
     * @param Minimum_Age Attraction's Distance.
     * @param Speed Attraction's Distance.
     */
    public RollerCoaster(String Att_Name, int Base_Price,int Minimum_Age,Double Speed) {
        super(Att_Name, Base_Price);
        this.Minimum_Age=Minimum_Age;
        this.Speed=Speed;

    }
}