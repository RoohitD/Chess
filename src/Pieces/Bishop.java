package Pieces;

import Chess_Game.Spot;

public class Bishop extends ChessPieces{

    public Bishop(Boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove(Spot startSpot, Spot endSpot, Spot[][] board) {
        int startX = startSpot.getX();
        int startY = startSpot.getY();
        int endX = endSpot.getX();
        int endY = endSpot.getY();

        int dx = Math.abs(endX - startX);
        int dy = Math.abs(endY - startY);

        // Check if the move is diagonal
        if (dx != dy) {
            return false;
        }

        // Check if there are any pieces between the start and end board
        int xDir = (endX - startX) > 0 ? 1 : -1;
        int yDir = (endY - startY) > 0 ? 1 : -1;
        for (int i = 1; i < dx; i++) {
            int x = startX + (i * xDir);
            int y = startY + (i * yDir);
            if (board[x][y].getPiece() != null) {
                return false;
            }
        }

        // Check if the end spot is empty or has an opponent's piece
        if (endSpot.getPiece() == null || endSpot.getPiece().isWhite()) {
            return true;
        }

        return false;
    }

    @Override
    public char getSymbol() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSymbol'");
    }

}
