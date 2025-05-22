import java.util.*;
public class movementSegmentCounter {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the string: ");
    String log = sc.nextLine();
    int count=0;
    boolean inSegment = false;

    for(int i=0; i<log.length(); i++) {
      if(log.charAt(i) == '1') {
        if(!inSegment) {
          count++;
          inSegment = true;
        }
      }
      else {
        inSegment = false;
      }
    }
    System.out.println(count);
    sc.close();
  }
}