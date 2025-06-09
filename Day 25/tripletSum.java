import java.util.*;
public class tripletSum {

  public static boolean findTriplet(int arr[], int target) {
    Arrays.sort(arr);

    for(int i=0; i<arr.length - 2; i++) {
      int left = i + 1;
      int right = arr.length - 1;

      while(left < right) {
        int sum = arr[i] + arr[left] + arr[right];
        if(sum == target) {
          return true;
        }
        else if(sum < target) {
          left++;
        }
        else {
          right--;
        }
      }
    }
    return false;
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number of magical stones: ");
    int n = sc.nextInt();
    int arr[] = new int[n];
    System.out.println("Enter the numbers on the stone:");
    for(int i=0; i<n; i++) {
      arr[i] = sc.nextInt();
    }
    System.out.print("Enter the target sum: ");
    int target = sc.nextInt();

    System.out.println("Output: "+findTriplet(arr, target));
    sc.close();
  }
}