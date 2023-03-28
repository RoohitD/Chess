package Pieces;

import Chess_Game.Board;
import Chess_Game.Spot;

/**
 * Knight pieces of a chessPieces kind
 * @author Rohit and Basu
 * @method 
 * <ul>
 * <li> CanMove
 * 
 * 
 */
public class Knight extends ChessPieces{

    public Knight(Boolean isWhite) {
        super(isWhite);
    }

    /**
     * check the valid move for the knight
     */
    @Override
    public boolean canMove(Spot startSpot, Spot endSpot, Board board) {
		int newX = Math.abs(startSpot.getX() - endSpot.getX());
		int newY = Math.abs(startSpot.getY() - endSpot.getY());

        // check if the end spot is occupied by a piece of the same color
        if (endSpot.getPiece() != null && endSpot.getPiece().isWhite() == this.isWhite()) {
            return false;
        }
        
        if(startSpot.getX() == endSpot.getX() && startSpot.getY() == endSpot.getY()){
            return false;
        }

        // check if the move is L-shaped
        if ((newX == 1 && newY == 2) || (newX == 2 && newY == 1)) {
            return true;
        }
        
        return false;
    }


	public String toString() {
		if(isWhite == true){
			return "wN";
		} else {
			return "bN";
		}
	}
}
