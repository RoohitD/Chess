package Pieces;

import Chess_Game.Spot;

public class Knight extends ChessPieces{

    public Knight(int x, int y, Boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove(Spot startSpot, Spot endSpot, Spot[][] board) {
		int newX = Math.abs(startSpot.getX() - endSpot.getX());
		int newY = Math.abs(startSpot.getY() - endSpot.getY());

        


        return isWhite;
    }

    @Override
    public char getSymbol() {
        return 0;
    }
    
}
