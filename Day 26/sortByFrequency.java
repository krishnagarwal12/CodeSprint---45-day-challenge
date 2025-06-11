import java.util.*;
public class sortByFrequency {

  public static List<Integer> sortByFrequency(int arr[]) {
    //create frequency map
    Map<Integer, Integer> freqMap = new HashMap<>();
    for(int num : arr) {
      freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
    }

    //create a list from array
    List<Integer> result = new ArrayList<>();
    for(int num : arr) {
      result.add(num);
    }

    //sorting
    result.sort((a, b) -> {
      int freqA = freqMap.get(a);
      int freqB = freqMap.get(b);
      if(freqA != freqB) {
        return freqB - freqA;
      }
      return a-b;
    });

    return result;
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int arr[] = new int[n];
    for(int i=0; i<n; i++) {
      arr[i] = sc.nextInt();
    }

    List<Integer> result = sortByFrequency(arr);
    for(int num : result) {
      System.out.print(num + " ");
    }
    sc.close();
  }
}