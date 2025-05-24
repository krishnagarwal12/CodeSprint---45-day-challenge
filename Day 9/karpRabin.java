import java.util.*;
public class karpRabin {

  public static List<Integer> findExactMatches(String text, String pattern) {
    List<Integer> result = new ArrayList<>();
    int n = text.length(), m = pattern.length();
    if(m>n) {
      return result;
    }
    int base = 256;
    int mod = 1_000_000_007;

    long patternHash = 0;
    long textHash = 0;
    long power = 1;

    for(int i=0; i<m-1; i++) {
      power = (power*base)%mod;
    }
    for(int i=0; i<m; i++) {
      patternHash = (patternHash * base + pattern.charAt(i)) % mod;
      textHash = (textHash * base + text.charAt(i)) % mod;
    }
    for(int i=0; i<=n-m; i++) {
      if(patternHash == textHash) {
        if(text.substring(i, i+m).equals(pattern)) {
          result.add(i);
        }
      }
      if(i<n-m) {
        textHash = (textHash - text.charAt(i)*power) % mod;
        textHash = (textHash + mod) % mod;
        textHash = (textHash * base + text.charAt(i+m)) % mod;
      }
    }
    return result;
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the text: ");
    String text = sc.nextLine();
    System.out.println("Enter the pattern:");
    String pattern = sc.nextLine();
    List<Integer> matches = findExactMatches(text, pattern);
    System.out.println(matches);
    sc.close();
  }
}