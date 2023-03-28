package Pieces;

import java.util.Arrays;

import Chess_Game.Board;
import Chess_Game.Spot;

public abstract class ChessPieces {
	Boolean isWhite; 
	int moveablelist[][];
	
	
	
	public ChessPieces(Boolean isWhite) {
		this.isWhite = isWhite;
	}

	public abstract boolean canMove(Spot startSpot, Spot endSpot, Board board);

	public boolean isWhite(){
		return isWhite;
	}

	public void setLastMoved(Spot spot) {
	}
	
}
