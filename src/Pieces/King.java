package Pieces;

import java.util.Arrays;

public class King extends ChessPieces{

	

	public King(int x, int y, Boolean isWhite) {
			super(x, y, isWhite);
	}


	@Override
	public boolean canMove(int goX, int goY, ChessPieces[][] board) {
		int toX = goX - x;
		int toY = goY - y;

		// Checks if the king is moving more than 1 place
		if(Math.abs(toX) > 1 || Math.abs(toY) > 1){
			return false;
		}

		// Checks if the king will be checked in that position
		if(isChecked(goX, goY, board)){
			return false;
		}

		return true;
	}

	//Sets the king new position
	@Override
	public void move(int goX, int goY) {
		super.move(goX, goY);
	}

	//Checks if the King will be checked if the piece from the opposite side can be in that position
	public boolean isChecked(int goX, int goY, ChessPieces[][] board){
		
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				ChessPieces apiece = board[i][j];
				if(apiece != null && apiece.isWhite() != isWhite && apiece.canMove(goX, goY, board)){
					return true;
				}
			}
		}

		return false;
	}


	@Override
	public char getSymbol() {
		if(isWhite == true){
			return 'P';
		} else {
			return 'p';
		}
	}

}
