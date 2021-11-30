package com.company;
/**
 *A class to model a client of Theme Park.
 *
 * @author 100230307
 * @version 2020
 */
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Customer implements Comparable<Customer> {




    private String  Acc_Number;
    private int Acc_Balance;
    private String Discount;
    private int Age;
    private String Customer_Name;



    /**
     * Creates a new instance of Customer.
     *
     * @param Acc_Number    Client's Account number.
     * @param Customer_Name Client's name.
     * @param Age   Client's age.
     * @param Acc_Balance   Client's Account balance.
     * @param Discount  Client's Discount.
     *
     */
    public Customer ( String Acc_Number , String Customer_Name , int Age , int Acc_Balance , String Discount )
    {
        this.Acc_Number = Acc_Number ;
        this.Customer_Name=Customer_Name;
        this.Age=Age;
        this.Acc_Balance=Acc_Balance;
        this.Discount=Discount;

    }
    public Customer(){
        this.Acc_Number=null;
        this.Customer_Name=null;
        this.Age=0;
        this.Acc_Balance=0;
        this.Discount=null;
    }
    /**
     * @return The client Account number of this client.
     */
    public String getAcc_Number() {
        return Acc_Number;
    }

    public void setAcc_Number(String acc_Number) {
        Acc_Number = acc_Number;
    }

    /**
     * @return The client Discount.
     */
    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }

    /**
     * @return The client's Age.
     */
    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    /**
     * @return The client's Name.
     */
    public String getCustomer_Name() {
        return Customer_Name;
    }

    public void setCustomer_Name(String customer_Name) {
        Customer_Name = customer_Name;
    }

    /**
     * @return The client's Account Balance.
     */
    public int getAcc_Balance() {
        return Acc_Balance;
    }

    /**
     * Add funds to the clients Account Balance.
     */
    public void addFunds(int amount){
        Acc_Balance=Acc_Balance+amount;
    }


    /**
     * Attraction simulation method with Discount verification
     */
    public Double useAttraction(int attractionPrice) throws InsufficientBalanceException {
        Double pricepaid = Double.parseDouble(String.valueOf(Acc_Balance));
                int attprice=attractionPrice;
                int percentoff;
                if (Acc_Balance >= attractionPrice) {
                    if (Discount.contains("FAMILY")) {
                        percentoff=attprice-(attractionPrice/100)*15;
                        Acc_Balance = Acc_Balance -percentoff ;
                    } else if (Discount.contains("STUDENT")) {
                        percentoff=attprice-(attractionPrice/100)*10;
                        Acc_Balance = Acc_Balance - percentoff;
                    } else {
                        Acc_Balance = Acc_Balance - attractionPrice;
                    }

                } else {
                throw new InsufficientBalanceException("insufficient balance");
                }
                pricepaid=pricepaid-Acc_Balance;

            return pricepaid;
    }

    /**
     * Attraction simulation method with Age and Discount verification
     */
    public Double useAttraction(int attractionPrice,int ageLimit) throws InsufficientBalanceException, AgeRestrictionException {

        Double Balance=Double.parseDouble(String.valueOf(Acc_Balance));
        Double pricepaid;
        int agelimit=ageLimit;
        int attprice=attractionPrice;
        int percentoff;
        if(Age>=agelimit){
            if (Acc_Balance >= attprice){
                if (Discount.contains("FAMILY")) {
                    percentoff=attprice-(attractionPrice/100)*15;
                    Acc_Balance = Acc_Balance -percentoff ;
                } else if (Discount.contains("STUDENT")) {
                    percentoff=attprice-(attractionPrice/100)*10;
                    Acc_Balance = Acc_Balance - percentoff;
                } else {
                    Acc_Balance = Acc_Balance - attractionPrice;
                }

            } else {
                throw new InsufficientBalanceException(" Insufficient balance");
            }
        }else{

            throw new AgeRestrictionException(" Age limit reached");
        }

        pricepaid=Balance-Double.parseDouble(String.valueOf(Acc_Balance));

        return pricepaid;
    }

    /**
     * Customer toString method
     */
    public String toString() {
        StringBuilder str=new StringBuilder("\n\t Account Number:");
        str.append(Acc_Number).append("\n\t Customer Name:");
        str.append(Customer_Name).append("\n\t Age:");
        str.append(Age).append("\n\t Account Balance:");
        str.append(Acc_Balance).append("\n\t Discount:");
        str.append(Discount).append("\n");
        return str.toString();
    }
    /**
     *  Discount Information for all Attractions and off-peak
     */
    public static String getAvailableDiscountInfo()
    {
        return "TYPES OF DISCOUNT:\n " +
                "FAMILY:15% \n " +
                "STUDENT:10% \n " +
                "Off-peak:\n " +
                "Transport:50% \n" +
                "Gentle:80% \n" +
                "Roller Coaster: No discount";
    }
    @Override
    public int compareTo(Customer customer) {
        int balancecomp= customer.getAcc_Balance();
        return this.getAcc_Balance()-balancecomp;
    }

}
