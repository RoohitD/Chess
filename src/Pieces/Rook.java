package Pieces;

import Chess_Game.Board;
import Chess_Game.Spot;

/**
 * Rook pieces of a ChessPieces kind
 * @author Rohit 
 * @method 
 * <ul>
 * <li> CanMove
 * <li> hasMoved
 * <li> toString
 */

public class Rook extends ChessPieces{

    boolean hasMoved = false;


    /**
	 * Constructor for the Rook
	 * @param isWhite
	 */
    public Rook(Boolean isWhite) {
        super(isWhite);
    }


    /**
     * check if the piece has moved before
     * @return true or false according 
     */
    public boolean hasMoved(){
        return hasMoved;
    }


    /**
     * this method checks if the move is valid for the Rook
     * @param startSpot the startSpot of the Rook
     * @param endSpot the endSpot for the Rook
     * @param board the current board instance
     * @return true or false
     */
    @Override
    public boolean canMove(Spot startSpot, Spot endSpot, Board board) {
        int startX = startSpot.getX();
        int startY = startSpot.getY();
        int endX = endSpot.getX();
        int endY = endSpot.getY();

        // Rooks can only move along a row or column
        if (startX != endX && startY != endY) {
            return false;
        }

        if(startX == endX && startY == endY){
            return false;
        }

        int xDir = 0;
        int yDir = 0;

        // Determine the direction of movement
        if (startX != endX) {
            xDir = (endX - startX) > 0 ? 1 : -1;
        } else {
            yDir = (endY - startY) > 0 ? 1 : -1;
        }

        // Check that there are no pieces in the way
        int curX = startX + xDir;
        int curY = startY + yDir;
        while (curX != endX || curY != endY) {
            if (board.boardSpots[curX][curY].getPiece() != null) {
                return false;
            } 
            curX += xDir;
            curY += yDir;
        }
      
        // Check if the end spot is occupied by an enemy piece or is empty
        ChessPieces endPiece = endSpot.getPiece();
            if (endPiece == null) {
                return true;
             } else {
                return endPiece.isWhite() != isWhite();
            }
    }

    /**
     * @param No param
     * @return String the initial of the Piece based on their color
     */
	public String toString() {
		if(isWhite == true){
			return "wR";
		} else {
			return "bR";
		}
	}

}
