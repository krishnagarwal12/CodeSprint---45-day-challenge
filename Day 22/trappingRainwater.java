import java.util.*;
public class trappingRainwater {

  public static void trappedWater(int heights[]) {
    int n = heights.length;
    int l = 0, r = n-1;
    int lmax = 0, rmax = 0;
    int ans = 0;

    while(l < r) {
      lmax = Math.max(lmax, heights[l]);
      rmax = Math.max(rmax, heights[r]);

      if(lmax < rmax) {
        ans+= lmax - heights[l];
        l++;
      }
      else {
        ans+= rmax - heights[r];
        r--;
      }
    }
    System.out.println("Total units of rainwater that can be trapped = "+ans);
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number of buildings: ");
    int n = sc.nextInt();
    sc.nextLine();
    System.out.println("Enter the heights of the buildings:");
    int heights[] = new int[n];
    for(int i=0; i<n; i++) {
      heights[i] = sc.nextInt();
    }
    trappedWater(heights);
    sc.close();
  }
}
