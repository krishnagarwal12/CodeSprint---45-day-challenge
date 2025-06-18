import java.util.*;
public class heaterChallenge {
  public static int findMinimumRadius(int houses[], int heaters[]) {
    Arrays.sort(houses);
    Arrays.sort(heaters);

    int radius = 0;

    for(int i=0; i<houses.length; i++) {
      int closestHeaterDistance = Integer.MAX_VALUE;

      for(int j=0; j<heaters.length; j++) {
        closestHeaterDistance = Math.min(closestHeaterDistance, Math.abs(houses[i] - heaters[j]));
      }

      radius = Math.max(radius, closestHeaterDistance);
    }
    return radius;
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter the number of houses:");
    int n = sc.nextInt();
    int houses[] = new int[n];
    System.out.println("Enter the position of the houses:");
    for(int i=0; i<n; i++) {
      houses[i] = sc.nextInt();
    }

    System.out.println("Enter the number of heaters:");
    int m = sc.nextInt();
    int heaters[] = new int[m];
    System.out.println("Enter the positions of the heaters:");
    for(int i=0; i<m; i++) {
      heaters[i] = sc.nextInt();
    }

    int radius = findMinimumRadius(houses, heaters);
    System.out.println("The minimum radius required is: " + radius);

    sc.close();
  }
}