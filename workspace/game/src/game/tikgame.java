
package game;

import java.util.*;

public class tikgame {
 
    public static void main(String[] args) {

        char[][] board = {{'1','2','3'}, {'4','5','6'}, {'7', '8', '9'}};
        // assign player to char value of X's only

        int play;

        char player = 'X';

        char cpu = 'O';

        int rowNumber;

        int columnNumber;

        int playerORow;
        int playerOcolumn; 

        System.out.println("Welcome to tic, tac, toe!\n");

        System.out.println("Do you wish to play? 1 for yes, 2 for no ");

        Scanner input = new Scanner(System.in);

        play = input.nextInt();

        if(play != 1) {
            System.out.print("Invalid input, game will now EXIT thanks for playing!");
            System.exit(0);
        } // end if

            displayBoard(board);
            System.out.println("You are limited to X's only, good luck!");
            System.out.println("Please enter row (0-3) of your move: ");
            rowNumber = input.nextInt();
            System.out.println("Please enter column (1-3); of your move: ");
            columnNumber = input.nextInt();

            System.out.println("Please enter row (0-3) for player O: ");
            playerORow = input.nextInt();
            System.out.println("Please enter column (1-3); of your move: ");
            playerOcolumn = input.nextInt();


            if(board[rowNumber][columnNumber] != 'X' && board[rowNumber][columnNumber] != 'O')  {
                board[rowNumber][columnNumber] = player;
            } // end if

            else {

            }


            makeAMove(board, player);
            hasWon(board, player);
            boardFull(board);

} // end main method

// displays only the tic tac toe board
public static void displayBoard(char[][] board) {
    // loop for each row
    System.out.println(board[0][0] + " | " + board[0][1] + " | " + board[0][2] + "\n---------");
    System.out.println(board[1][0] + " | " + board[1][1] + " | " + board[1][2] + "\n---------");
    System.out.println(board[2][0] + " | " + board[2][1] + " | " + board[2][2] + "\n");

} // end display board method

// takes board array of values and updates it with valid row and column selected by player..does not return anything
public static void makeAMove(char[][] board, char player) {
    displayBoard(board);


} // end makeAMove method


// compare each element in board to see if the char value of 'X' exists
    // if exists then then return true, else return false
public static boolean hasWon(char[][] board, char player) {

        // Check if the player has won by checking winning conditions.
        if (board[0][0] == player && board[0][1] == player && board[0][2] == player || // 1st row
            board[1][0] == player && board[1][1] == player && board[1][2] == player || // 2nd row
            board[2][0] == player && board[2][1] == player && board[2][2] == player || // 3rd row
            board[0][0] == player && board[1][0] == player && board[2][0] == player || // 1st col.
            board[0][1] == player && board[1][1] == player && board[2][1] == player || // 2nd col.
            board[0][2] == player && board[1][2] == player && board[2][2] == player || // 3rd col.
            board[0][0] == player && board[1][1] == player && board[2][2] == player || // Diagonal          \ 
            board[2][0] == player && board[1][1] == player && board[0][2] == player) //   Diagonal      /

            return true;

        else {

            return false;
        }

} // end hasWon method

public static boolean boardFull(char [][] board) {

    if (board[0][0] != '1' && board[0][1] != '2' && board[0][2] != '3' &&
        board[1][0] != '4' && board[1][1] != '5' && board[1][2] != '6' &&
        board[2][0] != '7' && board[2][1] != '8' && board[2][2] != '9')

        return true;

    else {

        return false;
    } // end else

} // end boardFull method

} // end class