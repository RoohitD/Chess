package Pieces;

import Chess_Game.Spot;

public class Queen extends ChessPieces{

    public Queen(Boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove(Spot startSpot, Spot endSpot, Spot[][] boardSpots) {
        int startX = startSpot.getX();
        int startY = startSpot.getY();
        int endX = endSpot.getX();
        int endY = endSpot.getY();
    
        int dx = Math.abs(endX - startX);
        int dy = Math.abs(endY - startY);

        		// Check if the end spot is occupied by a piece of the same color
		if (endSpot.getPiece() != null && endSpot.getPiece().isWhite() == isWhite) {
			return false;
		}


        // check if the move is diagonal or straight
        if (dx != dy && startX != endX && startY != endY) {
            return false;
        }
    
        // check if the path is clear for straight moves
        if (dx == 0 || dy == 0) {
            if (startY == endY) {
                int xDir = (endX - startX) > 0 ? 1 : -1;
                for (int x = startX + xDir; x != endX; x += xDir) {
                    if (boardSpots[x][startY].getPiece() != null) {
                        return false;
                    }
                }
            } else {
                int yDir = (endY - startY) > 0 ? 1 : -1;
                for (int y = startY + yDir; y != endY; y += yDir) {
                    if (boardSpots[startX][y].getPiece() != null) {
                        return false;
                    }
                }
            }
        }
    
        // check if the path is clear for diagonal moves
        else {
            int xDir = (endX - startX) > 0 ? 1 : -1;
            int yDir = (endY - startY) > 0 ? 1 : -1;
            int x = startX + xDir;
            int y = startY + yDir;
            while (x != endX && y != endY) {
                if (boardSpots[x][y].getPiece() != null) {
                    return false;
                }
                x += xDir;
                y += yDir;
            }
        }
    
        // return true if the move is legal
        return true;
    }
    


	public String toString() {
		if(isWhite == true){
			return "wQ";
		} else {
			return "bQ";
		}
	}

}
