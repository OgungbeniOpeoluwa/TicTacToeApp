package tictactoe;

import java.util.HashMap;

public class TicTacToes {
   private final Player [] players = new  Player[2];
   private final Board board = new Board();
   private Game game = Game.CONTINUE;

    public Game getGame() {
        return game;
    }

    private final HashMap<Integer, int[]> values = new HashMap<>();

    private Player win;
    public Player getWinner(){
        return win;
    }

    public  TicTacToes(){
        int row = 0;
        int coloum = 0;
        for(int count = 1; count < 10;count++){
             values.put(count,new int[]{row,coloum});
            coloum++;
            if(coloum > 2){
                row++;
                coloum = 0;
            }
        }
       players[0]  = new Player(BoardElement.X);
       players[1] = new Player(BoardElement.O);
    }

    public Player[] getPlayers() {
        return players;
    }

    public Board getBoard() {
        return board;
    }
    public void play(int count,int moves){
        Player player = players[count];
        validateMoves(moves);
        board.setBoard(player,values.get(moves));
        game = board.validateWinner(player);
        if(game == Game.WIN) {
            win = player;
        }
    }
    public int[] move(int moves) {
        validateMoves(moves);
        return values.get(moves);
    }

    private void validateMoves(int moves){
         if(moves < 1 || moves > 9) throw new InvalidMoveNumber("Invalid move number");

    }

}
