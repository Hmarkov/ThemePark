package com.company;

/**
 * SubClass for Gentle Attractions which extends Attraction Class .
 */
class GentleAttraction extends  Attraction{
    int Capacity;
    @Override
    public String toString() {
        StringBuilder str=new StringBuilder("\n\t Attraction Name:");
        str.append(getAtt_Name()).append("\n\t Base Price:");
        str.append(getBase_Price()).append("\n\t Capacity:");
        str.append(Capacity).append("\n");
        return str.toString();
    }
    @Override
    public int getOffPeakPrice() {

        return (super.getBase_Price()/100)*80;
    }

    /**
     * Creates a new instance of Attraction.
     *
     * @param Att_Name   Attraction's name.
     * @param Base_Price Attraction's base price.
     *  @param Capacity Attraction's Capacity.
     */
    public GentleAttraction(String Att_Name, int Base_Price,int Capacity) {
        super(Att_Name, Base_Price);
        this.Capacity = Capacity;

    }
}