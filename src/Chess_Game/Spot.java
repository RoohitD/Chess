package Chess_Game;


import Pieces.ChessPieces;
import Pieces.King;

/**
 * 
 * @author Rohit and Basu 
 * @method 
 * <ul> Spot
 * <li>getX
 * <li> getY
 * <li>getPiece
 * <li>setPiece
 * <li> isEmpty
 * 
 */
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
/**
 * return the x array value
 * @return the x value 
 */
    public int getX() {
        return x;
    }
    /**
     * return the Y array value
     * @return the Y value 
     */
    public int getY() {
        return y;
    }

    /**
     * return chesspieces
     * @return the chess pieces 
     */
    public ChessPieces getPiece() {
        return piece;
    }

   /**
    * store the pieces in the currente spot 
    * @param piece pices that is getting set 
    */
    public void setPiece(ChessPieces piece) {
        this.piece = piece;
    }

    /**
     * check if the spot is empty
     * @return true or false
     */
    public boolean isEmpty(){
        return false;
    }

}
