package M01.Programing_Assignments;
/*
 *Nathan Able
 *SDEV200
 *Assignment 6.31
 *Write a method that returns true if m1 and m2 are identical, using the following header:
 *public static boolean equals(int[][] m1, int[][] m2)
 *Write a test program that prompts the user to enter two 3x3
 *arrays of integers and displays whether the two are identical.
 *
 */
import java.lang.Math;
public class RegularPolygon {
    //Initialize data fields
    private int n = 3;
    private double side = 1;
    private double x = 0;
    private double y = 0;

    //Default constructor without args
    public RegularPolygon(){
    }

    //Constructor only length and sides
    public RegularPolygon(int numSides, double sideLength){
        this.n = numSides;
        this.side = sideLength;
    }

    //Constructor declare all values
    public RegularPolygon(int numSides, double sideLength, double cordx, double cordy){
        this.n = numSides;
        this.side = sideLength;
        this.x = cordx;
        this.y = cordy;
    }
    //Getters
    public int getn(){
        return n;
    }

    public double getSide(){
        return side;
    }

    public double getx(){
        return x;
    }

    public double gety(){
        return y;
    }
    //Setters
    public void setn(int numSides){
        this.n = numSides;
    }

    public void setSide(double sideLength){
        this.side = sideLength;
    }

    public void setx(double cordx){
        this.x = cordx;
    }

    public void sety(double cordy){
        this.y = cordy;
    }

    public double getPerimiter(){
        return this.n * this.side;
    }

    public double getArea(){
        //Using Area = (n * s^2) / (4 * tan(π / n)) create the Numerator and denominator independently
        double numerator = this.n * Math.pow(this.side, 2);
        double denominator = 4 * Math.tan(Math.PI/this.n);

        return numerator/denominator;
    }

    public static void main(String[] args){
        RegularPolygon rp1 = new RegularPolygon();
        RegularPolygon rp2 = new RegularPolygon(6,4);
        RegularPolygon rp3 = new RegularPolygon(10, 4, 5.6, 7.8);

        System.out.printf("The perimiter if rp1 is %f and the area is %f%n", rp1.getPerimiter(), rp1.getArea());
        System.out.printf("The perimiter if rp2 is %f and the area is %f%n", rp2.getPerimiter(), rp2.getArea());
        System.out.printf("The perimiter if rp3 is %f and the area is %f%n", rp3.getPerimiter(), rp3.getArea());
    }
}
