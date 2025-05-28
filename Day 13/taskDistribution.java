import java.util.*;

public class taskDistribution {

  static class Node {
    int val;
    Node next;

    Node(int val) {
      this.val = val;
      this.next = null;
    }
  }
  
  public Node[] splitListToParts(Node head, int k) {
    //find size
    Node temp = head;
    int size = 0;
    while(temp != null) {
      size++;
      temp = temp.next;
    }
    Node result[] = new Node[k];
    temp = head;
    int base = size/k;
    int extra = size%k;
    
    for(int i=0; i<k; i++) {
       if(temp == null) {
         result[i] = null;
         continue;
       }
      Node currHead = temp;
      Node prev = null;
      int len = 0;
      while(temp!=null && len<base) {
        prev = temp;
        temp = temp.next;
        len++;
      }
      if(extra>0) {
        prev = temp;
        temp = temp.next;
        extra--;
      }
      if(prev != null) {
        Node nextPart = prev.next;
        prev.next = null;
        temp = nextPart;
      }
      result[i] = currHead; //insert head
    }
    return result;
  }

  public static void printParts(Node[] parts) {
    for(int i=0; i<parts.length; i++) {
      Node curr = parts[i];
      List<Integer> list = new ArrayList<>();
      while(curr != null) {
        list.add(curr.val);
        curr = curr.next;
      }
      System.out.print(list.toString());
      if(i < parts.length - 1) {
        System.out.print(" , ");
      }
    }
    System.out.println();
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    String values[] = sc.nextLine().split(" ");
    Node head = null, tail = null;
    for(String val : values) {
      int num = Integer.parseInt(val);
      Node newNode = new Node(num);
      if(head == null) {
        head = newNode;
        tail = newNode;
      }
      else {
        tail.next = newNode;
        tail = newNode;
      }
    }
    
    System.out.print("Number of parts: ");
    int k = sc.nextInt();

    taskDistribution td = new taskDistribution();
    Node[] result = td.splitListToParts(head,k);
    printParts(result);
  }
}