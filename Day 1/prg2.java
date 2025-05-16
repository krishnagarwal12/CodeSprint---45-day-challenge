import java.util.Scanner;

public class prg2 {

    public static void count(int shots[]) {
        int good = 0, missed = 0;
        for(int i=0; i<shots.length; i++) {
            if(shots[i] >= 7) {
                good++;
            }
            else {
                missed++;
            }
        }
        System.out.println(good+" "+missed);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of shots: ");
        int n = sc.nextInt();
        int shots[] = new int[n];
        System.out.print("Enter the scores of each shot: ");
        for(int i=0; i<shots.length; i++) {
            shots[i] = sc.nextInt();
        }
        count(shots);
        sc.close();
    }
}
