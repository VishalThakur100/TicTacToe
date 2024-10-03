import java.util.Arrays;
import java.util.Stack;

public class TwoStackGame {
    public static void main(String[] args) {
       int[] arr1=new int[]{4,2,4,6,1};
       int[] arr2=new int[]{2,1,8,5};
       int sum=10;
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(twoStack(arr1,arr2,sum));
    }
    private static int twoStack(int[] arr1, int [] arr2, int sum) {
        return NoOfMoves(sum,arr1,arr2,0,0)-1;
    }
    private static int NoOfMoves(int sum,int [] arr1, int [] arr2, int x, int count) {
        if(x>sum){
            return count;
        }
        if (arr1.length==0 || arr2.length==0) {
            return count;
        }
        int ans1=NoOfMoves(sum,Arrays.copyOfRange(arr1,1, arr1.length),arr2,x+arr1[0],count+1);
        int ans2=NoOfMoves(sum,arr1,Arrays.copyOfRange(arr2,1,arr2.length),x+arr2[0],count+1);
        return Math.max(ans1,ans2);
    }

}
