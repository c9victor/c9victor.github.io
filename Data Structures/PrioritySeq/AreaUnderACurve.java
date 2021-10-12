import java.util.Scanner;
import java.lang.Math;

public class AreaUnderACurve {

	/**
		The function f(x) = x^2 + x + 1.
	*/
	private static double f(double x) {
		return x * x + x + 1; 
	}

	/**
		Returns an approximation for the area under the curve f(x) between x = a and x = b.
	*/
	private static double computeArea(double a, double b) {
		double error = 1e-08; // This is the comparison error. See document for description.

		// TODO: Please compute an approximation for the area under the curve here.
        PriorityQueue pq = new PriorityQueue(20);
        double c = 999999;
        Interval i = new Interval(a, b);
        pq.insert(i);
        double d = (b - a) * f(b);
        
        while(Math.abs(d - c) > error) {
            Interval max = pq.remove_max();
            double m = max.getStart(); 
            double n = max.getEnd();
            c = d;
            double p = (m + n) / 2;
            Interval one = new Interval (m, p);
            Interval two = new Interval (p, n);
            pq.insert(one);
            pq.insert(two);
            d = c - (n - m) * f(n) + (p - m) * f(p) + (n - p) * f(n);
        }
		return c;
	}

	public static void main(String [] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("We have the function f(x) = x^2 + x + 1.");
		System.out.print("Please enter lower value a: ");
		double a = kb.nextDouble();
		System.out.print("Please enter upper value b: ");
		double b = kb.nextDouble();

		double area = computeArea(a, b);
		System.out.println("\nAn approximation for the area under the curve f(x) \nbetween a = " + a + " and b = " + b + " is " + area);
	}
}
