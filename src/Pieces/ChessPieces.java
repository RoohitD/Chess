package Pieces;

import java.util.Arrays;

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

	/**
	 * check whether the ending spot is a valid move for the pieces
	 * @param startSpot staring spot of a pieces 
	 * @param endSpot  ending spot of a pieces 
	 * @param boardSpots board to check fo the validtion
	 * @return ture or false according to the pieces valid move
	 */
	public abstract boolean canMove(Spot startSpot, Spot endSpot, Spot[][] boardSpots);

	/**
	 * 
	 * @return true or false accordin to the pieces color
	 */
	public boolean isWhite(){
		return isWhite;
	}
	
}
