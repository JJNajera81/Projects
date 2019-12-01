// Eddie Valdez, Jorge Najera, Stephanie Hernandez, Erica Lem


//importing libraries to run program
import java.util.Scanner;
import java.text.DecimalFormat;
import java.time.temporal.ValueRange;

public class GroupProject {
	public static void main(String[] args) {

		// Declaring variables
		String promemb = "pro";
		String basicmemb = "basic";
		double basic = 25;
		double basic1 = 22.5;
		double basic2 = 21.25;
		double pro = 50;
		double pro2 = 45;
		double pro3 = 42.5;
		double hard = 83.3334;
		double tax = .0825;
		int term = 0;

		// Declare Scanner
		Scanner in = new Scanner(System.in);
		int many;
		do {
			// Asking user for input and making sure a number is entered if not prompt for
			// correct response
			System.out.println("How many licenses would you like to purchase? ");
			while (!in.hasNextInt()) {
				System.out.println("Input is not a number.....How many licenses would you like to purchase?");
				in.next();
			}
			many = in.nextInt();
		} while (many <= 0);
		in.nextLine();
		// Asking user for input and making sure a string pro or basic is entered if not
		// prompt for correct response
		System.out.println("Would the licenses be pro , or basic? ");
		String type = in.nextLine();

		while (!type.toLowerCase().contentEquals("pro") && !type.toLowerCase().contentEquals("basic")) {
			System.out.println("Invalid Response...Try Again");
			type = in.nextLine();
		}
		// Asking user for input and making sure a number is entered if not prompt for
		// correct response
		System.out.println("Would you like some hardware? ");
		String hardware = in.nextLine();
		while (!hardware.toLowerCase().contentEquals("yes") && !hardware.toLowerCase().contentEquals("no")) {
			System.out.println("Invalid Response...Try Again");
			hardware = in.nextLine();
		}
		// Asking user for input and making sure a number is entered if not prompt for
		// correct response
		int qty;
		do {
			System.out.println("How many? ");
			while (!in.hasNextInt()) {
				System.out.println("Input is not a number....How many?");
				in.next();
			}
			qty = in.nextInt();
		} while (qty < 0);
		in.nextLine();
		// Loop in order to get response to print again if user response is equal no yes
		// and less than 12 months.
		for (int i = 0; i < 3; i++) {
			System.out.println("How long (months) do you want to keep your subscription? ");
			term = in.nextInt();
			in.nextLine();
			// Declaring variable that user is to input if they want hardware or not.
			String response = "no";
			String reply = "yes";
			//
			if (response.contentEquals(hardware)) {
				System.out.println("Calulating cost...");
				break;
			}
			if (reply.contentEquals(hardware) && ValueRange.of(12, 1000).isValidIntValue(term)) {
				System.out.println("Calulating cost...");
				break;
			} else
				System.out.println("Sorry, since you are purchasing software your plan must be 12 months or more");

		}
		// closing the scanner
		in.close();
		// Array for months
		String[] calendar = { "January", "February", "March", "April", "May", "June", "July", "August", "Sepetember",
				"October", "November", "December" };

		// Calling methods below based on membership type and term length
		{
			System.out.println("Montly Cost Expanded: ");
			if (promemb.equalsIgnoreCase(type) && term < 10)
				licLessTen(pro, tax, many, hard, qty);
			else if (promemb.equalsIgnoreCase(type) && term > 10 && term < 100)
				licMoreTen(pro2, tax, many, hard, qty);
			else if (promemb.equalsIgnoreCase(type) && term > 100)
				licMore100(pro3, tax, many, hard, qty);
			else if (basicmemb.equalsIgnoreCase(type) && term < 10)
				licLessTen2(basic, tax, many, hard, qty);
			else if (basicmemb.equalsIgnoreCase(type) && term > 10 && term < 100)
				licMoreTen2(basic1, tax, many, hard, qty);
			else if (basicmemb.equalsIgnoreCase(type) && term > 100)
				licMore1002(basic2, tax, many, hard, qty);
		}
		// For loop in order to keep track of months in order to print correct amount
		// from array
		{
			System.out.println("7.Montly Cost Expanded: ");
			for (int a = 0; a < term; a++) {

				if (promemb.equalsIgnoreCase(type) && term < 10)
					System.out.println(calendar[a % 12] + " $" + pro + 83.33 + " + $"
							+ (new DecimalFormat("0.00").format(pro * tax) + " TAX"));
				else if (promemb.equalsIgnoreCase(type) && (term > 10 && term < 100))
					System.out.println(calendar[a % 12] + " $" + pro2 + " + $"
							+ (new DecimalFormat("0.00").format(pro2 * tax) + " TAX"));
				else if (promemb.equalsIgnoreCase(type) && term > 100)
					System.out.println(calendar[a % 12] + " $" + pro2 + " + $"
							+ (new DecimalFormat("0.00").format(pro2 * tax) + " TAX"));
				else if (basicmemb.equalsIgnoreCase(type) && term < 10)
					System.out.println(calendar[a % 12] + " $" + basic + " + $"
							+ (new DecimalFormat("0.00").format(basic * tax) + " TAX"));
				else if (basicmemb.equalsIgnoreCase(type) && (term > 10 && term < 100))
					System.out.println(calendar[a % 12] + " $" + basic1 + " + $"
							+ (new DecimalFormat("0.00").format(basic1 * tax) + " TAX"));
				else if (basicmemb.equalsIgnoreCase(type) && (term > 100))
					System.out.println(calendar[a % 12] + " $" + basic2 + " + $"
							+ (new DecimalFormat("0.00").format(basic2 * tax) + " TAX"));

			}
		}

	}

