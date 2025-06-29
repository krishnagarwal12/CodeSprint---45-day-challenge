import java.util.*;
public class CipherCheck {
  public static boolean isValidMapping(String s, String t) {
    if(s.length() != t.length()) {
      return false;
    }
    Map<Character, Character> mapST = new HashMap<>();
    Set<Character> usedChars = new HashSet<>();

    for(int i=0; i<s.length(); i++) {
      char chS = s.charAt(i);
      char chT = t.charAt(i);

      if(mapST.containsKey(chS)) {
        if(mapST.get(chS) != chT) {
          return false;
        }
      }
      else {
        if(usedChars.contains(chT)) {
          return false;
        }
        mapST.put(chS, chT);
        usedChars.add(chT);
      }
    }
    return true;
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the original message:");
    String s = sc.nextLine();
    System.out.println("Enter the coded message:");
    String t = sc.nextLine();

    boolean result = isValidMapping(s, t);
    System.out.println("Output:");
    System.out.println(result);
    sc.close();
  }
}