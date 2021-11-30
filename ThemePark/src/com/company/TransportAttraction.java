package com.company;
/**
 *  * SubClass for Transport Attractions which extends Attraction Class .
 */

class TransportAttraction extends  Attraction{
    int Distance;
    @Override
    public String toString() {
        StringBuilder str=new StringBuilder("\n\t Attraction Name:");
        str.append(getAtt_Name()).append("\n\t Base Price:");
        str.append(getBase_Price()).append("\n\t Distance:");
        str.append(Distance).append("\n");
        return str.toString();
    }
    @Override
    public int getOffPeakPrice() {

        return (super.getBase_Price()/100)*50;
    }

    /**
     * Creates a new instance of Attraction.
     *
     * @param Att_Name   Attraction's name.
     * @param Base_Price Attraction's base price.
     * @param Distance Attraction's Distance.
     */
    public TransportAttraction(String Att_Name, int Base_Price,int Distance) {
        super(Att_Name, Base_Price);
        this.Distance=Distance;
    }
}