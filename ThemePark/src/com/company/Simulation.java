package com.company;

/**
 *A class to model a Simulation of Theme Park.
 *
 * @author 100230307
 * @version 2020
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.stream.Stream;

public class Simulation {
    public static ThemePark park = new ThemePark();


    public static void main(String[] args) throws CustomerNotFoundException, RideNotFoundException {
        Simulation sim=new Simulation();
      sim.simulate();

    }

    /**
     * create Theme Park method calling Read File methods from ThemePark class
     */
    public  void createThemePark() throws CustomerNotFoundException, RideNotFoundException {
        park.ReadCustomerFile("U:\\ThemeParkCW-20200313T100635Z-001\\ThemeParkCW\\src\\com\\company\\customers.txt");
        park.ReadAttractionFile("U:\\ThemeParkCW-20200313T100635Z-001\\ThemeParkCW\\src\\com\\company\\attractions.txt");

        System.out.println("\nAvarage Gentle Attractions Capacity: " + park.calcAverageGentleCapacity());
        System.out.println("\nMedian RollerCoaster Speed: " + park.calcMedianCoasterSpeed());
        System.out.println("\nTotal Transport Distance: " + park.calcTotalTransportDistance());
        System.out.println("____________________");
//         park.getCustomer("117304");
//         park.removeCustomer("555765");
//         park.getRide("Hoverboat");
//         park.removeRide("Monorail");


    }
    /**
     * Simulate Theme Park using transactions.txt file
     * Collect information from file with already populated arraylists
     * Get each type of transaction and use it to simulate the methodology required
     * Possible method of transactions:
     * USE_ATTRACTION,ADD_FUNDS,NEW_CUSTOMER
     */
    public void simulate() {
        try {
            Scanner sc = new Scanner(new FileReader("U:\\ThemeParkCW-20200313T100635Z-001\\ThemeParkCW\\src\\com\\company\\transactions.txt"));
            String line;
            createThemePark();
            Customer customer;
            TransportAttraction t_att = null;
            GentleAttraction g_att = null;
            RollerCoaster roll = null;
            Attraction tra= t_att;
            Attraction gen= g_att;
            Attraction rol= roll;
            Double total = 0.0;
            while (sc.hasNextLine()) {
                line = sc.nextLine().trim();
                String[] result = line.split(",");
                customer= park.getCustomer(result[2]);

                //result[3] contains Attraction Name
             
                if (result[0].trim().contains("USE_ATTRACTION")) {
                    if (result[1].trim().contains("STANDARD_PRICE")) {
                        try {

                            if (park.TRA.contains(result[3].trim()) == park.TRA.contains(result[3].trim())) {

                                tra=park.getRide(result[3]);
                                System.out.println("\n__________\n"+
                                        "\nCustomer:" + customer.toString() +
                                        "\nUsed attraction:" + tra.toString()
                                        +"Paid:" + customer.useAttraction(tra.getBase_Price()));
                                        total=total+customer.useAttraction(tra.getBase_Price());

                            } else if (park.GEN.contains(result[3].trim()) == park.GEN.contains(result[3].trim())) {
                                gen =park.getRide(result[3]);
                                System.out.println("\n__________\n"+
                                        "\nCustomer:" + customer.toString() +
                                        "\nUsed attraction:" + gen.toString() +
                                        "Paid:" + customer.useAttraction(gen.getBase_Price()));
                                total=total+customer.useAttraction(tra.getBase_Price());

                            } else if (park.ROL.contains(result[3].trim()) == park.ROL.contains(result[3].trim())) {
                                rol=park.getRide(result[3]);


                                System.out.println("\n__________\n"+
                                        "\nCustomer:" + customer.toString() +
                                        "\nUsed attraction:" + rol.toString() +
                                        "Paid:" + customer.useAttraction(rol.getBase_Price(),getAgeOfROL(result[3])));
                                total=total+customer.useAttraction(tra.getBase_Price());

                            } else {
                                throw new RideNotFoundException("Attraction Not Found");
                            }
                        }catch(Exception e){
                            System.out.println(e);
                        }
                    } else {
                        try{
                        if (park.TRA.contains(result[3].trim())==park.TRA.contains(result[3].trim())) {

                            tra=park.getRide(result[3]);
                            System.out.println("\n__________\n"+
                                    "\nCustomer:"+customer.toString()+
                                    "\nUsed attraction:"+tra.toString()+
                                    "Paid:"+customer.useAttraction(getOffpeakTRA(result[3])));


                        } else if (park.GEN.contains(result[3].trim())==park.GEN.contains(result[3].trim())) {

                            gen =park.getRide(result[3]);
                            System.out.println("\n__________\n"+
                                    "\nCustomer:"+customer.toString()+
                                    "\nUsed attraction:"+gen.toString()+
                                     "Paid:"+customer.useAttraction(getOffpeakGEN(result[3])));


                        } else if (park.ROL.contains(result[3].trim())==park.ROL.contains(result[3].trim())) {
                            rol=park.getRide(result[3]);
                            System.out.println("\n__________\n"+
                                    "\nCustomer:"+customer.toString()+
                                    "\nUsed attraction:"+rol.toString()+
                                    "Paid:"+customer.useAttraction(getOffpeakROL(result[3]),getAgeOfROL(result[3])));



                        } else {
                            throw new RideNotFoundException("Attraction not existing");
                        }

                        }catch (Exception e){
                            System.out.println(e);
                        }
                    }
                } else if (result[0].contains("ADD_FUNDS")) {
                        try {
                            if (park.getCustomer(result[1]) == park.getCustomer(result[1])) {
                                customer = park.getCustomer(result[1]);
                                customer.addFunds(Integer.parseInt(result[2]));
                                System.out.println("__________\n"+"Customer with Account number: " + result[1] +
                                        "\nReceived a top-up of:" + result[2]+
                                        "\n__________");

                            } else {
                                throw new CustomerNotFoundException("Customer not found");
                            }
                        }catch (Exception e){
                            System.out.println("Error" + e.getMessage());
                        }
                } else {
                    try {
                        if (park.getCustomer(result[1]) == park.getCustomer(result[1])) {
                            if (park.getCustomer(result[result.length - 1]) == park.getCustomer(result[4])) {

                                park.AddCustomer(result[1].concat("#"), result[2].concat("#"), Integer.parseInt(result[3]), Integer.parseInt(result[4]), "#");
                                System.out.println("\n__________\n"+"New customer has been added:" +
                                        "\n Account Number:" + result[1] +
                                        "\n Name:" + result[2] +
                                        "\n Age:" + result[3] +
                                        "\n Account Balance:" + result[4]+
                                        "\n__________\n");
                            } else {
                                park.AddCustomer(result[1].concat("#"), result[2].concat("#"), Integer.parseInt(result[3]), Integer.parseInt(result[4]), result[5]);
                                System.out.println("\n__________\n"+
                                        "New customer has been added:" +
                                        "\n Account Number:" + result[1] +
                                        "\n Name:" + result[2] +
                                        "\n Age:" + result[3] +
                                        "\n Account Balance:" + result[4] +
                                        "\n Discount:" + result[5]+
                                        "\n__________\n");
                            }
                        } else {
                            System.out.println("Customer already Exists");
                        }
                    }catch (Exception e){
                        System.out.println("Error" + e.getMessage());
                    }
                }

            }
            System.out.println("Total:"+total);
            sc.close();
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }

    }



    /**
    * Helper method to get Off-peak price for Transport Attractions
     */
    public int getOffpeakTRA(String rideName){

        for(TransportAttraction tra:park.TRA){
            if(tra.getAtt_Name().contains(rideName)==tra.getAtt_Name().contains(rideName)) {
                return tra.getOffPeakPrice();
            }
        }
        return park.t_att.getOffPeakPrice();
    }


    /**
     *  Helper method to get Off-peak price for Gentle Attractions
     */
    public int getOffpeakGEN(String rideName){

        for(GentleAttraction gen:park.GEN){
            if(gen.getAtt_Name().contains(rideName)) {
                return gen.getOffPeakPrice();
            }
        }
        return park.g_att.getOffPeakPrice();
    }


    /**
     *  Helper method to get Off-peak price for RollerCoaster
     */
    public int getOffpeakROL(String rideName){

        for(RollerCoaster rol:park.ROL){
            if(rol.getAtt_Name().contains(rideName)) {
                return rol.getOffPeakPrice();
            }
        }
        return park.roll.getOffPeakPrice();
    }


    /**
     * Helper method to get Age requirements for RollerCoaster
     */
    public int getAgeOfROL(String rideName){

        for(RollerCoaster rol:park.ROL){
            if(rol.getAtt_Name().contains(rideName)) {
                return rol.Minimum_Age;
            }
        }
        return park.roll.Minimum_Age;
    }




}
