package M01.Programing_Assignments;

/*
 *Nathan Able
 *SDEV200 Module 01 Assignment
 *Assignment 6.9
 *Write a class that contains the following two methods
 *public static double footToMeter(double foot)
 *public static double meterToFoot(double meter)
 *Write a test program that invokes these methods to display the following tables:
 *Feet to meeters 1 foot - 10 feet
 *Meters to feet 20 meters - 65 meters
 */

public class Conversion {
    public static void main(String[] args){
        System.out.println("Feet to Meters  |  Meters to Feet");
        System.out.println("----------------|----------------");
        //Itterater for for loop and use itterater as foot mesurment
        double i;
        //Meter mesurement
        double x = 20.0;
        for (i = 1; i < 11; i++){
            System.out.printf("%.1f     %.3f   |  %.1f     %.3f%n",i,footToMeter(i),x,meterToFoot(x));
            //itterate meter
            x +=5;
            /*
             * Meters returned did not match book. However I validated my results matched formula
             */
        }


    }//End of MAIN

    /** Convert from feet to meters */
    public static double footToMeter(double foot){
        double converted;
        converted = 0.305 * foot;
        return converted;
    }

    /** Convert from meters to feet */
    public static double meterToFoot(double meter){
        double converted;
        converted = 3.279 * meter;
        return converted;
    }
}
