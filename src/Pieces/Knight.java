package Pieces;

import Chess_Game.Board;
import Chess_Game.Spot;

/**
 * Knight pieces of a chessPieces kind
 * @author Rohit 
 * @method 
 * <ul>
 * <li> CanMove
 * <li> toString
 * 
 * 
 */
public class Knight extends ChessPieces{

    /**
	 * Constructor for the Knight
	 * @param isWhite
	 */
    public Knight(Boolean isWhite) {
        super(isWhite);
    }

    /**
	 * check if it is a valid move for Knight
	 * @param startSpot staritng spot of the Knight
	 * @param endSpot ending spot of the Knight
	 * @param board the current board instance
	 * @return true or false 
	 */
    @Override
    public boolean canMove(Spot startSpot, Spot endSpot, Board board) {
		int newX = Math.abs(startSpot.getX() - endSpot.getX());
		int newY = Math.abs(startSpot.getY() - endSpot.getY());

        // check if the end spot is occupied by a piece of the same color
        if (endSpot.getPiece() != null && endSpot.getPiece().isWhite() != this.isWhite()) {
            return true;
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

    /**
     * @param No param
     * @return String the initial of the Piece based on their color
     */
	public String toString() {
		if(isWhite == true){
			return "wN";
		} else {
			return "bN";
		}
	}
}
