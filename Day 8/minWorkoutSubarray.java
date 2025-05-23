import java.util.*;
public class minWorkoutSubarray {

  public static int minSubArrayLength(int target, int sessions[]) {
    int minLength = Integer.MAX_VALUE;
    int sum = 0;
    int low = 0; 
    int high = 0;
    while(high < sessions.length) {
      sum+= sessions[high];
      high++;

      while(sum>=target) {
        int currLength = high - low;
        minLength = Math.min(minLength, currLength);
        sum-= sessions[low];
        low++;
      }
    }
    return minLength == Integer.MAX_VALUE ? 0 : minLength;
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the target calories: ");
    int target = sc.nextInt();
    System.out.print("Enter the number of sessions: ");
    int n = sc.nextInt();
    int sessions[] = new int[n];
    System.out.print("Enter calories burned in each session: ");
    for(int i=0; i<n; i++) {
      sessions[i] = sc.nextInt();
    }
    int result = minSubArrayLength(target, sessions);
    System.out.println(result);
    sc.close();
  }
}