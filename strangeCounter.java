import java.lang.Math;
public class strangeCounter{
	
	public static long strangeCounter(long time){
		long minTime = 1;
		long cycleValue = 3; 
		while(true){
			long maxTime = minTime + cycleValue;
			if(time >= minTime && time < maxTime){
				return cycleValue-(time-minTime); 
			}
			cycleValue*=2; 
			minTime = maxTime; 
		}
	}

	//each column, the time and value index add up to the same value
	//e.g. first column = 1+3 = 4, second = 4+(3*2) = 10
	//sequence is 4,10,22,46,94
	//Sum of geometric series is Sn = 3*((1-r^n) / (1-r))
	//t = 3*((2^n-1)/(1))
	//t = 3(2^n-1)
	//t = 3*2^n - 3
	//(t+3)/3 = 2^n
	//n = log2(t+3/3)
	//to find the bucket that t belongs to, we can say that
	//it is the floor of log2(1.0*t+3/3)
	

	

	public static void main(String[] args){
		System.out.println(strangeCounter(1000000000000L));
	}
}
