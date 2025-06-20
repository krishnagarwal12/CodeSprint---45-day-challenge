import java.util.*;
public class geometricSeriesSum {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number of days: ");
    int n = sc.nextInt();

    double a = 1.0;
    double r = 1.0 / 3;
    double sum = a * (1 - Math.pow(r, n)) / (1 - r);

    System.out.printf("%.5f\n", sum);
    sc.close();
  }
}