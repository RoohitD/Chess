package Pieces;

import java.util.ArrayList;

import Chess_Game.Board;
import Chess_Game.Spot;


/**
 * Queen pieces of a ChessPieces kind
 * @author Rohit and Basu
 * @method 
 * <ul>
 * <li> CanMove
 * <li> isEnPassant
 * 
 */
public class Pawn extends ChessPieces{
	
	private boolean hasMoved;

	private Spot lastMovedSpot;

	public Pawn(Boolean isWhite) {
        super(isWhite);
		hasMoved = false;
    }


	/**
	 * returns the pawn movement if it has moved once especially to keep track of it's first two spot move
	 * @return boolean
	 */
    public boolean hasMovedOnce() {
        return hasMoved;
    }

	/**
	 * Sets the move of the pawn to true if it has moved. 
	 */
    public void setMoved() {
        this.hasMoved = true;
    }

	
    /**
    * this method checks if the move is valid for the Pawn
    * @param startSpot the startSpot of the Pawn
    * @param endSpot the endSpot for the Pawn
    * @param board the current board instance
    * @return true or false
    */
	public boolean canMove(Spot startSpot, Spot endSpot, Board board) {
		int newX = Math.abs(startSpot.getX() - endSpot.getX());
		int newY = Math.abs(startSpot.getY() - endSpot.getY());
		int direction;
		boolean isWhiteTurn = false;

		// Set the direction of movement for the Pawn
		if (isWhite) {
			direction = -1;
		} else {
			direction = 1;
		}
	
		if(startSpot.getX() == endSpot.getX() && startSpot.getY() == endSpot.getY()){
            return false;
        }

		// Check if the end spot is occupied by a piece of the same color
		if (endSpot.getPiece() != null && endSpot.getPiece().isWhite() == isWhite) {
			return false;
		}
	
		// Check if the pawn is moving straight forward
		if (newX >= 1 && newY == 0 && endSpot.getPiece() == null) {
			if (endSpot.getX() == startSpot.getX() + direction) {
				setMoved();
				return true;
			} else if (endSpot.getX() == startSpot.getX() + 2 * direction && !hasMoved) {
				Spot intermediateSpot = board.boardSpots[startSpot.getX() + direction][startSpot.getY()];
				if (intermediateSpot.getPiece() == null) {
					setMoved();
					return true;
				}
			}
		}
	
		// Check if the pawn is capturing a piece diagonally
		if (newX == 1 && newY == 1 && endSpot.getPiece() != null) {
			if (endSpot.getPiece().isWhite() != this.isWhite && endSpot.getX() == startSpot.getX() + direction) {
				return true;
			}
		}

		    //Check for en passant capture
		if (canEnPassant(startSpot, endSpot, startSpot.getPiece().isWhite(), board)) {
				return true;
		}
	
		return false;
		
	}	

	/**
	 * check if it is the enpassant move
	 * @param startSpot starting spot of a pawn 
	 * @param endSpot  ending spot of a pawn 
	 * @param isWhiteTurn the current turn
	 * @param board  board 
	 * @return true or false
	 */
	public boolean canEnPassant(Spot startSpot, Spot endSpot, boolean isWhiteTurn, Board board) {
		boolean result = false;
		if(board.lastMovedPiecefrom== null && board.lastMovedPieceto == null ){
			result = false;
		} else if (endSpot.getPiece() == null && startSpot.getX() != endSpot.getX()){
			if(board.lastMovedPieceto.getPiece() instanceof Pawn && (board.lastMovedPieceto.getY() - board.lastMovedPiecefrom.getY()== 2 && board.lastMovedPieceto.getX() - board.lastMovedPiecefrom.getX() == 0) && board.lastMovedPieceto.getPiece().isWhite() != isWhiteTurn){
				ChessPieces leftPiece = board.boardSpots[board.lastMovedPieceto.getX()-1][board.lastMovedPieceto.getY()].getPiece();
				ChessPieces rightPiece = board.boardSpots[board.lastMovedPieceto.getX()+1][board.lastMovedPieceto.getY()].getPiece();
				if(leftPiece != null && leftPiece instanceof Pawn && leftPiece.isWhite() == isWhiteTurn) {
					if (board.lastMovedPieceto.getPiece() == leftPiece) {
						return true;
					}
				}
				if(rightPiece != null && rightPiece instanceof Pawn && rightPiece.isWhite() == isWhiteTurn) {
					if (board.lastMovedPieceto.getPiece() == leftPiece) {
						return true;
					}
				}

			}
		} 
		return result;
	}

 	/**
     * @param No param
     * @return String the initial of the Piece based on their color
     */
	public String toString() {
		if(isWhite == true){
			return "wp";
		} else {
			return "bp";
		}
	}

}
