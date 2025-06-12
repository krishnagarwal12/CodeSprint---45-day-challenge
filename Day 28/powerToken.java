import java.util.*;
public class powerToken {
  public static int bagOfTokenScore(int tokens[], int power) {
    Arrays.sort(tokens);
    int left = 0, right = tokens.length - 1;
    int score = 0, maxScore = 0;

    while(left <= right) {
      if(power >= tokens[left]) {
        power = power - tokens[left++];
        score++;
        maxScore = Math.max(maxScore, score);
      }
      else if(score > 0) {
        power = power + tokens[right--];
        score--;
      }
      else {
        break;
      }
    }
    return maxScore;
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number of tokens: ");
    int n = sc.nextInt();
    int tokens[] = new int[n];
    System.out.println("Enter the power value of each token:");
    for(int i=0; i<n; i++) {
      tokens[i] = sc.nextInt();
    }
    System.out.print("Enter your initial amount of power: ");
    int power = sc.nextInt();

    System.out.println("Maximum score that can be achieved: "+bagOfTokenScore(tokens, power));
    sc.close();
  }
}