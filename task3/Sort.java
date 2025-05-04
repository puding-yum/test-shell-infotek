package task3;

public class Sort {
    public void sortNumbers(int[] numbers){
        
        for(int i=0; i<numbers.length; i++){
            System.out.print(numbers[i] + " ");
        }

        for(int i=0; i<numbers.length-1; i++){
            for(int j=i+1; j>0; j--){
                if(numbers[j] < numbers[j-1]){
                    int temp = numbers[j];
                    numbers[j] = numbers[j-1];
                    numbers[j-1] = temp;
                }
            }
        }

        System.out.println("");
        for(int i=0; i<numbers.length; i++){
            System.out.print(numbers[i] + " ");
        }
    }
}
