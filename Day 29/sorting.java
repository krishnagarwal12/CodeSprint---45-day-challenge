import java.util.*;
public class sorting {
  public static void sortedSquare(int nums[]) {
    int result[] = new int[nums.length];
    int left = 0, right = nums.length-1;
    int index = nums.length - 1;

    while(left <= right) {
      int leftSq = nums[left]*nums[left];
      int rightSq = nums[right]*nums[right];

      if(leftSq > rightSq) {
        result[index--] = leftSq;
        left++;
      }
      else {
        result[index--] = rightSq;
        right--;
      }
    }
    for(int i=0; i<result.length; i++){
      System.out.print(result[i]+" ");
    }
    System.out.println();
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number of elements in the array: ");
    int n = sc.nextInt();
    int nums[] = new int[n];
    System.out.println("Enter the elements:");
    for(int i=0; i<n; i++) {
      nums[i] = sc.nextInt();
    }
    System.out.println("Output:");
    sortedSquare(nums);
    sc.close();
  }
}