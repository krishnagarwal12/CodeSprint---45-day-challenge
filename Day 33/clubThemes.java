import java.util.*;
public class clubThemes {

  public static boolean canFormClubs(int themes[], int k) {
    Map<Integer, Integer> themeCount = new HashMap<>();
    for(int i=0; i<themes.length; i++) {
      themeCount.put(themes[i], themeCount.getOrDefault(themes[i], 0) + 1);
    }

    int clubsFormed = 0;
    for(int count : themeCount.values()) {
      clubsFormed += count / k;
    }
    return clubsFormed >= 2;
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter the number of students and themes per club:");
    int n = sc.nextInt();
    int k = sc.nextInt();

    System.out.println("Enter the themes for each student:");
    int themes[] = new int[n];
    for(int i=0; i<n; i++) {
      themes[i] = sc.nextInt();
    }

    if(canFormClubs(themes, k)) {
      System.out.println("YES");
    }
    else {
      System.out.println("NO");
    }

    sc.close();
  }
}