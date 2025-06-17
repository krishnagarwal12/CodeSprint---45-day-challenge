import java.util.*;
public class BinaryStringSorter {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the length of the binary string:");
    int n = sc.nextInt();
    System.out.println("Enter the binary string:");
    String s = sc.next();

    int misplacedPairs = 0;

    int i = 0;
    int j = n - 1;

    while(i < j) {
      if(s.charAt(i) == '1' && s.charAt(j) == '0') {
        misplacedPairs++;
        i++;
        j--;
      }
      else {
        if(s.charAt(i) == '0') i++;
        if(s.charAt(j) == '1') j--;
      }
    }
    System.out.println("Output: " + misplacedPairs);
    sc.close();
  }
}