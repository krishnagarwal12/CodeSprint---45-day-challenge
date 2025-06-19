import java.util.*;
public class packetNesting {
  public static int minPacketsToSmuggle(int packets[]) {
    Arrays.sort(packets);
    Map<Integer, Integer> freqMap = new HashMap<>();
    for(int p : packets) {
      freqMap.put(p, freqMap.getOrDefault(p,0) + 1);
    }

    int maxCount = 0;
    for(int count : freqMap.values()) {
      maxCount = Math.max(maxCount, count);
    }
    return maxCount;
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of packets:");
    int n = sc.nextInt();
    int packets[] = new int[n];
    System.out.println("Enter the highness value of each packet:");
    for(int i=0; i<n; i++) {
      packets[i] = sc.nextInt();
    }

    System.out.println("Output: " + minPacketsToSmuggle(packets));
    sc.close();
  }
}