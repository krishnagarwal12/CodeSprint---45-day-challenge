import java.util.*;
public class secretParentheses {

  public static String removeOuterPara(String str) {
    StringBuilder result = new StringBuilder();
    int open = 0;

    for(int i=0; i<str.length(); i++) {
      char ch = str.charAt(i);

      if(ch == '(') {
        if(open > 0) {
          result.append(ch);
        }
        open++;
      }
      else if(ch == ')') {
        open--;
        if(open > 0) {
          result.append(ch);
        } 
      }
    }
    return result.toString();
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter your string:");
    String str = sc.nextLine();
    System.out.println("Output:");
    System.out.println(removeOuterPara(str));
    sc.close();
  }
}