package Pieces;

import java.util.Arrays;

public abstract class ChessPieces {
	Boolean isWhite; 
	protected int x;
	protected int y;
	int moveablelist[][];
	
	
	
	public ChessPieces(int x, int y, Boolean isWhite) {
		this.x = x;
		this.y = y;
		this.isWhite = isWhite;
	}

	public abstract boolean canMove(int X, int Y, ChessPieces[][] board);

	public void move(int goX, int goY){
		this.x = goX;
		this.y = goY;
	}

	public abstract char getSymbol();

	public boolean isWhite(){
		return isWhite;
	}

	public int getX(){
		return x;
	}

	public int getY() {
		return y;
	}
	
}
