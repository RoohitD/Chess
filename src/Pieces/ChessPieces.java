package Pieces;

import java.util.Arrays;

import Chess_Game.Board;
import Chess_Game.Spot;

/**
 * 
 * @author Rohit and Basu
 *
 */
public abstract class ChessPieces {
	Boolean isWhite; 
	int moveablelist[][];
	
	
	/**
	 * 
	 * @param isWhite color of a pieces
	 */
	public ChessPieces(Boolean isWhite) {
		this.isWhite = isWhite;
	}

	public abstract boolean canMove(Spot startSpot, Spot endSpot, Board board);

	/**
	 * 
	 * @return true or false accordin to the pieces color
	 */
	public boolean isWhite(){
		return isWhite;
	}

	public void setLastMoved(Spot spot) {
	}
	
}
