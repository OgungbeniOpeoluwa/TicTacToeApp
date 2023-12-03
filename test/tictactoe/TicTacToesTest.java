package tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToesTest {
    private TicTacToes ticTacToes;
    Player [] player;
    @BeforeEach
    public void setUPTicTacToe(){
        ticTacToes = new TicTacToes();
        player = ticTacToes.getPlayers();
    }
    @Test
    public void testThatTicTacToeHasTwoPlayerAndFirstPlayerIdIsX(){
        assertSame(BoardElement.X,ticTacToes.getPlayers()[0].getId());
    }
    @Test
    public void testThatTicTacToeHasTwoPlayerAndSecondPlayerIdIsO(){
        assertSame(BoardElement.O,ticTacToes.getPlayers()[1].getId());
    }
    @Test
    public void testThatTicTacToeHasABoardAnd_ItIsEmpty(){
       Board board = new Board();
       assertEquals(board,ticTacToes.getBoard());
    }
    @Test
    public void testThatWhenPlayerEnter1_rowIs0_columnIs0(){
        int [] result = {0,0};
        assertArrayEquals(result, ticTacToes.move(1));
    }
    @Test
    public void testThatWhenPlayerEnter9_rowIs2_ColumnIs2(){
        int [] expected = {2,2};
        assertArrayEquals(expected,ticTacToes.move(9));
    }
    @Test
    public void testThatIfPlayerPlays10_movesThrowsException(){
        assertThrows(InvalidMoveNumber.class,() -> ticTacToes.move(10));
    }
    @Test
    public void testThatIfFirstPlayerPlaysBoardValuesChangeFromEmptyToX(){
        Board board = new Board();
        int [] result = {1,1};
        board.setBoard(player[0],result);
        ticTacToes.play(0,5);
        assertEquals(board,ticTacToes.getBoard());

    }
    @Test
    public void testThatTwoPlayerPLays_AndTheBoardElementAtTheIndexPlayedChangeToXAndO(){
        Board board = new Board();
        int [] result = {1,1};
        int [] result2 = {2,1};
        board.setBoard(player[0],result);
        board.setBoard(player[1],result2);
        ticTacToes.play(0,5);
        ticTacToes.play(1,8);
        assertEquals(board,ticTacToes.getBoard());

    }
    @Test
    public void testThatPlayerCantPlayIfTheBoardCellIsNotEmpty(){
        ticTacToes.play(0,5);
        assertThrows(BoardFilledEXception. class,()->ticTacToes.play(1,5));
     }
     @Test
    public void testThatPlayerThatPlaysAtTheConsecutiveRowWins(){
        player[0].setName("ope");
        ticTacToes.play(0,1);
        ticTacToes.play(0,2);
        ticTacToes.play(0,3);
        assertEquals("ope",ticTacToes.getWinner().getName());
     }
    @Test
    public void testThat2PlayersPlaysAndPlayer2PlaysAtTheConsecutiveRowWins(){
        player[0].setName("ope");
        player[1].setName("tolu");
        ticTacToes.play(0,3);
        ticTacToes.play(1,7);
        ticTacToes.play(0,5);
        ticTacToes.play(1,8);
        ticTacToes.play(0,1);
        ticTacToes.play(1,9);
        assertEquals("tolu",ticTacToes.getWinner().getName());
    }
    @Test
    public void testThatPlayer1Wins_WhenHEPlaysOnTheSameColumn(){
        player[0].setName("Tobi big head");
        ticTacToes.play(0,2);
        ticTacToes.play(0,5);
        ticTacToes.play(0,8);
        assertEquals("Tobi big head",ticTacToes.getWinner().getName());
    }
    @Test
    public void testThat2PlayersPlaysAndPlayer2PlaysOnTheSameColumn(){
        player[0].setName("ope");
        player[1].setName("tolu");
        ticTacToes.play(0,9);
        ticTacToes.play(1,7);
        ticTacToes.play(0,6);
        ticTacToes.play(1,1);
        ticTacToes.play(0,2);
        ticTacToes.play(1,4);
        assertEquals("tolu",ticTacToes.getWinner().getName());
    }
    @Test
    public void testThatPLayer1WinsWhenHePlaysOnTheRightDiagonal(){
        player[0].setName("Tobi big head");
        ticTacToes.play(0,1);
        ticTacToes.play(0,5);
        ticTacToes.play(0,9);
        assertEquals("Tobi big head",ticTacToes.getWinner().getName());
    }
    @Test
    public void testThat2PlayersPlaysAndPlayer2PlaysOnTheRightDiagonal(){
        player[0].setName("ope");
        player[1].setName("tolu");
        ticTacToes.play(0,8);
        ticTacToes.play(1,1);
        ticTacToes.play(0,6);
        ticTacToes.play(1,5);
        ticTacToes.play(0,2);
        ticTacToes.play(1,9);
        assertEquals("tolu",ticTacToes.getWinner().getName());
    }
    @Test
    public void testThatPlayer1PlaysOnTheLeftDiagonalAllThrough(){
        player[0].setName("Tobi is not serious");
        ticTacToes.play(0,5);
        ticTacToes.play(0,7);
        ticTacToes.play(0,3);
        assertEquals("Tobi is not serious",ticTacToes.getWinner().getName());
    }

    @Test
    public void testThat2playersPlaysAndPlayer2PlaysOnTheLeftDiagonalAllThrough(){
        player[1].setName("Delighted");
        ticTacToes.play(0,1);
        ticTacToes.play(1,5);
        ticTacToes.play(0,8);
        ticTacToes.play(1,3);
        ticTacToes.play(0,9);
        ticTacToes.play(1,7);
        assertEquals("Delighted",ticTacToes.getWinner().getName());
    }
    @Test
    public void testThatWhenPlayersPlayAndThereISNoWinnerReturnDraw(){
        ticTacToes.play(0,1);
        ticTacToes.play(1,2);
        ticTacToes.play(0,3);
        ticTacToes.play(1,4);
        ticTacToes.play(0,5);
        ticTacToes.play(1,7);
        ticTacToes.play(0,6);
        ticTacToes.play(1,9);
        ticTacToes.play(0,8);
        assertSame(Game.DRAW,ticTacToes.getGame());
    }



}