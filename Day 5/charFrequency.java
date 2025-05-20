import java.util.*;
public class charFrequency {

  public static void checkEmotionalBalance(String s) {
    int freq[] = new int[26];
    
    //count frequency of each character
    for(int i=0; i<s.length(); i++) {
      char c = s.charAt(i);
      freq[c-'a']++;
    }

    //find first non-zero frequency
    int commFreq = 0;
    for(int i=0; i<26; i++) {
      if(freq[i]!=0) {
        commFreq = freq[i];
        break;
      }
    }

    //check
    for(int i=0; i<26; i++) {
      if(freq[i]!=0 && freq[i]!=commFreq) {
        System.out.println("Aashriya wonders: These thoughts were scattered.");
        return;
      }
    }
    System.out.println("Aashriya smiles: Emotional balance found.");
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter your string (in lowercase): ");
    String s = sc.nextLine();
    checkEmotionalBalance(s);
    sc.close();
  }
}