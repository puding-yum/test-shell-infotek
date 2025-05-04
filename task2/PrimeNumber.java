package task2;

import java.util.HashSet;
import java.util.Set;

public class PrimeNumber {

    public void generatePrimeNumber(int n){
        Set<Integer> primeSet = new HashSet<>();
        primeSet.add(5);
        primeSet.add(7);

        if(n < 1){
            return;
        }
        
        System.out.print("2");
        if(n == 1){
            return;
        }

        System.out.print(" 3");
        if(n == 2){
            return;
        }

        int prime5 = 5;
        System.out.print(" " + prime5);
        if(n == 3){
            return;
        }

        int prime7 = 7;
        System.out.print(" " + prime7);
        if(n == 4){
            return;
        }

        boolean switcher = true;
        int counter5 = 1;
        int counter7 = 1;
        int currentPrime;

        for(int i=5; i<=n; i++){
            if(switcher){
                currentPrime = (prime5 + (6 * counter5));
                switcher = !switcher;
                counter5++;

                if(isPrime(currentPrime, primeSet)){
                    primeSet.add(currentPrime);
                    System.out.print(" " + currentPrime);
                }
            }else{
                currentPrime = (prime7 + (6 * counter7));
                switcher = !switcher;
                counter7++;
                
                if(isPrime(currentPrime, primeSet)){
                    primeSet.add(currentPrime);
                    System.out.print(" " + currentPrime);
                }
            }
        }
    }

    private boolean isPrime(int number, Set<Integer> primeSet){
        for(Integer prime:primeSet){
            if(number%prime == 0){
                return false;
            }
        }

        return true;
    }
}
