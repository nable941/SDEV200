package M02.Programing_Assignments;
/*
 *Nathan Able
 *SDEV 200
 *Assignment 11.1
 *Design a class named Triangle that extends ­GeometricObject. The class contains:
 *Three double data fields named side1, side2, and side3 with default values 1.0 to denote three sides of a triangle.
 *A no-arg constructor that creates a default triangle.
 *A constructor that creates a triangle with the specified side1, side2, and side3.
 *The accessor methods for all three data fields.
 *A method named getArea() that returns the area of this triangle.
 *A method named getPerimeter() that returns the perimeter of this triangle.
 *A method named toString() that returns a string description for the triangle.
 *
 *Write a test program that prompts the user to enter three sides of the triangle, a color,
 *and a Boolean value to indicate whether the triangle is filled. The program should create a Triangle object
 *with these sides and set the color and filled properties using the input. The program should display the area,
 *perimeter, color, and true or false to indicate whether it is filled or not.
 *
 */
import java.util.Scanner;

public class Triangle extends GeometricObject{
    private double side1;
    private double side2;
    private double side3;


    //Constructors
    Triangle(){
        side1 = 1;
        side2 = 1;
        side3 = 1;
    }

    Triangle(double side1, double side2, double side3){
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    //Getters
    public double getSide1(){
        return side1;
    }

    public double getSide2(){
        return side2;
    }

    public double getSide3(){
        return side3;
    }

    public double getArea(){
        //Area given 3 sides
        double s = (side1 + side2 + side3)/2;
        double area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
        return area;
    }

    public double getPerimeter(){
       double per = side1 + side2 + side3;
       return per;
    }

    public String toString() {
		return "Triangle: side1 = " + side1 + " side2 = " + side2 +
			" side3 = " + side3;
    }

    public static void main(String[] arg){

        //Get Triangle characteristics
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter Side 1 length: ");
        double side1 = keyboard.nextDouble();
        System.out.println("Enter Side 2 length: ");
        double side2 = keyboard.nextDouble();
        System.out.println("Enter Side 3 length: ");
        double side3 = keyboard.nextDouble();
        System.out.println("Enter the color for the triangle: ");
        String color = keyboard.next();
        //Create a default value of false if user does not use y/n
        Boolean filled = false;
        System.out.println("Is the triangle filled? y/n: ");
        String ans = keyboard.next();
        if (ans.equals("y")){
            filled = true;
        }

        //create object
        Triangle t1 = new Triangle(side1, side2, side3);
        t1.setColor(color);
        t1.setFilled(filled);

        //Print object configuration
        System.out.println(t1.toString());
		System.out.println("Area: " + t1.getArea());
		System.out.println("Perimeter: " + t1.getPerimeter());
		System.out.println("Color: " + t1.getColor());
		System.out.println("Triangle is " + (t1.isFilled() ? "filled" : " not filled"));

        keyboard.close();
    }
}


