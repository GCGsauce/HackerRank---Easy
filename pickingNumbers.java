import java.util.List;
import java.util.ArrayList;

public class pickingNumbers{
	
	public static int pickingNumbers(List<Integer> a) {

		int[] x = new int[100]; //initialize an array of size 100
		int maxNumber = -1; 
		
		for(int i = 0; i < a.size(); i++){
			//each integer i can belong to two different groups
			//a group with i and i-1, or i and i+1

			x[a.get(i)]++; 

			if(a.get(i)-1 >= 0 && 
				x[a.get(i)-1] + x[a.get(i)] > maxNumber){
				maxNumber = x[a.get(i)-1] + x[a.get(i)]; 
			}

			if(a.get(i)+1 < a.size() && x[a.get(i)+1] + 
				x[a.get(i)] > maxNumber){
				maxNumber = x[a.get(i)+1] + x[a.get(i)];
			}
		}
		return maxNumber;
    }

    public static void main(String[] args){
    	List<Integer> l = new ArrayList<>();
    	l.add(4); l.add(6);l.add(5);l.add(3);l.add(3);l.add(1);
    	System.out.println(pickingNumbers(l));
    }
}