	// Method for pro licenses less than 10
	public static void licLessTen(double pro, double tax, double many, double hard, double qty) {
		// math for license by many and license plus hardware
		double promathmonth = ((pro * many) + (hard * qty));
		double promathnohard = (pro * many);
		// Print statement for the requested output
		System.out.println("1.The montly cost per license is: $" + pro + " + $" + (pro * tax) + " TAX");
		System.out.println("2.The yearly cost per license is: $" + ((pro * 12) * .9) + " + $"
				+ (((pro * 12) * .9) * tax) + " TAX");
		System.out.println(
				"3.The montly cost for all license is: $" + promathmonth + " + $" + (promathmonth * tax) + "TAX");
		System.out.println("4.The yearly cost for all license is: $" + ((promathmonth * 12) * .9) + " + $"
				+ (((promathmonth * tax) * .9) * 12) + " TAX");
		System.out.println("5.The monthly cost per license after the hardware has been paid in full is:"
				+ (promathnohard) + " + $" + (promathnohard * tax) + " TAX");
		System.out.println("6.The yearly cost per license after the hardware has been paid in full is:"
				+ ((promathnohard * 12) * .9) + " + $" + (((promathnohard * 12) * .9) * tax) + " TAX");
	}

	// Method for pro licenses more than 10 less than 100
	public static void licMoreTen(double pro2, double tax, double many, double hard, double qty) {
		// math for license by many and license plus hardware
		double promathmonth1 = ((pro2 * many) + (hard * qty));
		double promathnohard1 = (pro2 * many);
		// Print statement for the requested output
		System.out.println("1.The montly cost per license is: $" + pro2 + " + $" + (pro2 * tax) + " TAX");
		System.out.println("2.The yearly cost per license is: $" + ((pro2 * 12) * .9) + " + $"
				+ (((pro2 * 12) * .9) * tax) + " TAX");
		System.out.println(
				"3.The montly cost for all license is: $" + promathmonth1 + " + $" + (promathmonth1 * tax) + "TAX");
		System.out.println("4.The yearly cost for all license is: $" + ((promathmonth1 * 12) * .9) + " + $"
				+ (((promathmonth1 * .9) * tax) * 12) + " TAX");
		System.out.println("5.The monthly cost per license after the hardware has been paid in full is:"
				+ (promathnohard1) + " + $" + ((promathnohard1 * tax) + " TAX"));
		System.out.println("6.The yearly cost per license after the hardware has been paid in full is:"
				+ ((promathnohard1 * 12) * .9) + " + $" + (((promathnohard1 * 12) * .9) * tax) + " TAX");

	}

	// Method for pro licenses more than 100
	public static void licMore100(double pro3, double tax, double many, double hard, double qty) {
		// math for license by many and license plus hardware
		double promathmonth2 = ((pro3 * many) + (hard * qty));
		double promathnohard2 = (pro3 * many);
		// Print statement for the requested output
		System.out.println("1.The montly cost per license is: $" + pro3 + " + $" + (pro3 * tax) + " TAX");
		System.out.println("2.The yearly cost per license is: $" + ((pro3 * 12) * .9) + " + $"
				+ (((pro3 * 12) * .9) * tax) + " TAX");
		System.out.println(
				"3.The montly cost for all license is: $" + promathmonth2 + " + $" + (promathmonth2 * tax) + "TAX");
		System.out.println("4.The yearly cost for all license is: $" + ((promathmonth2 * 12) * .9) + " + $"
				+ (((promathmonth2 * tax) * 12) * .9) + " TAX");
		System.out.println("5.The monthly cost per license after the hardware has been paid in full is:"
				+ (promathnohard2) + " + $" + ((promathnohard2 * tax) + " TAX"));
		System.out.println("6.The yearly cost per license after the hardware has been paid in full is:"
				+ ((promathnohard2 * 12) * .9) + " + $" + (((promathnohard2 * 12) * .9) * tax) + " TAX");

	}

