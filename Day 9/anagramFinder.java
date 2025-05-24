import java.util.*;
public class anagramFinder {

  public static List<Integer> findAnagramIdx(String logStream, String pattern) {
    List<Integer> result = new ArrayList<>();
    if(logStream.length() < pattern.length()) {
      return result;
    }

    int patternFreq[] = new int[26];
    int windowFreq[] = new int[26];
    int pLen = pattern.length();

    for(int i=0; i<pLen; i++) {
      patternFreq[pattern.charAt(i) - 'a']++;
      windowFreq[logStream.charAt(i) - 'a']++;
    }
    if(Arrays.equals(patternFreq, windowFreq)) {
      result.add(0);
    }
    for(int i =pLen; i<logStream.length(); i++) {
      windowFreq[logStream.charAt(i) - 'a']++;
      windowFreq[logStream.charAt(i-pLen) - 'a']--;

      if(Arrays.equals(patternFreq, windowFreq)) {
        result.add(i-pLen+1);
      }
    }
    return result;
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the continuous stream of log data: ");
    String logStream = sc.nextLine();
    System.out.print("Enter the uspicious pattern to be checked: ");
    String pattern = sc.nextLine();

    List<Integer> idx = findAnagramIdx(logStream, pattern);
    System.out.println(idx);
    sc.close();
  }
}