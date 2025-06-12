import java.util.*;
public class festivalBanner {
  public static String recognizeString(String str) {
    int hash[] = new int[26];
    for(int i=0; i<str.length(); i++) {
      hash[str.charAt(i) - 'a']++;
    }
    int max=0, letter=0;
    for(int i=0; i<hash.length; i++) {
      if(hash[i] > max) {
        max = hash[i];
        letter = i;
      }
    }

    if(max > (str.length()+1)/2) {
      return "";
    }
    char res[] = new char[str.length()];

    int idx = 0;
    while(hash[letter]-- > 0) {
      res[idx] = (char) (letter + 'a');
      idx = idx+2;
    }

    for(int i=0; i<hash.length; i++) {
      while(hash[i]-- > 0) {
        if(idx >=res.length) {
          idx = 1;
        }
        res[idx] = (char) (i+'a');
        idx = idx+2;
      }
    }
    return String.valueOf(res);
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter your string:");
    String str = sc.nextLine();
    String res = recognizeString(str);
    System.out.println("Output: "+res);
    sc.close();
  }
}