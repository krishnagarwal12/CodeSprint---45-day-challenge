import java.util.*;
public class parcelPacking {
  public static int findMinimumMaxWeight(int parcels[], int k) {
    int low = Integer.MIN_VALUE;
    int high = 0;

    for(int i=0; i<parcels.length; i++) {
      low = Math.max(low, parcels[i]);
      high += parcels[i];
    }

    int answer = high;

    while(low <= high) {
      int mid = low + (high - low) / 2;
      if(canDivide(parcels, k, mid)) {
        answer = mid; //found a possible ans, try smaller
        high = mid - 1;
      }
      else {
        low = mid + 1; //try larger values
      }
    }
    return answer;
  }

  public static boolean canDivide(int parcels[], int k, int maxAllowedWeight) {
    int currentSum = 0;
    int groups = 1;

    for(int i=0; i<parcels.length; i++) {
      if(currentSum + parcels[i] <= maxAllowedWeight) {
        currentSum += parcels[i];
      }
      else {
        groups++; //start a new group
        currentSum = parcels[i];

        if(groups > k) {
          return false;
        }
      }
    }
    return true;
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of parcels and the maximum number of boxes allowed:");
    int n = sc.nextInt();
    int k = sc.nextInt();
    int parcels[] = new int[n];
    System.out.println("Enter the weights of the parcels:");
    for(int i=0; i<n; i++) {
      parcels[i] = sc.nextInt();
    }

    System.out.println("Output: " + findMinimumMaxWeight(parcels, k));
    sc.close();
  }
}