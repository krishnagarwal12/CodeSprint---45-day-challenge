import java.util.Scanner;
public class dailyTemperature {

  public static void longestIncSubarray(int temps[]) {
    int c=1, max=1;
    for(int i=0; i<temps.length-1; i++) {
      if(temps[i] < temps[i+1]) {
        c++;
      }
      else {
        if(c>max) {
          max = c;
        }
        c=1;
      }
    }
    if(c > max) {
      max = c;
    }
    System.out.println(max);
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number of days: ");
    int n = sc.nextInt();
    int temps[] = new int[n];
    System.out.print("Enter the daily temperature readings: ");
    for(int i=0; i<n; i++) {
      temps[i] = sc.nextInt();
    }
    longestIncSubarray(temps);
    sc.close();
  }
}