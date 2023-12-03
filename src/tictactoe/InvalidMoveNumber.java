package tictactoe;

public class InvalidMoveNumber extends RuntimeException{
    public InvalidMoveNumber(String message) {
        super(message);
    }
}
