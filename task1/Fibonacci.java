package task1;

public class Fibonacci {
    public void generateFibonacci(int n){
        if(n < 1){
            return;
        }
        
        long prev2 = 0;
        System.out.print(prev2);
        if(n == 1){
            return;
        }

        long prev1 = 1;
        System.out.print(" " + prev1);
        if(n == 2){
            return;
        }

        for(int i=2; i<=n; i++){
            long current = prev2 + prev1;        
            System.out.print(" " + ( + current));
            prev2 = prev1;
            prev1 = current;
        }
    }
}