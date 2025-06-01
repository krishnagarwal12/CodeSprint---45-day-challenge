import java.util.*;
public class postfixToPrefix {

  public static String postToPre(String str) {
    Stack<String> s = new Stack<>();

    for(int i=0; i<str.length(); i++) {
      char ch = str.charAt(i);
      
      if(Character.isLetter(ch)) {
        s.push(ch + "");
      }
      else {
        String op1 = s.pop();
        String op2 = s.pop();
        String exp = ch + op2 + op1;
        s.push(exp);
      }
    }
    return s.pop();
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the postfix expression:");
    String str = sc.nextLine();
    String result = postToPre(str);
    System.out.println("Prefix expression:");
    System.out.println(result);
    sc.close();
  }
}