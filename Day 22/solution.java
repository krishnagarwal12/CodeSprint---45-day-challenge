import java.util.*;
public class solution {
   public static int countStudents(int students[], int sandwiches[]) {
     int circularSandwich = 0;
     int squareSandwich = 0;

     for(int i=0; i<students.length; i++) {
       if(students[i] == 0) {
         circularSandwich++;
       }
       else {
         squareSandwich++;
       }
     }

     for(int i=0; i<sandwiches.length; i++) {
       if(sandwiches[i]==0 && circularSandwich==0) {
         return squareSandwich;
       }
       if(sandwiches[i]==1 && squareSandwich==0) {
         return circularSandwich;
       }
       if(sandwiches[i]==0) {
         circularSandwich--;
       }
       else {
         squareSandwich--;
       }
     }
     return 0;
   }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number of students and sandwiches: ");
    int n = sc.nextInt();
    sc.nextLine();
    int students[] = new int[n];
    int sandwiches[] = new int[n];

    System.out.println("Enter the student preferences:");
    for(int i=0; i<n; i++) {
      students[i] = sc.nextInt();
    }

    System.out.println("Enter the sandwich stack:");
    for(int i=0; i<n; i++) {
      sandwiches[i] = sc.nextInt();
    }

    System.out.println("Number of students unable to eat = "+countStudents(students,sandwiches));
    sc.close();
  }
}