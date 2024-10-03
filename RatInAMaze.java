import java.util.ArrayList;

public class RatInAMaze {
    public static void main(String[] args) {
        int[][] board = {
                {1, 0, 0},
                {1, 1, 0},
                {1, 1, 0},
                {0, 1, 1}
        };
        int[][] visited = new int[board.length][board[0].length];
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(findPath(board));
    }

    public static ArrayList<String> findPath(int[][] mat) {
        // Your code here
        if(mat[0][0]==0) {
            ArrayList<String> ans = new ArrayList<>();
            ans.add(String.valueOf(-1));
            return ans;
        }
        int[][] visited = new int[mat.length][mat[0].length];
        return RatInAMaze(0, 0, mat, visited, "");

    }

    public static ArrayList<String> RatInAMaze(int i, int j, int[][] board, int[][] visited, String s) {
        //    base case
        if (i == board.length - 1 && j == board[0].length - 1) {
            ArrayList<String> result = new ArrayList<>();
            result.add(s);
            return result;

        }
        ArrayList<String> ans = new ArrayList<>();
        //   down
        if (i+1 < board.length  && j < board[0].length && board[i+1][j] == 1 && visited[i+1][j] == 0) {
            visited[i][j] = 1;
            ans.addAll(RatInAMaze(i + 1, j, board, visited, s + "D"));
            visited[i][j] = 0;
        }
        //  left
        if (i < board.length  && j-1 >= 0 && board[i][j-1] == 1 && visited[i][j-1] == 0) {
            visited[i][j] = 1;
            ans.addAll(RatInAMaze(i, j - 1, board, visited, s + "L"));
            visited[i][j] = 0;
        }
        //  right
        if (i < board.length  && j+1 < board[0].length  && board[i][j+1] == 1 && visited[i][j+1] == 0) {
            visited[i][j] = 1;
            ans.addAll(RatInAMaze(i, j + 1, board, visited, s + "R"));
            visited[i][j] = 0;
        }
        //   up
        if (i-1 >= 0 && j < board[0].length && board[i-1][j] == 1 && visited[i-1][j] == 0) {
            visited[i][j] = 1;
            ans.addAll(RatInAMaze(i - 1, j, board, visited, s + "U"));
            visited[i][j] = 0;
        }
        return ans;
    }
}
