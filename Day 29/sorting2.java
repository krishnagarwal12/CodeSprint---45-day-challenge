import java.util.*;
public class sorting2 {
  public static String canCure(int vaccines[], int patients[]) {
    Arrays.sort(vaccines);
    Arrays.sort(patients);

    for(int i=0; i<patients.length; i++) {
      if(vaccines[i] <= patients[i]) {
        return "no";
      }
    }
    return "yes";
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number of vaccines (and patients): ");
    int n = sc.nextInt();
    int vaccines[] = new int[n];
    int patients[] = new int[n];

    System.out.println("Enter the midichlorians count of each vaccine batch:");
    for(int i=0; i<n; i++) {
      vaccines[i] = sc.nextInt();
    }

    System.out.println("Enter the midichlorians count of each patient:");
    for(int i=0; i<n; i++) {
      patients[i] = sc.nextInt();
    }

    System.out.println("Output: "+canCure(vaccines, patients));
    sc.close();
  }
}