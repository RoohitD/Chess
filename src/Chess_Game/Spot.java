package Chess_Game;

import Pieces.ChessPieces;

/**
 * A class that stores the x and y coordinate and the Piece on a specific spot on the board
 *  @author Rohit 
 *  @method
 *  <ul>
 *  <li> getX
 *  <li> getY
 *  <li> getPiece
 *  <li> setPiece
 */
public class Spot {
    private int x;
    private int y;
    private ChessPieces piece;

    /**
     * Constructor of Spot with the piece
     * @param x x coordinate on the board
     * @param y y coordinate on the board
     * @param piece piece on the board
     */
    public Spot(int x, int y, ChessPieces piece){
        this.x = x;
        this.y = y;
        this.piece = piece;
    }

    /**
     * Constructor of Spot without the piece
     * @param x x coordinate on the board
     * @param y y coordinate on the board
     */
    public Spot(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * returns x coordinate
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * returns y coordinate
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     * returns piece for the Spot
     * @return
     */
    public ChessPieces getPiece() {
        return piece;
    }

    /**
     * sets the piece for the specific spot
     * @param piece
     */
    public void setPiece(ChessPieces piece) {
        this.piece = piece;
    }

}
