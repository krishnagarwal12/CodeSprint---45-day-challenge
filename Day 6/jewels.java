import java.util.*;
public class jewels {

  public static void isJewels(String jewels, String stones) {
    Set<Character> jewelSet = new HashSet<>();
    for (int i = 0; i < jewels.length(); i++) {
      jewelSet.add(jewels.charAt(i));
    }
    int count = 0;
    for (int j = 0; j < stones.length(); j++) {
      if (jewelSet.contains(stones.charAt(j))) {
        count++;
      }
    }
    System.out.println(count);
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the types of stones that are jewels: ");
    String jewels = sc.nextLine();
    System.out.print("Enter the stones that Rahil has: ");
    String stones = sc.nextLine();
    isJewels(jewels, stones);
    sc.close();
  }
}
