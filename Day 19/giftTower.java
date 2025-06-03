import java.util.*;
public class giftTower {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number of operations: ");
    int n = sc.nextInt();
    sc.nextLine();

    Stack<String> stack = new Stack<>();
    Map<String, Integer> freq = new HashMap<>();

    for(int i=0; i<n; i++) {
      String line = sc.nextLine();
      if(line.startsWith("PUSH")) {
        String gift = line.split(" ")[1];
        stack.push(gift);
        freq.put(gift, freq.getOrDefault(gift, 0) + 1);
      }
      else if(line.equals("POP")) {
        if(!stack.isEmpty()) {
          String gift = stack.pop();
          freq.put(gift, freq.get(gift)-1);
          if(freq.get(gift) == 0) {
            freq.remove(gift);
          }
        }
      }
      else if(line.equals("COUNT")) {
        if(stack.isEmpty()) {
          System.out.println("EMPTY");
        }
        else {
          String top = stack.peek();
          System.out.println(freq.get(top));
        }
      }
    }
    sc.close();
  }
}