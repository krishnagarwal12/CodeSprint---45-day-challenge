import java.util.*;
public class game {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number of words: ");
    int n = sc.nextInt();
    sc.nextLine();

    System.out.println("Enter the words:");
    String words[] = new String[n];
    for(int i=0; i<n; i++) {
      words[i] = sc.nextLine();
    }

    int niceness[] = new int[n];
    for(int i=0; i<n; i++) {
      for(int j=0; j<i; j++) {
        if(words[j].compareTo(words[i]) < 0) {
          niceness[i]++;        
        }
      }
    }

    System.out.println("Niceness Values:");
    for(int i=0; i<n; i++) {
      System.out.println(niceness[i]);
    }
    sc.close();
  }
}