package Pieces;

import Chess_Game.Spot;

public class Rook extends ChessPieces{

    public Rook(Boolean isWhite) {
        super(isWhite);
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
