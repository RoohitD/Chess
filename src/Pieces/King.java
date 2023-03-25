package Pieces;

import java.util.Arrays;

import Chess_Game.Spot;

public class King extends ChessPieces{

	public King(Boolean isWhite) {
			super(isWhite);
	}


	@Override
	public boolean canMove(Spot startSpot, Spot endSpot, Spot[][] board) {
		int newX = Math.abs(startSpot.getX() - endSpot.getX());
		int newY = Math.abs(startSpot.getY() - endSpot.getY());

		// Checks if the king is moving more than 1 place
		if(Math.abs(newX) > 1 || Math.abs(newY) > 1){
			return false;
		}
		// Checks if the king will be checked in that position
		if(isChecked(startSpot, endSpot, board)){
			//System.out.println("Can be checked canMove method");
			return false;
		}

		return true;
	}


	//Checks if the King will be checked if the piece from the opposite side can be in that position
	public boolean isChecked(Spot startSpot, Spot endSpot, Spot[][] board) {
		// Check if any piece can attack the king in the end spot
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Spot spot = board[i][j];
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


	public String toString() {
		if(isWhite == true){
			return "wK";
		} else {
			return "bK";
		}
	}
}
