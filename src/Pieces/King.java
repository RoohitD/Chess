package Pieces;

import java.util.Arrays;
import Chess_Game.Board;

/**
 * King pieces of a chessPieces kind
 * @author Rohit 
 * @method 
 * <ul>
 * <li> CanMove
 * <li> hasmoved
 * <li> canCastle
 */

import Chess_Game.Spot;

public class King extends ChessPieces{


	public boolean hasMoved = false;

	/**
	 * check if the pieces have moved befor
	 * @return true and false 
	 */
	public boolean hasMoved(){
		return hasMoved;
	}

	/**
	 * Constructor for the king
	 * @param isWhite
	 */
	public King(Boolean isWhite) {
			super(isWhite);
	}


	/**
	 * check for the vaid king move
	 */
	@Override
	public boolean canMove(Spot startSpot, Spot endSpot, Board board) {
		int startX = startSpot.getX();
		int startY = startSpot.getY();
		int endX = endSpot.getX();
		int endY = endSpot.getY();
	

		// Check if the end spot is not occupied by a piece of the same color
		if (endSpot.getPiece() == null || endSpot.getPiece().isWhite() != isWhite) {
			// Check if the move is a castling move
			if (canCastle(startSpot, endSpot, board)) {
				return true;
			}
			// Check if the move is a one-square move in any direction
			if (Math.abs(startX - endX) <= 1 && Math.abs(startY - endY) <= 1) {
				// Check if the king is not moving into check
				if (!isChecked(startSpot, endSpot, board)) {
					return true;
				}
			}
		}
		return false;
	}


	//Checks if the King will be checked if the piece from the opposite side can be in that position
	public boolean isChecked(Spot startSpot, Spot endSpot, Board board) {
		// Check if any piece can attack the king in the end spot
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Spot spot = board.boardSpots[i][j];
				ChessPieces piece = spot.getPiece();
				if (piece != null && piece.isWhite() != isWhite) {
					if (piece.canMove(spot, endSpot, board)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public void setMoved(){
		hasMoved = true;
	}

	/**
	 * check if it is a valid castle move
	 * @param startSpot staritng spot of the king 
	 * @param endSpot ending spot of the king 
	 * @param board the current board instance
	 * @return true or false 
	 */
	public boolean canCastle(Spot startSpot, Spot endSpot, Board board) {
		// Check if King has moved previously
		if (hasMoved()) {
			return false;
		}
	
		// Check if the move is a castling move
		int startY = startSpot.getY();
		int endY = endSpot.getY();
		if (Math.abs(startY - endY) != 2) {
			return false;
		}
	
		// Check if there are any pieces between King and Rook
		int rookY;
		int direction;
		if (endY > startY) {
			// Castling to the right
			rookY = 7;
			direction = 1;
		} else {
			// Castling to the left
			rookY = 0;
			direction = -1;
		}
	
		for (int y = startY + direction; y != rookY; y += direction) {
			if (board.boardSpots[startSpot.getX()][y].getPiece() != null) {
				return false;
			}
		}
	
		// Check if the Rook has not moved previously
		ChessPieces rook = board.boardSpots[startSpot.getX()][rookY].getPiece();
		if (!(rook instanceof Rook) || ((Rook) rook).hasMoved()) {
			return false;
		}
	
		// Check if the King is not in check in any of the squares between King and Rook
		int y = startY;
		while (y != rookY) {
			Spot spot = board.boardSpots[startSpot.getX()][y];
			if (isChecked(spot, endSpot, board)) {
				return false;
			}
			y += direction;
		}
		return true;
	}
	

	/**
     * @param No param
     * @return String the initial of the Piece based on their color
     */
	public String toString() {
		if(isWhite == true){
			return "wK";
		} else {
			return "bK";
		}
	}
}
