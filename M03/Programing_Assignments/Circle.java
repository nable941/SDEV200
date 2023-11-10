package M03.Programing_Assignments;
/*
 * Nathan Able
 * SDEV 200
 * Assignment 13.9
 *
 * Rewrite the Circle class in Listing 13.2 to extend GeometricObject and implement the Comparable interface.
 * Override the equals method in the Object class. Two Circle objects are equal if their radii are the same.
 *
 */
public class Circle extends GeometricObject implements Comparable<Circle>{
    private double radius;

    public Circle() {
	}

	public Circle(double radius) {
		this.radius = radius;
	}

	public Circle(double radius,
		String color, boolean filled) {
		this.radius = radius;
		setColor(color);
		setFilled(filled);
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

    public double getArea(){
        return radius * radius *Math.PI;
    }

    public double getDiameter(){
        return radius * 2;
    }

    public double getPerimeter(){
        return radius * 2 * Math.PI;
    }

    public void printCircle(){
        System.out.println("The circle is created " + getDateCreated() + " and the radius is " + radius);
    }
    //Based on code in listing 13.9
    @Override
    public boolean equals(Object x) {
		return this.compareTo((Circle)x) == 0;
	}
    
    @Override
	public int compareTo(Circle x) {
		if (this.radius > x.radius)
			return 1;
		else if (this.radius < x.radius)
			return -1;
		else
			return 0;
	}

}
