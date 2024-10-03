public class CelebrityProblem {
    public static void main(String[] args) {
        int[][] mat = {
                {0, 1, 1},
                {0, 0, 1},
                {1, 0, 0}
        };
        System.out.println(celebrity2(mat));
    }

    private static int celebrity2(int[][] mat) {
        int n = mat.length;
        int start=0;
        int end=n-1;
        while(start<end){
            if(mat[start][end]==1){
                start++;
            } else if (mat[end][start]==1) {
                end--;
            }else{
                start++;
                end--;
            }
        }
        if(start>end) return -1;
        for (int i = 0; i < n; i++) {
            if(i==start){
                continue;
            }
            if(mat[start][i]==0 && mat[i][start]==1);
            else return -1;
        }
        return start;
    }


    // Function to find if there is a celebrity in the party or not.
//    public static int celebrity(int mat[][]) {
//        // code here
//        int n = mat[0].length;
//        int[] knowMe = new int[n];
//        int[] iKnow = new int[n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < mat[0].length; j++) {
//                if(i==j){
//                    continue;
//                }
//                if (mat[i][j] == 1) {
//                    knowMe[j]++;
//                    iKnow[i]++;
//                }
//            }
//        }
//        for (int i = 0; i < n; i++) {
//            if(knowMe[i] == n-1 && iKnow[i] == 0){
//                return i;
//            }
//        }
//        return -1;
//    }
}
