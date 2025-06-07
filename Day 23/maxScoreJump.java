import java.util.*;
public class maxScoreJump {

  public static int maxResult(int[] nums, int k) {
    int n = nums.length;
    int dp[] = new int[n];
    dp[0] = nums[0];

    Deque<Integer> deque = new ArrayDeque<>();
    deque.offer(0);

    for(int i = 1; i<n; i++) {
      while(!deque.isEmpty() && deque.peek() < i-k) {
        deque.poll();
      }

      dp[i] = nums[i] + dp[deque.peek()];

      while(!deque.isEmpty() && dp[i] >= dp[deque.peekLast()]) {
        deque.pollLast();
      }

      deque.offer(i);
    }
    return dp[n-1];
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number of rooms: ");
    int n = sc.nextInt();
    sc.nextLine();
    int nums[] = new int[n];
    System.out.println("Enter the number of points in each room:");
    for(int i=0; i<n; i++) {
      nums[i] = sc.nextInt();
    }
    System.out.print("Enter the maximum number of rooms you can jump forward at each step: ");
    int k = sc.nextInt();
    sc.nextLine();
    System.out.println("Result: "+maxResult(nums,k));
    sc.close();
  }
}