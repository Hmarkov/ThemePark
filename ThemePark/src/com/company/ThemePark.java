package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileReader;

/**
 *A class to model a Theme park.
 *
 * @author 100230307
 * @version 2020
 */
public class ThemePark {

    public ArrayList<Customer> customers;

    public ArrayList<TransportAttraction>TRA;
    public ArrayList<GentleAttraction>GEN;
    public ArrayList<RollerCoaster>ROL;
    public ThemePark(){
        this.customer=new Customer();
        this.customers=new ArrayList<Customer>();

        this.TRA=new ArrayList<TransportAttraction>();
        this.GEN=new ArrayList<GentleAttraction>();
        this.ROL=new ArrayList<RollerCoaster>();

    }

    Attraction attraction;
    Customer customer;
    TransportAttraction t_att;
    GentleAttraction g_att;
    RollerCoaster roll;


    /**
     * getCustomer method which returns a record from Arraylist given the Account Number
     */
    public Customer getCustomer(String accountNumber) throws CustomerNotFoundException
        {
            Customer customer;

            for (Customer cr : customers) {
                if (cr.getAcc_Number().contains(accountNumber)) {
                    return cr;
                }
            }
        return null;
        }
    /**
     * removeCustomer method which removes a record from Arraylist given the Account Number
     */
    public void removeCustomer(String accountNumber) throws CustomerNotFoundException {
        Customer customer = null;

        for (Customer cr : customers) {
            if(cr.getAcc_Number().contains(accountNumber)) {
                customer = cr;

            }
        }
        customers.remove(customer);
        System.out.println("Account with number: "+accountNumber+" has been removed");
        System.out.println("____________________");
    }
    /**
     * getRide method which returns a record from Arraylist given the Attraction Name.
     */
    public Attraction getRide(String rideName) throws RideNotFoundException {
        TransportAttraction t_att = null;
        GentleAttraction g_att = null;
        RollerCoaster roll = null;

        for (TransportAttraction t : TRA) {
            if (t.getAtt_Name().contains(rideName)) {
                t_att = t;

                return t_att;
            }

        }
        for (GentleAttraction g : GEN) {
            if (g.getAtt_Name().contains(rideName)) {
                g_att = g;
                return g_att;

            }

        }
        for (RollerCoaster r : ROL) {
            if (r.getAtt_Name().contains(rideName)) {
                roll = r;
                return roll;

            }

        }
        return null;
    }

    /**
     * removeRide method which removes a record from Arraylist given the Attraction Name.
     */
    public void removeRide(String rideName) throws RideNotFoundException {
        TransportAttraction t_att=null;
        GentleAttraction g_att=null;
        RollerCoaster roll=null;
        for (TransportAttraction t:TRA){
                    if (t.getAtt_Name().contains(rideName))  {
                        t_att = t;
                        TRA.remove(t_att);
                        System.out.println("Attraction with name: " + rideName + " has been removed");
                        System.out.println("____________________");
                        break;
                    }
                }

        for(GentleAttraction g:GEN) {
            if (g.getAtt_Name().contains(rideName)) {
                g_att = g;
                GEN.remove(g_att);
                System.out.println("Attraction with name: " + rideName + " has been removed");
                System.out.println("____________________");
                break;
            }
        }

        for (RollerCoaster r : ROL){
            if(r.getAtt_Name().contains(rideName)){
                roll = r;
                ROL.remove(roll);
                System.out.println("Attraction with name: " + rideName + " has been removed");
                System.out.println("____________________");
                break;
            }

        }
    }
    /**
     * A method which adds a record to Arraylist given Account Number, Customer Name, Age, Account Balance, Discount.
     */
     public void AddCustomer(String Acc_Number,String Name,int Age,int Acc_balance,String Discount){


         for (Customer cr : customers) {
             for (int i = 0; i >= customers.size(); i++) {
                 if (cr.getAcc_Number().contains(Acc_Number)) {
                     System.out.println("Customer already exists");
                 } else if (i >= customers.size()) {
                    Customer customer=new Customer(Acc_Number,Name,Age,Acc_balance,Discount);
                     customers.add(customer);

                 }
             }
         }
     }
    /**
     * A method to calculate the total distance of all Transport Attractions.
     */
    public int calcTotalTransportDistance(){

        int total=0;
        for(TransportAttraction t_att:TRA){
            total=total+ t_att.Distance;
        }

        return total;
    }

