import java.util.*;
public class SecretCodewordChallenge {
  private static int getBitmask(String word) {
    int mask = 0;
    for(char c : word.toCharArray()) {
      mask |= 1 << (c - 'a');
    }
    return mask;
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of codewords:");
    int n = sc.nextInt();
    sc.nextLine();

    String words[] = new String[n];
    int bitmasks[] = new int[n];
    int lengths[] = new int[n];

    System.out.println("Enter the codewords:");
    for(int i=0; i<n; i++) {
      words[i] = sc.nextLine();
      bitmasks[i] = getBitmask(words[i]);
      lengths[i] = words[i].length();
    }

    int maxStrength = 0;

    for(int i=0; i<n; i++) {
      for(int j=i+1; j<n; j++) {
        if((bitmasks[i] & bitmasks[j]) == 0) {
          int product = lengths[i] * lengths[j];
          maxStrength = Math.max(maxStrength, product);
        }
      }
    }
    System.out.println(maxStrength);
    sc.close();
  }
}