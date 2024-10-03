import java.util.Arrays;

public class MaximalRectangle {
    public static void main(String[] args) {
      char[][] matrix = {{'1','0','1'},
              {'0','1','0'},
              {'1','0','1'}};
        int[][] res=maximalRectangle(matrix);
//       for(int[] arr:res){
//           System.out.println(Arrays.toString(arr));
//       }
        int result=0;
//       for(int[] arr:res){
//           result=Math.max(result,maxArea(arr);
//       }
//       return result;
    }
//    public static int maxArea(int[] arr){
//
//
//    }
    public static int[][] maximalRectangle(char[][] matrix) {
        int[][] num=new int[matrix.length][matrix[0].length];
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[0].length; j++) {
                int temp=0;
                for (int k = 0; k <= i; k++) {
                    if(matrix[k][j]=='1') num[k][j]=++temp;
                    else {
                        num[k][j] = 0;
                        temp=0;
                    }
                }
            }
        }
        return num;
    }
}
