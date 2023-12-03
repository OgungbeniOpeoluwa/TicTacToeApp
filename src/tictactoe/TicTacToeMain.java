package tictactoe;

import java.util.Scanner;

public class TicTacToeMain {
    static TicTacToes ticTacToes = new TicTacToes();
    public static void main(String[] args) {
        registerPlayer();
        play();

    }

    public static void registerPlayer(){
        print("Welcome To TicTacToe,Kindly SetUp Your Names!!!!!!!!!!!!!");

        String player1 = input("Enter your name player X : ");
        String player2 = input("Enter your name player O: ");
        ticTacToes.getPlayers()[0].setName(player1);
        ticTacToes.getPlayers()[1].setName(player2);
        print("CONGRATULATION!!! you have Successfully setup your names....Welcome to TicTacToe!!!");
        System.out.println();

    }

    public static void play(){
        while(ticTacToes.getGame() == Game.CONTINUE){
            playGame();
        }
        if(ticTacToes.getGame() == Game.WIN){
            print("Game Over!!!");
            print(ticTacToes.getWinner().getName() + " " + "Won");
        }
        else{
            print("It's a draw!!!!");
            print("Game Over!!!");
        }
    }

    private static void playGame() {
        for(int count = 0; count < 2; count++){
            boolean condition = true;
            loopBoard();
            if (checkInputs(condition, count)) break;
        }
    }

    private static boolean checkInputs(boolean condition, int count) {
        while(condition) {
            try {
                String input = input(ticTacToes.getPlayers()[count].getName() + " " + "Enter a move number between 1 and 9: ");
                ticTacToes.play(count, Integer.parseInt(input));
                condition = false;
            } catch (Exception ex) {
                print(ex.getMessage());

            }
        }
        if(ticTacToes.getGame() == Game.WIN || ticTacToes.getGame() == Game.DRAW){
            return true;
        }
        return false;
    }


    public static void loopBoard(){
        MultiThread thread = new MultiThread();
        for(int count = 0 ;count < ticTacToes.getBoard().getBoard().length; count++){
            thread.run();
            for(int counts = 0; counts < ticTacToes.getBoard().getBoard()[count].length;counts++){
                System.out.print(ticTacToes.getBoard().getBoard()[count][counts] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static String input(String message){
        Scanner scanner = new Scanner(System.in);
        print(message);
        return scanner.nextLine();

    }

    private static void print(String message) {
        System.out.println(message);
    }
}
