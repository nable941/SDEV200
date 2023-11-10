package M03.Programing_Assignments;
/*
 * Nathan Able
 * SDEV 200
 * Assignment 13.15
 * Redesign and implement the Rational class in Listing 13.13 using BigInteger for the numerator and denominator.
 */

import java.math.BigInteger;
import java.util.Scanner;

 //Coppied and edited from Listing 13.13
public class Rational extends Number implements Comparable<Rational> {
	//Changed from long to BigInteger objects
	private BigInteger[] r = new BigInteger[2];

	//Update default to create the same with new BigInteger Objects
	public Rational() {
		this(new BigInteger("0"), new BigInteger("1"));
	}

	//Update with specific BigInteger Objects
	public Rational(BigInteger numerator, BigInteger denominator) {
		BigInteger gcd = gcd(numerator, denominator);
		r[0] = (denominator.compareTo(BigInteger.ZERO) > 0
			? BigInteger.ONE :
			new BigInteger("-1")).multiply(numerator.divide(gcd));
		r[1] = denominator.divide(gcd);
	}

	//Gross comomon Denom
	private static BigInteger gcd(BigInteger n, BigInteger d) {
		BigInteger n1 = n;
		BigInteger n2 = d;
		BigInteger gcd = BigInteger.ONE;

		for (BigInteger k = BigInteger.ONE;
			k.compareTo(n1) <= 0 && k.compareTo(n2) <= 0;
			k = k.add(BigInteger.ONE)) {
			if (n1.remainder(k).compareTo(BigInteger.ZERO) == 0 &&
				n2.remainder(k).compareTo(BigInteger.ZERO) == 0)
				gcd = k;
		}

		return gcd;
	}

	//Getter
	public BigInteger getNumerator() {
		return r[0];
	}


	public BigInteger getDenominator() {
		return r[1];
	}

	//Add
	public Rational add(Rational secondRational) {
		BigInteger n = (r[0].multiply(secondRational.getDenominator())).add(
			r[1].multiply(secondRational.getNumerator()));
		BigInteger d = r[1].multiply(secondRational.getDenominator());
		return new Rational(n, d);
	}

	//Subtract
	public Rational subtract(Rational secondRational) {
		BigInteger n = (r[0].multiply(secondRational.getDenominator())).subtract(
			r[1].multiply(secondRational.getNumerator()));
		BigInteger d = r[1].multiply(secondRational.getDenominator());
		return new Rational(n, d);
	}

	//Multiply
	public Rational multiply(Rational secondRational) {
		BigInteger n = r[0].multiply(secondRational.getNumerator());
		BigInteger d = r[1].multiply(secondRational.getDenominator());
		return new Rational(n, d);
	}

	//Divide
	public Rational divide(Rational secondRational) {
		BigInteger n = r[0].multiply(secondRational.getDenominator());
		BigInteger d = r[1].multiply(secondRational.getNumerator());
		return new Rational(n, d);
	}

	@Override
	public String toString() {
		if (r[1].compareTo(BigInteger.ONE) == 0)
			return r[0] + "";
		else
			return r[0] + "/" + r[1];
	}

    // Override the equals method in the Object class - No changes
	@Override
	public boolean equals(Object other) {
		if (((this.subtract((Rational)(other))).getNumerator()).compareTo(
			BigInteger.ZERO) == 0)
			return true;
		else
			return false;
	}

    // Implement the abstract intValue method in Number - No changes
	@Override
	public int intValue() {
		return (int)doubleValue();
	}

    // Implement the abstract floatValue method in Number - No changes
	@Override
	public float floatValue() {
		return (float)doubleValue();
	}

    // Implement the doubleValue method in Number - No changes
	@Override
	public double doubleValue() {
		return this.getNumerator().doubleValue() /
			this.getDenominator().doubleValue();
	}

    // Implement the abstract longValue method in Number - No changes
	@Override
	public long longValue() {
		return (long)doubleValue();
	}

	//Update the comapreTo to use the BigInteger
	@Override
	public int compareTo(Rational x) {
		BigInteger zero = BigInteger.ZERO;
		BigInteger n = this.subtract((Rational)x).getNumerator();
		if (n.compareTo(zero) > 0)
			return 1;
		else if (n.compareTo(zero) < 0)
			return -1;
		else
			return 0;
	}


	public static void main(String[] args) {
		// Create and initialize two rational numbers r1 and r2
		Scanner keyboard = new Scanner(System.in);
		String num;
		String denom;
		System.out.println("Enter first Numerator: ");
		num = keyboard.next();
		System.out.println("Enter first Denominator: ");
		denom = keyboard.next();
		Rational r1 = new Rational(new BigInteger(num),
			new BigInteger(denom));
		System.out.println("Enter second Numerator: ");
		num = keyboard.next();
		System.out.println("Enter second Denominator: ");
		denom = keyboard.next();
		Rational r2 = new Rational(new BigInteger(num),
			new BigInteger(denom));

		// Display results
		System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
		System.out.println(r1 + " - " + r2 + " = " + r1.subtract(r2));
		System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));
		System.out.println(r1 + " / " + r2 + " = " + r1.divide(r2));
		System.out.println(r2 + " is " + r2.doubleValue());
		keyboard.close();
	}
}
