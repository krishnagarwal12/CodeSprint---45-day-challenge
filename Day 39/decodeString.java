import java.util.*;
public class decodeString {
  public static String decodeString(String s) {
    Stack<Integer> countStack = new Stack<>();
    Stack<StringBuilder> stringStack = new Stack<>();
    StringBuilder currString = new StringBuilder();
    int k = 0;

    for(char ch : s.toCharArray()) {
      if(Character.isDigit(ch)) {
        k = k*10 + (ch - '0');
      }
      else if(ch == '[') {
        countStack.push(k);
        stringStack.push(currString);
        currString = new StringBuilder();
        k = 0;
      }
      else if(ch == ']') {
        int repeat = countStack.pop();
        StringBuilder decoded = stringStack.pop();
        for(int i=0; i<repeat; i++) {
          decoded.append(currString);
        }
        currString = decoded;
      }
      else {
        currString.append(ch);
      }
    }
    return currString.toString();
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter your string:");
    String s = sc.nextLine();
    System.out.println("Decoded string: " + decodeString(s));
    sc.close();
  }
}