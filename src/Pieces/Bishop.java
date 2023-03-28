package Pieces;

import Chess_Game.Board;
import Chess_Game.Spot;

/**
 * 
 * @author Rohit
 * @method 
 * <ul> 
 * <li>CanMove
 * <li>
 */
public class Bishop extends ChessPieces{

    /**
	 * Constructor for the Bishop
	 * @param isWhite
	 */
    public Bishop(Boolean isWhite) {
        super(isWhite);
    }
    
   /**
	 * check if it is a valid move for Bishop
	 * @param startSpot staritng spot of the Bishop 
	 * @param endSpot ending spot of the Bishop
	 * @param board the current board instance
	 * @return true or false 
	 */
    @Override
    public boolean canMove(Spot startSpot, Spot endSpot, Board board) {
        int startX = startSpot.getX();
        int startY = startSpot.getY();
        int endX = endSpot.getX();
        int endY = endSpot.getY();

        int dx = Math.abs(endX - startX);
        int dy = Math.abs(endY - startY);

        // Check if the move is diagonal
        if (dx != dy) {
            return false;
        }

        // Check if there are any pieces between the start and end board
        int xDir = (endX - startX) > 0 ? 1 : -1;
        int yDir = (endY - startY) > 0 ? 1 : -1;
        for (int i = 1; i < dx; i++) {
            int x = startX + (i * xDir);
            int y = startY + (i * yDir);
            if (board.boardSpots[x][y].getPiece() != null) {
                return false;
            }
        }

        // Check if the end spot is empty or has an opponent's piece
        if (endSpot.getPiece() == null || endSpot.getPiece().isWhite() != this.isWhite) {
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
			return "wB";
		} else {
			return "bB";
		}
    }

}
