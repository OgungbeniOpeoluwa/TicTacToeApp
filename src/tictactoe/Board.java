package tictactoe;

import java.util.Arrays;

import static tictactoe.BoardElement.EMPTY;

public class Board {
    private final BoardElement [][] board = new BoardElement[3][3];

    public BoardElement[][] getBoard() {
        return board;
    }

    public Board(){
        for(int count = 0; count < board.length;count++) {
            Arrays.fill(board[count], EMPTY);
        }
    }

    public void setBoard(Player player,int[] arrays) {
        validateMove(arrays);
        this.board[arrays[0]][arrays[1]] = player.getId();
    }
    private void validateMove(int [] arrays){
        if(this.board[arrays[0]][arrays[1]] != EMPTY) throw new BoardFilledEXception("Board Has been Occupied");
    }

    @Override
    public boolean equals(Object obj){
        if(this.getClass() != obj.getClass()) return false;
        Board covertBoard = (Board)obj;
        if(covertBoard.board.length != this.board.length) return false;
        if (!(checkIfBoardHaveTheSameValue(covertBoard))) return false;
        return true;

    }

    private boolean checkIfBoardHaveTheSameValue(Board covertBoard) {
        for(int count = 0; count < this.board.length;count++){
            for(int counts = 0; counts < this.board[count].length;counts++){
                if(this.board[count][counts] != covertBoard.board[count][counts]) return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(board);
    }

    public Game validateWinner(Player player) {
        if(row(player)) return Game.WIN;
        else if (coloum(player))return Game.WIN;
        else if(rightDiagonal(player)) return Game.WIN;
        else if (leftDiagonal(player))return Game.WIN ;
        else if (isFull()) return Game.DRAW;
        else return Game.CONTINUE;
    }

    private boolean isFull() {
        for(int count = 0; count < board.length; count++){
            for(int counts = 0; counts < board[count].length; counts++){
                if(board[count][counts] == EMPTY)return false;
            }
        }
        return true;
    }

    private boolean leftDiagonal(Player player) {
        int counter = 2;
        for(int count = 0; count < board.length;count++){
            if(board[count][counter]!= player.getId())return false;
            counter--;
        }
        return true;
    }

    private boolean rightDiagonal(Player player) {
        for(int count = 0; count < board.length;count++){
            if(board[count][count] != player.getId())return false;
        }
        return true;
    }

    private boolean coloum(Player player) {
        int results = 0;
        for(int count = 0; count < board.length;count++){
            for(int counts = 0; counts < board[count].length;counts++){
                if(board[counts][count] == player.getId()){
                    results++;
                }
            }
            if(results == 3){
                return true;
            }
            results=0;
        }
        return false;
    }
    private boolean row(Player player) {
        int results = 0;
        for(int count = 0; count < board.length; count++){
            for(int counts = 0; counts < board[count].length;counts++){
                if(board[count][counts] == player.getId()){
                    results++;
                }
            }
            if(results == 3){
                return true;
            }
            results=0;
        }
        return false;
    }
}
