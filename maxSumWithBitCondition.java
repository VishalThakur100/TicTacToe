public class maxSumWithBitCondition {
    public static void main(String[] args) {
        int[] arr={3,8,5,10};
        System.out.println(maxSum(arr,1));
    }
    public static int maxSum(int[] arr,int x) {
        int maxSet=Integer.MIN_VALUE;
        int maxUnSet=Integer.MAX_VALUE;
        for(int num:arr){
            if((num & (1<<x))!=0){
                maxSet=Math.max(maxSet,num);
            }else{
                maxUnSet=Math.min(maxUnSet,num);
            }
        }
        if (maxSet==Integer.MIN_VALUE || maxUnSet==Integer.MIN_VALUE){
            return -1;
        }
        return maxSet+maxUnSet;
    }
}
