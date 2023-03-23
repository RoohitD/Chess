package Chess_Game;

import Pieces.ChessPieces;
import Pieces.King;

public class Spot {
    private int x;
    private int y;
    private ChessPieces piece;

    public Spot(int x, int y, ChessPieces piece){
        this.x = x;
        this.y = y;
        this.piece = piece;
    }

    public Spot(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public ChessPieces getPiece() {
        return piece;
    }

    public void setPiece(ChessPieces piece) {
        this.piece = piece;
    }

    public boolean isEmpty(){
        return false;
    }

}
