import java.util.Scanner;
public class trafficApp {

  public static void criticalJamHrs(int vehicles[]) {
    int c=0;
    for(int i=1; i<vehicles.length; i++) {
      if(vehicles[i]>=50 && vehicles[i]>vehicles[i-1]) {
        c++;
      }
    }
    System.out.println(c);
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the total number of hours: ");
    int hrs = sc.nextInt();
    int vehicles[] = new int[hrs];
    System.out.print("Enter the number of vehicles recorded each hour: ");
    for(int i=0; i<hrs; i++) {
      vehicles[i] = sc.nextInt();
    }
    criticalJamHrs(vehicles);
    sc.close();
  }
}