	// Method for basic licenses less than 10
	public static void licLessTen2(double basic, double tax, double many, double hard, double qty) {
		// math for license by many and license plus hardware
		double basicmathmonth = ((basic * many) + (hard * qty));
		double basicmathnohard = (basic * many);
		// Print statement for the requested output
		System.out.println("1.The montly cost per license is: $" + basic + " + $"
				+ (new DecimalFormat("0.00").format(basic * tax) + " TAX"));
		System.out.println("2.The yearly cost per license is: $" + ((basic * 12) * .9) + " + $"
				+ ((((basic * 12) * .9) * tax) + " TAX"));
		System.out.println("3.The montly cost for all license is: $" + basicmathmonth + " + $"
				+ (new DecimalFormat("0.00").format(basicmathmonth * tax)) + "TAX");
		System.out.println("4.The yearly cost for all license is: $" + ((basicmathmonth * 12) * .9) + " + $"
				+ (((basicmathmonth * tax) * .9) * 12) + " TAX");
		System.out.println("5.The monthly cost per license after the hardware has been paid in full is:"
				+ (basicmathnohard) + " + $" + ((basicmathnohard * tax) + " TAX"));
		System.out.println("6.The yearly cost per license after the hardware has been paid in full is:"
				+ ((basicmathnohard * 12) * .9) + " + $" + (((basicmathnohard * 12) * .9) * tax) + " TAX");
	}

	// Method for basic licenses more than 10 less than 100
	public static void licMoreTen2(double basic1, double tax, double many, double hard, double qty) {
		// math for license by many and license plus hardware
		double basicmathmonth1 = ((basic1 * many) + (hard * qty));
		double basicmathnohard1 = (basic1 * many);
		// Print statement for the requested output
		System.out.println("1.The montly cost per license is: $" + basic1 + " + $"
				+ (new DecimalFormat("0.00").format(basic1 * tax) + " TAX"));
		System.out.println("2.The yearly cost per license is: $" + ((basic1 * 12) * .9) + " + $"
				+ (((basic1 * 12) * .9) * tax) + " TAX");
		System.out.println("3.The montly cost for all license is: $" + basicmathmonth1 + " + $"
				+ (new DecimalFormat("0.00").format(basicmathmonth1 * tax)) + "TAX");
		System.out.println("4.The yearly cost for all license is: $" + ((basicmathmonth1 * 12) * .9) + " + $"
				+ (((basicmathmonth1 * tax) * .9) * 12) + " TAX");
		System.out.println("5.The monthly cost per license after the hardware has been paid in full is:"
				+ (basicmathnohard1) + " + $" + ((basicmathnohard1 * tax) + " TAX"));
		System.out.println("6.The yearly cost per license after the hardware has been paid in full is:"
				+ ((basicmathnohard1 * 12) * .9) + " + $" + (((basicmathnohard1 * 12) * .9) * tax) + " TAX");
	}

	// Method for basic licenses more than 100
	public static void licMore1002(double basic2, double tax, double many, double hard, double qty) {
		// math for license by many and license plus hardware
		double basicmathmonth2 = ((basic2 * many) + (hard * qty));
		double basicmathnohard2 = (basic2 * many);
		// Print statement for the requested output
		System.out.println("1.The montly cost per license is: $" + basic2 + " + $" + (basic2 * tax) + " TAX");
		System.out.println("2.The yearly cost per license is: $" + ((basic2 * 12) * .9) + " + $"
				+ (((basic2 * .9) * 12) * tax) + " TAX");
		System.out.println("3.The montly cost for all license is: $" + basicmathmonth2 + " + $"
				+ (basicmathmonth2 * tax) + " TAX");
		System.out.println("4.The yearly cost for all license is: $" + ((basicmathmonth2 * 12) * .9) + " + $"
				+ (((basicmathmonth2 * .9) * tax) * 12) + " TAX");
		System.out.println("5.The monthly cost per license after the hardware has been paid in full is: $"
				+ (basicmathnohard2 * 12) + " + $" + ((basicmathnohard2 * tax) + " TAX"));
		System.out.println("6.The yearly cost per license after the hardware has been paid in full is:"
				+ ((basicmathnohard2 * 12) * .9) + " + $" + (((basicmathnohard2 * 12) * .9) * tax) + " TAX");
	}

}
