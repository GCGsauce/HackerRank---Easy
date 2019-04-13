public class appendAndDelete{

	public static String appendAndDelete(String s, String t, int k){
		int minChanges = calcMinAmtOfChanges(s,t); 
		//if k is greater than min changes, then we need to determine
		//if we can get t with exactly k changes
		if(k < minChanges){
			return "No";
		} else{
			if(k >= s.length() + t.length()){
				return "Yes";
			} else if((1.0*(k-minChanges)/2) % 1 != 0){
				return "No";
			} else{
				return "Yes";
			}
		}
	}

	public static int calcMinAmtOfChanges(String s, String t){
		int i;
		int sLength= s.length(); int tLength = t.length();
		for(i = 0; i < sLength; i++){
			//s could be longer than t
			if(i == tLength){
				return sLength-tLength;
			}
			if(s.charAt(i) != t.charAt(i)){
				int amtToDelete = sLength - i;
				int amtToAdd = tLength - i;
				return amtToDelete + amtToAdd;
			}
		}
		return t.length()-s.length(); //need to add this amt of chars to s
	}

	public static void main(String[] args){
		System.out.println(appendAndDelete("y", "yu", 2));
	}
}