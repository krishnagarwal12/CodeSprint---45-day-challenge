import java.util.*;
public class firstUniqueCharacter {

  public static String firstNonRepeating(String s) {
    StringBuilder result = new StringBuilder();
    Queue<Character> queue = new LinkedList<>();
    Map<Character, Integer> freqMap = new HashMap<>();

    for(char c : s.toCharArray()) {
      freqMap.put(c, freqMap.getOrDefault(c,0)+1);
      queue.offer(c);
      while(!queue.isEmpty() && freqMap.get(queue.peek()) > 1) {
        queue.poll();
      }
      if(queue.isEmpty()) {
        result.append('#');
      }
      else {
        result.append(queue.peek());
      }
    }
    return result.toString();
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the string:");
    String s = sc.nextLine();
    String result = firstNonRepeating(s);
    System.out.println("Result: "+result);
    sc.close();
  }
}