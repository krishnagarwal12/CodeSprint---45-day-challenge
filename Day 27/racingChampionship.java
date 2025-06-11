import java.util.*;
public class racingChampionship {

  public static String[] findRelativeRanks(int score[]) {
    int n = score.length;
    String result[] = new String[n];

    //create a map to store the original indices of score
    Map<Integer, Integer> indexMap = new HashMap<>();
    for(int i=0; i<n; i++) {
      indexMap.put(score[i], i);
    }

    //sort the scores in descending order
    Arrays.sort(score);
    for(int i=0; i<n/2; i++) {
      int temp = score[i];
      score[i] = score[n-i-1];
      score[n-i-1] = temp;
    }

    //assign ranks 
    for(int i=0; i<n; i++) {
      int originalIndex = indexMap.get(score[i]);
      if(i==0) {
        result[originalIndex] = "Gold Medal";
      }
      else if(i==1) {
        result[originalIndex] = "Silver Medal";
      }
      else if(i==2) {
        result[originalIndex] = "Bronze Medal";
      }
      else {
        result[originalIndex] = String.valueOf(i+1);
      }
    }
    return result;
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter the number of participants: ");
    int n = sc.nextInt();

    int score[] = new int[n];
    System.out.println("Enter the scores:");
    for(int i=0; i<n; i++) {
      score[i] = sc.nextInt();
    }

    String ranks[] = findRelativeRanks(score);
    System.out.println("Relative ranks: "+Arrays.toString(ranks));

    sc.close();
  }
}