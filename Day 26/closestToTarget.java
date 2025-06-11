import java.util.*;
public class closestToTarget {

  public static int closestSum(int arr[], int target) {
    Arrays.sort(arr);
    int closest = arr[0]+arr[1]+arr[2];

    for(int i=0; i<arr.length-2; i++){
      int left = i+1;
      int right = arr.length-1;

      while(left<right) {
        int sum = arr[i] + arr[left] + arr[right];

        if(Math.abs(target-sum) < Math.abs(target-closest) || (Math.abs(target-sum) == Math.abs(target-closest) && sum>closest)) {
          closest = sum;
        }

        if(sum<target) {
          left++;
        }
        else {
          right--;
        }
      }
    }
    return closest;
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter the number of elements: ");
    int n = sc.nextInt();

    if(n<3) {
      System.out.println("Need at leadt 3 numbers.");
      return;
    }

    int arr[] = new int[n];
    System.out.println("Enter the elements: ");
    for(int i=0; i<n; i++){
      arr[i] = sc.nextInt();
    }
    System.out.print("Enter the target: ");
    int target = sc.nextInt();

    System.out.println("Closest sum to target: "+closestSum(arr, target));

    sc.close();
  }
}