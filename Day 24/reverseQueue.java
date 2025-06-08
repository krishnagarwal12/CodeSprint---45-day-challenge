import java.util.*;
public class reverseQueue {

  public static void reverseQueue(Queue<Integer> queue) {
    Stack<Integer> stack = new Stack<>();

    while(!queue.isEmpty()) {
      stack.push(queue.poll());
    }
    while(!stack.isEmpty()) {
      queue.offer(stack.pop());
    }
  }

  public static void main(String args[]) {
    Queue<Integer> queue = new LinkedList<>();
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number of citizens in the queue: ");
    int n = sc.nextInt();
    System.out.println("Enter the ID's of people in the queue:");
    for(int i=0; i<n; i++) {
      queue.offer(sc.nextInt());
    }

    System.out.println("Output:");
    reverseQueue(queue);
    System.out.println(queue);
    sc.close();
  }
}