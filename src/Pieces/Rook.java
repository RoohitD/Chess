package Pieces;

import Chess_Game.Spot;

public class Rook extends ChessPieces{

    public Rook(Boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove(Spot startSpot, Spot endSpot, Spot[][] board) {
        int startX = startSpot.getX();
        int startY = startSpot.getY();
        int endX = endSpot.getX();
        int endY = endSpot.getY();

        // Rooks can only move along a row or column
        if (startX != endX && startY != endY) {
            return false;
        }

        int xDir = 0;
        int yDir = 0;

        // Determine the direction of movement
        if (startX != endX) {
            xDir = (endX - startX) > 0 ? 1 : -1;
        } else {
            yDir = (endY - startY) > 0 ? 1 : -1;
        }

        // Check that there are no pieces in the way
        int curX = startX + xDir;
        int curY = startY + yDir;
        while (curX != endX || curY != endY) {
            if (board[curX][curY].getPiece() != null) {
                return false;
            }
            curX += xDir;
            curY += yDir;
        }
      
        // Check if the end spot is occupied by an enemy piece or is empty
        ChessPieces endPiece = endSpot.getPiece();
            if (endPiece == null) {
                return true;
             } else {
                return endPiece.isWhite() != isWhite();
            }
    }


	public String toString() {
		if(isWhite == true){
			return "wR";
		} else {
			return "bR";
		}
	}

}
