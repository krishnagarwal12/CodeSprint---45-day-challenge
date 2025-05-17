import java.util.Scanner;
public class magicalDays {

  public static void numberOfMagicalDays(int scores[]) {
    int c=0;
    for(int i=1; i<scores.length-1; i++) {
      if(scores[i]>scores[i-1] && scores[i]>scores[i+1]) {
        c++;
        i++;
      }
    }
    System.out.println(c);
  }
  
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number of days in the marathon: ");
    int n = sc.nextInt();
    int scores[] = new int[n];
    System.out.print("Enter the score for each day: ");
    for(int i=0; i<n; i++) {
      scores[i] = sc.nextInt();
    }
    numberOfMagicalDays(scores);
    sc.close();
  }
}