package M02.Programing_Assignments;
/*
 *Nathan Able
 *SDEV200
 *Assignment 10.14
 *Design a class named MyDate. The class contains:
 *The data fields year, month, and day that represent a date. month is 0-based, i.e., 0 is for January.
 *A no-arg constructor that creates a MyDate object for the current date.
 *A constructor that constructs a MyDate object with a specified elapsed time since midnight, January 1, 1970, in milliseconds.
 *A constructor that constructs a MyDate object with the specified year, month, and day.
 *Three getter methods for the data fields year, month, and day, respectively.
 *A method named setDate(long elapsedTime) that sets a new date for the object using the elapsed time.
 *
 * Draw the UML diagram for the class then implement the class.
 * Write a test program that creates two MyDate objects (using new MyDate() and new MyDate(34355555133101L))
 * and displays their year, month, and day.
 */
import java.util.GregorianCalendar;

public class MyDate {
    private int year;
    private int month;
    private int day;

    //Constructors
    MyDate(){
        GregorianCalendar calendar = new GregorianCalendar();
        year = calendar.get(GregorianCalendar.YEAR);
        month = calendar.get(GregorianCalendar.MONTH);
        day = calendar.get(GregorianCalendar.DAY_OF_MONTH);
    }

    MyDate(long elapsedTime) {
		setDate(elapsedTime);
    }

    MyDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

    //Getters

	public int getYear() {
		return year;
	}

	public String getMonth() {
        //Account for month starting as Jan is 0
		String m = String.valueOf(month + 1);
        //Return in MM format
		return (month +1 < 10 ? "0" + m : m);
	}

	public String getDay() {
		String d = String.valueOf(day);
        //Return in DD format
		return (day < 10 ? "0" + d : d);
	}

    //Set new date with elapsed time
	public void setDate(long elapsedTime) {
		GregorianCalendar calander = new GregorianCalendar();
		calander.setTimeInMillis(elapsedTime);
		year = calander.get(GregorianCalendar.YEAR);
		month = calander.get(GregorianCalendar.MONTH);
		day = calander.get(GregorianCalendar.DAY_OF_MONTH);
	}

    public static void main(String[] args) {
		// Create two MyDate objects
		MyDate date1 = new MyDate();
		MyDate date2 = new MyDate(1234567898765L);

		System.out.println("Date1: " + date1.getMonth() + "/" + date1.getDay() +
			"/" + date1.getYear());
		System.out.println("Date2: " + date2.getMonth() + "/" + date2.getDay() +
			"/" + date2.getYear());
	}
}
