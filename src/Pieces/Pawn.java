package Pieces;

import java.util.ArrayList;

import Chess_Game.Spot;

public class Pawn extends ChessPieces{
	
	private boolean hasMoved;

	public Pawn(Boolean isWhite) {
        super(isWhite);
		hasMoved = false;
    }

	public boolean canMove(Spot startSpot, Spot endSpot, Spot[][] board) {
		int newX = Math.abs(startSpot.getX() - endSpot.getX());
		int newY = Math.abs(startSpot.getY() - endSpot.getY());
		int direction;
	
		// Set the direction of movement for the Pawn
		if (isWhite) {
			direction = -1;
		} else {
			direction = 1;
		}
	
		// Check if the end spot is occupied by a piece of the same color
		if (endSpot.getPiece() != null && endSpot.getPiece().isWhite() == isWhite) {
			return false;
		}
	
		// Check if the pawn is moving straight forward
		if (newX >= 1 && newY == 0 && endSpot.getPiece() == null) {
			if (endSpot.getX() == startSpot.getX() + direction) {
				return true;
			} else if (endSpot.getX() == startSpot.getX() + 2 * direction && !hasMoved) {
				Spot intermediateSpot = board[startSpot.getX() + direction][startSpot.getY()];
				if (intermediateSpot.getPiece() == null) {
					return true;
				}
			}
		}
	
		// Check if the pawn is capturing a piece diagonally
		if (newX == 1 && newY == 1 && endSpot.getPiece() != null) {
			if (endSpot.getPiece().isWhite() != isWhite && endSpot.getX() == startSpot.getX() + direction) {
				return true;
			}
		}
	
		return false;
	}
	
	
	

	public String toString() {
		if(isWhite == true){
			return "wp";
		} else {
			return "bp";
		}
	}

}
