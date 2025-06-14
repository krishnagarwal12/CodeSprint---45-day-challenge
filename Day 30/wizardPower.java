import java.util.*;
public class wizardPower {
  public static void calculateMana(int merlin[], int morgana[]) {
    Arrays.sort(merlin);
    Arrays.sort(morgana);
    int mana = 0;

    int minPower = morgana[morgana.length-1] + 1;

    for(int i=0; i<merlin.length; i++) {
      if(merlin[i] < minPower) {
        mana+= minPower - merlin[i];
      }
      else {
        break;
      }
    }
    System.out.println("Total mana needed = " + mana);
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number of Merlin's spells: ");
    int n = sc.nextInt();
    int merlin[] = new int[n];
    System.out.println("Enter Merlin's spell power levels:");
    for(int i=0; i<n; i++) {
      merlin[i] = sc.nextInt();
    }

    System.out.print("Enter the number of Morgan's spells: ");
    int m = sc.nextInt();
    int morgana[] = new int[m];
    System.out.println("Enter Morgana's spell power levels:");
    for(int i=0; i<m; i++) {
      morgana[i] = sc.nextInt();
    }

    calculateMana(merlin, morgana);
    sc.close();
  }
}