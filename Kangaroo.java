public class Kangaroo{
	
	public static String kangaroo(int x1, int v1, int x2, int v2) {
		//system of equations, where x1+v1*x = x2 + v2*x
		//calculate whether there is an integer x that equates both
		double x = 1.0*(x2-x1)/(v1-v2);
		if(x % 1 == 0 && x >= 0){//is the double x, an integer(no digits after dp)
			return "YES";
		} return "NO";
    } //also can check if  (x2-x1)%(v1-v2) == 0

    public static void main(String[] args){
    	System.out.println(kangaroo(0,3,4,2));
    }
}