    /**
     * A method to calculate the average Capacity of all Gentle Attractions.
     */
    public Double calcAverageGentleCapacity(){
        Double averageCapacity = 0.0;
        int total=0;
        for(GentleAttraction g_att:GEN){
            total=total+g_att.Capacity;
        }

        averageCapacity=(averageCapacity+total)/GEN.size();
        return averageCapacity;
    }

    /**
     * A method to calculate the median Speed of all Roller Coasters.
     */
    //algorithm partially used from "https://stackoverflow.com/questions/11955728/how-to-calculate-the-median-of-an-array"
    public Double calcMedianCoasterSpeed(){
        double median=0;
        int i=0;
        double[] speeds=new double[ROL.size()];
        for(RollerCoaster coaster:ROL)
        {
            speeds[i]=coaster.Speed;
            i++;
        }
        Arrays.sort(speeds);
        if(speeds.length%2==0){
            median=(speeds[speeds.length/2] + speeds[speeds.length/2-1])/2;
        }else{
            median= speeds[speeds.length/2];
        }
        return median;
    }


    /**
     * Read Customer File Method.
     */
    public void ReadCustomerFile(String filename){
        try {
            Scanner sc = new Scanner(new FileReader(filename));
            String line;
            Customer item;
            while (sc.hasNextLine()) {
                line = sc.nextLine();

                String[] result = line.split("#");
                String Acc_Number = (result[0]);
                String Customer_Name = (result[1]);
                int Age = Integer.parseInt(result[2]);
                int Acc_Balance = Integer.parseInt(result[3]);

                String Discount=(result[result.length-1]);
                if(Discount.contains("FAMILY")||Discount.contains("STUDENT")){

                    item = new Customer(Acc_Number,Customer_Name,Age,Acc_Balance,Discount);
                    customers.add(item);
                }else{
                    Discount=" ";
                    item = new Customer(Acc_Number,Customer_Name,Age,Acc_Balance,Discount);
                    customers.add(item);
                }
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    /**
     * Read Attraction File Method.
     */
    public void ReadAttractionFile(String filename){
        try {

            Scanner sc = new Scanner(new FileReader(filename));
            String line;
            TransportAttraction transportAttraction;//Arraylist for Transport Attracions
            GentleAttraction gentleAttraction;//Arraylist for Gentle Attracions
            RollerCoaster rollerCoaster;//Arraylist for Roller Coaster
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                String[] result = line.replaceAll("\\s+@", "@").split("@");

                String Att_Name = (result[0]);
                int Base_Price =Integer.parseInt(result[1]);
                String Type =(result[2]);

                //Divide into three arraylists
                if(Type.contains("TRA")){
                    int Distance = Integer.parseInt(result[3]);
                    transportAttraction=new TransportAttraction(Att_Name,Base_Price,Distance);
                    TRA.add(transportAttraction);
                }else if(Type.contains("GEN")){
                    int Capacity = Integer.parseInt(result[3]);
                    gentleAttraction=new GentleAttraction(Att_Name,Base_Price,Capacity);
                    GEN.add(gentleAttraction);
                }else{
                    int Minimum_Age = Integer.parseInt(result[3]);
                    Double Speed = Double.parseDouble(result[4]);
                    rollerCoaster=new RollerCoaster(Att_Name,Base_Price,Minimum_Age,Speed);
                    ROL.add(rollerCoaster);
                }

            }
            sc.close();
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    }


}
