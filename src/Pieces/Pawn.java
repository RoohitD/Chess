package Pieces;

import java.util.ArrayList;

import Chess_Game.Spot;

public class Pawn extends ChessPieces{
	
	private boolean hasMoved;

	public Pawn(Boolean isWhite) {
        super(isWhite);
		hasMoved = false;
    }


    public boolean hasMovedOnce() {
        return hasMoved;
    }

    public void setMoved() {
        this.hasMoved = true;
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
					setMoved();
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

		    // Check for en passant capture
			if (isEnPassant(startSpot, endSpot, board)) {
				return true;
			}
	
		return false;
	}
	
	
    public boolean isEnPassant(Spot startSpot, Spot endSpot, Spot[][] board) {
		int startX = startSpot.getX();
		int startY = startSpot.getY();
		int endX = endSpot.getX();
		int endY = endSpot.getY();
		int direction;
		
		// Set the direction of movement for the Pawn
		if (isWhite) {
			direction = -1;
		} else {
			direction = 1;
		}
		
		// Check if the move is a diagonal move of length 1
		if (Math.abs(startY - endY) == 1 && Math.abs(startX - endX) == 1) {
			// Check if there is a pawn of the opposite color next to the end spot
			for (int i = -1; i <= 1; i += 2) {
				int adjacentX = endX + direction;
				int adjacentY = endY + i;
				if (adjacentX >= 0 && adjacentX < 8 && adjacentY >= 0 && adjacentY < 8) {
					ChessPieces piece = board[adjacentX][adjacentY].getPiece();
					if (piece instanceof Pawn && piece.isWhite() != isWhite) {
						if (((Pawn) piece).hasMovedOnce()) {
							return true;
						}
					}
				}
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
