import java.util.*;
public class evaluateExp {

  public static int evaluate(String str[]) {
    Stack<Integer> s = new Stack<>();
    for(int i=0; i<str.length; i++) {
      String str1 = str[i];
      if(str1.equals("+") || str1.equals("-") || str1.equals("*") || str1.equals("/")) {
        int b = s.pop();
        int a = s.pop();
        int result = 0;
        if(str1.equals("+")) {
          result = a+b;
        }
        else if(str1.equals("-")) {
          result = a-b;
        }
        else if(str1.equals("*")) {
          result = a*b;
        }
        else {
          result = a/b;
        }
        s.push(result);
      }
      else {
        s.push(Integer.parseInt(str1));
      }
    }
    return s.pop();
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the length of the array:");
    int n = sc.nextInt();
    sc.nextLine();
    String str[] = new String[n];
    System.out.println("Enter your postfix expression:");
    for(int i=0; i<n; i++) {
      str[i] = sc.nextLine();
    }
    System.out.println("Result: "+evaluate(str));
    sc.close();
  }
}