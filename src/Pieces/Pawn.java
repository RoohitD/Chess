package Pieces;

import java.util.ArrayList;

import Chess_Game.Board;
import Chess_Game.Spot;


/**
 * Queen pieces of a chessPieces kind
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


    public boolean hasMovedOnce() {
        return hasMoved;
    }

    public void setMoved() {
        this.hasMoved = true;
    }
<<<<<<< HEAD

	public boolean canMove(Spot startSpot, Spot endSpot, Board board) {
=======
    /**
     * check the valid move for the pawn accoriding to the color of the pieces
     */
	public boolean canMove(Spot startSpot, Spot endSpot, Spot[][] board) {
>>>>>>> origin/master
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
	public boolean canEnPassant(Spot startSpot, Spot endSpot, boolean isWhiteTurn, Board board) {
		boolean result = false;

		if (endSpot.getPiece() == null && startSpot.getX() != endSpot.getX()){
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
<<<<<<< HEAD


    public boolean isEnPassant(Spot startSpot, Spot endSpot, Board board) {
=======
	
	/**
	 * chekc if it is the enpassant move
	 * @param startSpot starting spot of a pawn 
	 * @param endSpot  ending spot of a pawn 
	 * @param board  board 
	 * @return true or false
	 */
    public boolean isEnPassant(Spot startSpot, Spot endSpot, Spot[][] board) {
>>>>>>> origin/master
		int startX = startSpot.getX();
		int startY = startSpot.getY();
		int endX = endSpot.getX();
		int endY = endSpot.getY();
		int direction;
		

		int x1 = startSpot.getX();
		int y1 = startSpot.getY();
		int x2 = endSpot.getX();
		int y2 = endSpot.getY();
	
		ChessPieces endPiece = board.boardSpots[x2][y2].getPiece();

		if (endPiece == null && x1 != x2) {
			ChessPieces leftPiece = board.boardSpots[x2-1][y2].getPiece();
			ChessPieces rightPiece = board.boardSpots[x2+1][y2].getPiece();
			if (leftPiece != null && leftPiece instanceof Pawn && leftPiece.isWhite() != this.isWhite()) {
				if (board.lastMovedPiecefrom.getPiece() == leftPiece && board.lastMovedPieceto.equals(board.boardSpots[x2-1][y2])) {
					return true;
				}
			}
			if (rightPiece != null && rightPiece instanceof Pawn && rightPiece.isWhite() != this.isWhite()) {
				if (board.lastMovedPiecefrom.getPiece() == rightPiece && board.lastMovedPieceto.equals(board.boardSpots[x2-1][y2])) {
					return true;
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
