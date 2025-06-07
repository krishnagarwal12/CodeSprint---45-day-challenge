import java.util.*;
public class Dota2Senate {

  public static String predictVictory(String senate) {
    int n = senate.length();
    Queue<Integer> radiant = new LinkedList<>();
    Queue<Integer> dire = new LinkedList<>();

    //fill queues with indices
    for(int i=0; i<n; i++) {
      if(senate.charAt(i) == 'R') {
        radiant.offer(i);
      }
      else {
        dire.offer(i);
      }
    }

    //banning
    while(!radiant.isEmpty() && !dire.isEmpty()) {
      int r = radiant.poll();
      int d = dire.poll();

      if(r < d) {
        radiant.offer(r+n); //R survives
      }
      else {
        dire.offer(d+n); //D survives
      }
    }
    if(radiant.isEmpty()) {
      return "Dire";
    }
    else {
      return "Radiant";
    }
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter your string:");
    String senate = sc.nextLine();
    System.out.println("Result: "+predictVictory(senate));
    sc.close();
  }
}