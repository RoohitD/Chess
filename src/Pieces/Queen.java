package Pieces;

import Chess_Game.Spot;

public class Queen extends ChessPieces{

    public Queen(Boolean isWhite) {
        super(isWhite);
        //TODO Auto-generated constructor stub
    }

    @Override
    public boolean canMove(Spot startSpot, Spot endSpot, Spot[][] board) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'canMove'");
    }

    @Override
    public char getSymbol() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSymbol'");
    }

}
