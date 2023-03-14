package Pieces;

import Chess_Game.Spot;

public class Queen extends ChessPieces{

    public Queen(Boolean isWhite) {
        super(isWhite);
        //TODO Auto-generated constructor stub
    }

    @Override
    public boolean canMove(Spot startSpot, Spot endSpot, Spot[][] board) {
        int newX = Math.abs(startSpot.getX() - endSpot.getX());
		int newY = Math.abs(startSpot.getY() - endSpot.getY());

        if(endSpot.getPiece() != null && endSpot.getPiece().isWhite() ){
            return false;
        }

        if (newX == 0 || newY == 0 || newX == newY){
            int xDir;
            int yDir;

            if(endSpot.getX() - startSpot.getX() > 0){
                xDir = 1;
            } else {
                xDir = -1;
            }
            if(endSpot.getY() - startSpot.getY() > 0){
                yDir = 1;
            } else {
                yDir = -1;
            }
            int i = startSpot.getX() + xDir;
            int j = startSpot.getY() + yDir;
            while (i != endSpot.getX() || j != endSpot.getY()){
                if(board[i][j].getPiece() != null){
                    return false;
                }
                i += xDir;
                j += yDir;
            }
            return true;

        }
        return false;
    }


	public String toString() {
		if(isWhite == true){
			return "Q";
		} else {
			return "q";
		}
	}

}
