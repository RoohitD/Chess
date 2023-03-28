package Pieces;

import java.util.Arrays;

import Chess_Game.Board;
import Chess_Game.Spot;

/**
 * The Initial ChessPieces class that is the root of all the chess pieces that extend from it.
 * @author Rohit and Basu
 *
 */
public abstract class ChessPieces {
	Boolean isWhite; 
	int moveablelist[][];
	
	
	/**
	 * ChessPieces constructor
	 * @param isWhite color of a pieces
	 */
	public ChessPieces(Boolean isWhite) {
		this.isWhite = isWhite;
	}

	/**
	 * Abstract method for every Piece that extends this class and has certain restrictions
	 * @param startSpot
	 * @param endSpot
	 * @param board
	 * @return
	 */
	public abstract boolean canMove(Spot startSpot, Spot endSpot, Board board);

	/**
	 * 
	 * @return true or false accordin to the pieces color
	 */
	public boolean isWhite(){
		return isWhite;
	}
	
}
