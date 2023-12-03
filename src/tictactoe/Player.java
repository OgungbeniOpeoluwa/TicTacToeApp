package tictactoe;

public class Player {
    private BoardElement id;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public Player(BoardElement id){
        this.id = id;
    }
    public BoardElement getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
