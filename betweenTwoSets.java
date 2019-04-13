public class betweenTwoSets{
    public static int getTotalX(int[] a, int[] b) {
        int gcdB = gcd(b);
        int lcmA = lcm(a);
        //test to see how many times the lcm of a divides into the gcd of b
        int count = 0;
        //all other shared factors between all elements of array b must
        //be a factor of gcdB. e.g. 20,30. 10 is gcd, 5 is a factor 
        //of 10 and also divides both elements. 
        //

        //if we find the lcm of a set, we can see if gcdB divides
        //any of those multiples of the lcm.
        for(int i = lcmA, j = 1; i <= gcdB; j++, i = lcmA*j){
            if(gcdB % i == 0){
                count++; 
            }
        }
        return count; 
    }

    //get greatest common denominator for a and b
    private static int gcd(int a, int b) {
        while (b > 0) {
            int temp = b;
            b = a % b; // % is remainder
            a = temp;
        }
        return a;
    }

    private static int gcd(int[] input) {
        int result = input[0];
        for (int i = 1; i < input.length; i++) {
            result = gcd(result, input[i]);
        }
        return result;
    }

    public static int lcm(int a, int b){
        return (a*b)/(gcd(a,b));
    }

    public static int lcm(int[] a){
        int result = a[0];
        for(int i = 0; i < a.length; i++){
            result = lcm(result, a[i]);
        } 
        return result;
    }

    public static void main(String[] args){
        System.out.println(getTotalX(new int[]{2,4}, new int[]{16,32,96}));
    }
}