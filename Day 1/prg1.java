import java.util.Scanner;

public class prg1 {

    public static boolean budget(int budget, int iceCreamPrices[]) {
        for(int i=0; i<iceCreamPrices.length; i++) {
            if(budget == iceCreamPrices[i]) {
                return true;
            }
        }
        return false;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the budget: ");
        int bdgt = sc.nextInt();
        System.out.print("Enter the number of ice-cream prices: ");
        int n = sc.nextInt(); 
        int iceCreamPrices[] = new int[n];
        System.out.print("Enter the different prices: ");
        for(int i=0; i<iceCreamPrices.length; i++) {
            iceCreamPrices[i] = sc.nextInt();
        }

        System.out.println(budget(bdgt, iceCreamPrices));
        sc.close();
    }
}