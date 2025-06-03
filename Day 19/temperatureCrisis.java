import java.util.*;
public class temperatureCrisis {

  public static void main(String args[]) {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number of operations to be performed: ");
    int n = sc.nextInt();
    sc.nextLine();

    for(int i=0; i<n; i++) {
      String command = sc.nextLine();
      if(command.startsWith("PUSH")) {
        int x = Integer.parseInt(command.split(" ")[1]);
        stack.push(x);
        if(minStack.isEmpty() || x <= minStack.peek()) {
          minStack.push(x);
        }
      }
      else if(command.equals("POP")) {
        if(!stack.isEmpty()) {
          int removed = stack.pop();
          if(!minStack.isEmpty() && removed == minStack.peek()) {
            minStack.pop();
          }
        }
      }
      else if(command.equals("MIN")){
        if(minStack.isEmpty()) {
          System.out.println("EMPTY");
        }
        else {
          System.out.println(minStack.peek());
        }
      }
    }
    sc.close();
  }
}
