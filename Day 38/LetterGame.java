import java.util.*;
public class LetterGame {
  //main function to find the k-th letter
  public static char findKthCharacter(int k) {
    return findKthCharacterRecursive(k, 0);
  }

  //helper function
  public static char findKthCharacterRecursive(int k, int level) {
    //base case
    if(k == 1) {
      return 'a';
    }

    //find the smallest level where length of string >=k
    int len = (int)Math.pow(2,level);
    while(len < k) {
      level++;
      len = (int)Math.pow(2, level);
    }

    int half = len/2;

    if(k <= half) {
      return findKthCharacterRecursive(k, level-1);
    }
    else {
      char ch = findKthCharacterRecursive(k-half, level-1);
      return nextChar(ch);
    }
  }
  
  public static char nextChar(char ch) {
    return (ch == 'z') ? 'a' : (char)(ch+1);
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the position to check in the final string:");
    int k = sc.nextInt();

    char result = findKthCharacter(k);
    System.out.println("Output:" + result);
    sc.close();
  }
}
