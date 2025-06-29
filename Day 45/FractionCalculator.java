import java.util.*;
public class FractionCalculator {
  
  private static int gcd(int a, int b) {
    return b == 0 ? Math.abs(a) : gcd(b, a%b);
  }

  public static String fractionAddition(String expression) {
    int numerator = 0;
    int denominator = 1;

    if(expression.charAt(0) != '-') {
      expression = "+" + expression;
    }
    String tokens[] = expression.split("(?=[+-])");

    for(String token : tokens) {
      String frac[] = token.split("/");
      int num = Integer.parseInt(frac[0]);
      int den = Integer.parseInt(frac[1]);

      numerator = numerator * den + num * denominator;
      denominator = denominator * den;

      int g = gcd(numerator, denominator);
      numerator /= g;
      denominator /= g;
    }
    return numerator + "/" + denominator;
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the string representing the formula:");
    String formula = sc.nextLine();
    System.out.println("Output:");
    System.out.println(fractionAddition(formula));
    sc.close();
  }
}