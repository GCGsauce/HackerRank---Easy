import java.lang.Math;

public class Anagram{
	
	// Complete the anagram function below.
    public static int anagram(String s){
        if(1.0*s.length()/2 % 1 == 0){ 
            int[] firstHalf = new int[26];
            int[] secondHalf = new int[26];
            for(int i = 0, j = s.length()-1; i < s.length()/2; i++, j--){
                firstHalf[(int)s.charAt(i)-97] += 1;
                secondHalf[(int)s.charAt(j)-97] += 1; 
            }
            int counter = 0;
            for(int i = 0; i < 26; i++){
                if(firstHalf[i] != secondHalf[i]){
                    counter+=Math.abs(firstHalf[i]-secondHalf[i]); 
                }
            }
            System.out.println(counter);
            return counter/2; 
        } return -1; 
    }

	public static void main(String[] args){
		System.out.println(anagram("xyyx"));
	}
}