import java.util.*;
public class superPrimeNo {
  public static List<Integer> findSuperPrimes(int n) {
    List<Integer> primes = new ArrayList<>();
    boolean isPrime[] = new boolean[n+1];
    Arrays.fill(isPrime, true);
    isPrime[0] = isPrime[1] = false;

    for(int i=2; i*i<=n; i++) {
      if(isPrime[i]) {
        for(int j=i*i; j<=n; j+=i) {
          isPrime[j] = false;
        }
      }
    }

    //colleact all primes
    for(int i=2; i<=n; i++) {
      if(isPrime[i]) {
        primes.add(i);
      }
    }

    //find super primes
    List<Integer> superPrimes = new ArrayList<>();
    for(int i=0; i<primes.size(); i++) {
      if(isPrime[i+1]) {
        superPrimes.add(primes.get(i));
      }
    }
    return superPrimes;
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter the value of n:");
    int n = sc.nextInt();

    List<Integer> superPrimes = findSuperPrimes(n);
    System.out.println("Super Primes: " + superPrimes);

    sc.close();
  }
}