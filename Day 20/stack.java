import java.util.*;
public class stack {

  public static void calculate(int arr[]) {
    Stack<Integer> s = new Stack<>();
    int nextGreater[] = new int[arr.length];
    int nextSmaller[] = new int[arr.length];

    //nextGreater
    for(int i=arr.length-1; i>=0; i--) {
      while(!s.isEmpty() && arr[s.peek()] <= arr[i]) {
        s.pop();
      }
      if(s.isEmpty()) {
        nextGreater[i] = -1;
      }
      else {
        nextGreater[i] = s.peek();
      }
      s.push(i);
    }

    s.clear();

    //nextSmaller
    for(int i=arr.length-1; i>=0; i--) {
      while(!s.isEmpty() && arr[s.peek()] >= arr[i]) {
        s.pop();
      }
      if(s.isEmpty()) {
        nextSmaller[i] = -1;
      }
      else {
        nextSmaller[i] = arr[s.peek()];
      }
      s.push(i);
    }

    //result
    int result[] = new int[arr.length];
    for(int i=0; i<arr.length; i++) {
      if(nextGreater[i] == -1) {
        result[i] = -1;
      }
      else {
        result[i] = nextSmaller[nextGreater[i]];
      }
      System.out.print(result[i]+" ");
    }
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number of elements in the array: ");
    int n = sc.nextInt();
    sc.nextLine();
    int arr[] = new int[n];
    System.out.println("Enter the elements:");
    for(int i=0; i<n; i++) {
      arr[i] = sc.nextInt();
    }
    System.out.println("Output:");
    calculate(arr);
    sc.close();
  }
}
