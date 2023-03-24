package Pieces;

import java.util.ArrayList;

import Chess_Game.Spot;

public class Pawn extends ChessPieces{
	
	private boolean hasMoved;

	public Pawn(Boolean isWhite) {
        super(isWhite);
		hasMoved = false;
    }

	@Override
	public boolean canMove(Spot startSpot, Spot endSpot, Spot[][] board) {
		int newX = Math.abs(startSpot.getX() - endSpot.getX());
		int newY = Math.abs(startSpot.getY() - endSpot.getY());
		int direction;

		//Set the direction of movement for the Pawn
		if(isWhite == true){
			direction = -1;
		} else {
			direction = 1;
		}
	

		// Check if the end spot is occupied by a piece of the same color
		if(endSpot.getPiece() != null && endSpot.getPiece().isWhite() == startSpot.getPiece().isWhite()){
			//System.out.println("Check if the end spot is occupied by a piece of the same color");
			return false;
		}

		// Check if the pawn is moving straight forward
		if(startSpot.getX() == endSpot.getX() && board[endSpot.getX()][endSpot.getY()].getPiece() == null){
			if(endSpot.getY() == startSpot.getY() + direction || (endSpot.getY() == startSpot.getY() + 2 * direction && !hasMoved)){
				System.out.println("Check if the pawn is moving straight forward");
				return true;
			}
		}

		// Check if the pawn is capturing a piece diagonally
		if(Math.abs(endSpot.getY() - startSpot.getY()) == 1 && endSpot.getX() == startSpot.getX() + direction){
			// Check if the end spot is occupied by an opposing piece
			if(endSpot.getPiece() != null && endSpot.getPiece().isWhite() != startSpot.getPiece().isWhite()){
				return true;
			}
		}

		return true;
	}

	public String toString() {
		if(isWhite == true){
			return "wp";
		} else {
			return "bp";
		}
	}

}
