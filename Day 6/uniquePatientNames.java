import java.util.*;
public class uniquePatientNames {

  public static boolean isVowel(char c) {
    if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u') {
      return true;
    }
    else {
      return false;
    }
  }
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number of patient entries for the day: ");
    int n = sc.nextInt();
    sc.nextLine();
    ArrayList<String> vowelPatients = new ArrayList<>();
    System.out.println("Enter the patient names: ");
    for(int i=0; i<n; i++) {
      String name = sc.nextLine();
      char ch = name.charAt(0);
      if(isVowel(ch) && !vowelPatients.contains(name)) {
        vowelPatients.add(name);
      }
    }

    //print
    System.out.println("Result:");
    System.out.println(vowelPatients.size());
    for(int i=0; i<vowelPatients.size(); i++) {
      System.out.println(vowelPatients.get(i));
    }
    sc.close();
  }
}