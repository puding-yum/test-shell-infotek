package task4;

public class ReverseString {
    public void reverse(String str){
        String[] listStr = str.split(" ");
        String[] result = new String[listStr.length];

        for(int i=0; i<listStr.length; i++){
            char[] currentWord = listStr[i].toCharArray();
            for(int j=0; j<currentWord.length/2; j++){
                char temp = currentWord[j];
                currentWord[j] = currentWord[currentWord.length-j-1];
                currentWord[currentWord.length-j-1] = temp;
            }
            result[i] = String.valueOf(currentWord);
        }

        for(int i=0; i<listStr.length; i++){
            System.out.print(listStr[i] + " ");
        }

        System.out.println("");

        for(int i=0; i<result.length; i++){
            System.out.print(result[i] + " ");
        }
    }
}
