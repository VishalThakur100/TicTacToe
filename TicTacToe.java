import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        System.out.println("Game Begin");
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose your Sign 'X' or 'O'");
        char player = sc.next().charAt(0);
        boolean gameOver = false;
        while(!gameOver){
            printBoard(board);
            System.out.println("Player  " + player +"  enter row and column");
            int row=sc.nextInt();
            int col=sc.nextInt();
            System.out.println();
            if(board[row][col]==' '){
                board[row][col] = player;
                gameOver = haveWon(board,player);
                if (gameOver){
                    System.out.println("PLayer " + player + " won!");
                }else{
                   player=player=='X' ? 'O' : 'X';
                }
            }else{
                if(isFull(board)){
                    System.out.println("Game Draw");
                    gameOver=false;
                }
                System.out.println("Invalid move, Please Enter valid move ");
            }
        }
    }

    private static boolean isFull(char[][] board) {
        for (int row = 0; row < board.length; row++) {
           for (int col = 0; col < board[row].length; col++) {
               if (board[row][col]== ' '){
                   return false;
               }
           }
        }
        return true;
    }

    private static boolean haveWon(char[][] board, char player) {
        //   rows check
        for (int row = 0; row < board.length; row++) {
            if(board[row][0]==player && board[row][1]==player && board[row][2]==player){
                return true;
            }
        }
        //  columns check
        for (int col = 0; col < board.length; col++) {
            if(board[0][col]==player && board[1][col]==player && board[2][col]==player){
                return true;
            }
        }
        // diagonals

            if(board[0][0]==player && board[1][1]==player && board[2][2]==player){
                return true;
            }
            if(board[0][2]==player && board[1][1]==player && board[2][0]==player){
                return true;
            }
            return false;
    }

    public static void printBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }
}
