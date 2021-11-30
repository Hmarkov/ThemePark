package com.company;
/**
 *A class to model a Attraction of Theme Park.
 *
 * @author 100230307
 * @version 2020
 */
public class Attraction implements  Comparable<Attraction>{

    private String Att_Name;
    private int Base_Price;



    /**
     * @return Attraction Name.
     */
    public String getAtt_Name() {
        return Att_Name;
    }

    public void setAtt_Name(String att_Name) {
        Att_Name = att_Name;
    }
    /**
     * @return Attraction Base Price.
     */
    public int getBase_Price() {
        return Base_Price;
    }

    public void setBase_Price(int base_Price) {
        Base_Price = base_Price;
    }

    /**
     * @return Attraction Off Peak price which requires Base Price .
     */
    public int getOffPeakPrice(){
        return getBase_Price();
    }

    /**
     * @return Attraction toString Method.
     */
    @Override
    public String toString() {
        StringBuilder str=new StringBuilder("\n\t Attraction Name:");
        str.append(Att_Name).append("\n\t Base Price:");
        str.append(Base_Price).append("\n");
        return str.toString();
    }


    /**
     * Creates a new instance of Attraction.
     *
     * @param Att_Name   Attraction's name.
     * @param Base_Price Attraction's base price.
     *
     */
    public Attraction ( String Att_Name ,  int Base_Price  )
    {
        this.Att_Name = Att_Name ;
        this.Base_Price=Base_Price;
    }

    public Attraction(){
        this.Att_Name=null;
        this.Base_Price=0;
    }


    @Override
    public int compareTo(Attraction attraction) {
        int pricecomp= attraction.getBase_Price();
        return this.getBase_Price()-pricecomp;
    }
}




