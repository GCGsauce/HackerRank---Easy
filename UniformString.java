import java.util.Map;
import java.util.HashMap; 
import java.lang.Math;
import java.util.List; 
import java.util.ArrayList; 
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;

public class UniformString{

    public static String[] weightedUniformStrings(String s, int[] queries) {

        String[] k = new String[queries.length];
        Map<Character, Integer> m = uniformStringMap(s);

        //now compare the queries with the map generated
        for(int i = 0; i < queries.length; i++){

            List<Character> l = getPossibleCombinations(queries[i]);
            boolean found = false; 
            for(Character c: l){
                if(m.containsKey(c) == true){
                    int charNum = (((int)c) - 96);
                    long amt = m.get(c) * charNum; //if queries[i] is a multiple of amt

                    if(queries[i] <= amt){
                        k[i] = "Yes";
                        found = true;
                        break; 
                    }
                }
            }
            if(found == false){
                k[i] = "No";
            }
        } 
        return k; 
    }

    public static Map<Character, Integer> uniformStringMap(String s){
        Map<Character, Integer> m = new HashMap<>(); 
        int count = 1;
        char test = s.charAt(0);

        for(int i = 1; i < s.length(); i++){
            char letter = s.charAt(i);

            if(test != letter){ //we want to add the char test to the map        
                if(m.containsKey(test) == true){
                    if(m.get(test) < count){
                        m.put(test, count); 
                    }
                } else{
                    m.put(test, count);
                }
                count = 1; //counter for the new letter
                test = letter; 
            } else{
                count++; 
            }
        } 
        if(m.containsKey(test) == true){
            if(m.get(test) < count)
                m.put(test, count);
        } else{m.put(test,count);}
        return m; 
    }

    public static List<Character> getPossibleCombinations(int n){ //given n, give all the potential combinations of letters + counts 
        double maxIteration = Math.sqrt(n) > 26? 26 : Math.sqrt(n);
        List<Character> possibleChars = new ArrayList<>();
        for(int i = 1; i <= maxIteration; i++){
            if(n % i == 0){
                possibleChars.add((char)(96+i));

                if((n/i) <= 26 && (n/i) != Math.sqrt(n)){
                    possibleChars.add((char)(96+(n/i)));
                }
            }
        } 
        return possibleChars; 
    }

    public static void main(String[] args){

        String content = ""; 
        try{
            content = new String(Files.readAllBytes(Paths.get("testArray.txt")), "UTF-8");
        } catch(IOException e){
            System.out.println("BOOO");
        }

        String strLine, strLine2;
        String[] s = new String[45748];
        int[] k = new int[45748];
        try{
            FileInputStream fstream = new FileInputStream("yesno.txt");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            FileInputStream fstream2 = new FileInputStream("nums.txt");
            DataInputStream in2 = new DataInputStream(fstream2);
            BufferedReader br2 = new BufferedReader(new InputStreamReader(in2));

            int i = 0;
            while ((strLine = br.readLine()) != null && (strLine2 = br2.readLine())!= null){
            // Print the content on the console
                s[i] = strLine;
                k[i] = Integer.parseInt(strLine2);
                i++;
            }
        } catch(IOException e){}

        String[] act = weightedUniformStrings(content, k);
        //printArray(act);
        printMap(uniformStringMap(content));
        //printList(getPossibleCombinations(16));
        // //System.out.println("YAK: " + act[0]);
        // for(int i = 0; i < 45748; i++){
        //     if(act[i].equals(s[i]) == false && k[i]==133){
        //         System.out.println(k[i]);
        //         System.out.println(act[i] + " vs " + s[i]+" i: " + i);
        //     }
        // }

        printList(getPossibleCombinations(133));
    }
}