import java.util.*;
public class keypadCombinations {

  //mapping of digits to corresponding letters
  private static final String[] KEYPAD = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

  public static List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<>();

    if(digits == null || digits.length() == 0) {
      return result;
    }

    backtrack(result, new StringBuilder(), digits, 0);
    return result;
  }

  //bactracking 
  private static void backtrack(List<String> result, StringBuilder current, String digits, int index) {
    if(index == digits.length()) {
      result.add(current.toString());
      return;
    }

    String letters = KEYPAD[digits.charAt(index) - '0'];
    char chars[] = letters.toCharArray();

    for(int i=0; i<chars.length; i++) {
      current.append(chars[i]);
      backtrack(result, current, digits, index+1);
      current.deleteCharAt(current.length()-1); //backtrack
    }
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter digits (2-9): ");
    String input = sc.nextLine();

    List<String> combinations = letterCombinations(input);
    System.out.println("Possible combinations: ");

    for(int i=0; i<combinations.size(); i++) {
      System.out.println(combinations.get(i));
    }
    sc.close();
    
  }
}
