import java.util.*;
public class findSlips {
  public static int countSlips(String moves) {
    HashSet<String> visited = new HashSet<>();
    int x = 0, y = 0;
    int slips = 0;

    visited.add(x + "," + y);

    for(char move : moves.toCharArray()) {
      switch(move) {
        case 'L':
          x--;
          break;
        case 'R':
          x++;
          break;
        case 'U':
          y++;
          break;
        case 'D':
          y--;
          break;
      }

      String position = x + "," + y;
      if(visited.contains(position)) {
        slips++;
      }
      else {
        visited.add(position);
      }
    }
    return slips;
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter your string:");
    String moves = sc.nextLine();
    System.out.println("Number of slips = "+countSlips(moves));
    sc.close();
  }
}