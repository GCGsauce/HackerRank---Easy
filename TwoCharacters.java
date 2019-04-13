import java.util.Map; 
import java.util.HashMap;
import java.lang.Math;
import java.util.List;
import java.util.ArrayList;

//tough test case where if you have bebaa, beb is the longest but the aa might ruin trying to find the sequence
//sequence is only useless if we encounter a b before any other inner letter

//if its the wrong letter in the sequence and its the outer, then delete any seq that starts with b

//if its the wrong letter 

public class TwoCharacters{
    
    public static class Sequence{

        public class InnerLetterData{
            public final char iLetter;
            public char expectingLetter;
            public boolean deleteSequence = false;
            public String seq = "";

            public InnerLetterData(char i){
                iLetter = i;
                expectingLetter = iLetter;
                seq += Character.toString(oLetter);
            }
        }

        private final char oLetter;
        public boolean cannotBeSequenced = false;
        public char lastSeenLetter; 
        private Map<Character, InnerLetterData> letters = new HashMap<>();

        public Sequence(char x){
            oLetter = x;
        }

        public boolean containsInnerLetter(char y){ return letters.containsKey(y);}

        public void addInnerLetter(char y){
            if(y != oLetter){ //cannot have the same letters in a sequence
                letters.put(y, new InnerLetterData(y));
            }
        }

        public void updateAllSequences(char input){
            for(InnerLetterData i : letters.values()){
                isAlternating(i.iLetter, input);
            }
        }

        public void updateSingleSequence(char input){
            isAlternating(input, input);
        }

        private void isAlternating(char inner, char input){

        	InnerLetterData i = letters.get(inner);
	        if(i.expectingLetter == input){
	            i.seq += input;
	            i.expectingLetter =  input == oLetter? i.iLetter : oLetter;
	        } else {    //once we find a letter that doesn't fit the pattern, the entire sequence with oLetter as the outer is deleted
	          	i.seq = "";
	            i.deleteSequence = true;
	        }
        }

        public int getMaxSeqLength(){
            //if(unregisterSeq == true){return 0;}
            int max = 0;
            for(Character inner : letters.keySet()){
                if(letters.get(inner).seq.length() > max){
   	                System.out.println("OUTER: " + oLetter + " INNER: " + inner + " " + letters.get(inner).seq);
                    max = letters.get(inner).seq.length();
                }
            }
            return max;
        }
  	}

    public static int alternate(String s){

        Map<Character, Sequence> allData = new HashMap<>();

        for(int i = 0; i < s.length(); i++){

            Character letter = s.charAt(i);
            boolean newElem = false;

            if(allData.containsKey(letter) == false){ //add it to the dictionary
                //make sure to add a new sequence to every other existing entry in the dict; counting a new sequence with this new letter
                allData.put(letter, new Sequence(letter));
                newElem = true;
            }

            for(Character key : allData.keySet()){ //iterate through all the letter keys, and update their entries for the current letter

            	if(newElem == true && letter == key){
            		continue;
            	} else if(newElem == true){ //cannot add a sequence, where both letters are the same, e.g. [e,e]
                    allData.get(key).addInnerLetter(letter);
                }

                if(letter == key){ //update all entries, because a sequence [B, E] when we encounter a B in the string; every seq in B needs to be updated
                    allData.get(key).updateAllSequences(letter);

                }
                else{
                    if(allData.get(key).containsInnerLetter(letter)){
                        allData.get(key).updateSingleSequence(letter); //delete this sequence if its not an expected letter
                    }
                }
            }
        }

        int maxLength = 0;
        for(Character key : allData.keySet()){
            if(allData.get(key).getMaxSeqLength() > maxLength){
                maxLength = allData.get(key).getMaxSeqLength();
            }
        }
        if(maxLength <= 1){return 0;} return maxLength;
    }

    public static void main(String[] args){
        System.out.println(alternate("beabeab"));
        //asvkugfiugsalddlasguifgukvsa
    }
}