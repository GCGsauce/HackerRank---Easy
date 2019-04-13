public class MiniMax{

    public static void miniMaxSum(int[] arr){
        int min = arr[0];
        int max = arr[0];
        long sum = arr[0];

        for(int i = 1; i < arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            } else if(arr[i] > max){
                max = arr[i];
            }
            sum += arr[i];
        }
        System.out.println((sum-max) + " " + (sum-min));
    }

    public static void main(String[] args){
        miniMaxSum(new int[]{256741038, 623958417, 467905213, 714532089, 938071625});
    }        //System.out.println("sum: " + sum + " min: " + min);

}