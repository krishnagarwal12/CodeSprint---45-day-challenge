import java.util.*;
public class PowerFunction {
  public static double optimizedPower(double x, int n) {
    //base case
    if(n == 0) {
      return 1.0;
    }

    //for negative exponent
    if(n < 0) {
      x = 1 / n;
      n = -n;
    }

    double halfPower = optimizedPower(x, n/2);
    double result = halfPower * halfPower;

    //if n is odd
    if(n % 2 != 0) {
      result = result * x;
    }
    return result;
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the base (x): ");
    double x = sc.nextDouble();
    System.out.print("Enter the exponent (n): ");
    int n = sc.nextInt();

    System.out.printf("Result: %.5f\n", optimizedPower(x, n));
    sc.close();
  }
}