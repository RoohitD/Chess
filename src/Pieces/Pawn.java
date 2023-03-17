package Pieces;

import java.util.ArrayList;

import Chess_Game.Spot;

public class Pawn extends ChessPieces{
	
	private boolean hasMoved;

	public Pawn(Boolean isWhite) {
        super(isWhite);
		hasMoved = false;
    }

	@Override
	public boolean canMove(Spot startSpot, Spot endSpot, Spot[][] board) {
		int newX = Math.abs(startSpot.getX() - endSpot.getX());
		int newY = Math.abs(startSpot.getY() - endSpot.getY());
		int direction;

		//Set the direction of movement for the Pawn
		if(isWhite == true){
			direction = -1;
		} else {
			direction = 1;
		}
	

		// Check if the end spot is occupied by a piece of the same color
		if(endSpot.getPiece() != null && endSpot.getPiece().isWhite() == startSpot.getPiece().isWhite()){
			return false;
		}

		// Check if the pawn is moving straight forward
		if(startSpot.getX() == endSpot.getX() && board[endSpot.getX()][endSpot.getY()].getPiece() == null){
			if(endSpot.getY() == startSpot.getY() + direction || (endSpot.getY() == startSpot.getY() + 2 * direction && !hasMoved)){
				return true;
			}
		}

		// Check if the pawn is capturing a piece diagonally
		if(Math.abs(endSpot.getY() - startSpot.getY()) == 1 && endSpot.getX() == startSpot.getX() + direction){
			// Check if the end spot is occupied by an opposing piece
			if(endSpot.getPiece() != null && endSpot.getPiece().isWhite() != startSpot.getPiece().isWhite()){
				return true;
			}
		}

		return false;
	}

	public String toString() {
		if(isWhite == true){
			return "wp";
		} else {
			return "wp";
		}
	}

	
	

/*	
	//--------------------------------------------------------------------------------------
	//testing purpose printing the data
	
		//---------------------------------------------------------------------
	// array list to store the movable array position
	
	//ArrayList<ArrayList<Integer>> move = new ArrayList<ArrayList<Integer>>();
	//ArrayList<ArrayList<Integer>> Killmove = new ArrayList<ArrayList<Integer>>();
	
	
	
	
	 //------------------------------------------------------------------------
	// constructor 
	


	//--------------------------------------------------------------------------
	// rules tha pawn can follow 
	int moveRule[][] = {
			{-1,0}
	};

	int killmoveRule [][] = {
			{-1, -1 },
			{-1, 1 }
	};

	int bmoveRule[][] ={
		{ 1, 0},
	};
	
	int bkillmoveRule[][] = {
		{1,1},
		{1,-1}
	};
	
	//-----------------------------------------------------------------------------
	// making tha array list to store the data in the first place 
	


	public void buildMoveablelist() {
	
			
			for ( int i = 0; i< moveRule.length; i++) {
				ArrayList<Integer> sublist = new ArrayList<Integer>();
						
					sublist.add(moveRule[i][0] + currentRow);
					sublist.add(moveRule[i][1] + currentCol);
					move.add(sublist);
			}
			
			for ( int i = 0; i< killmoveRule.length; i++) {
				ArrayList<Integer> killmove = new ArrayList<Integer>();
	
					killmove.add(killmoveRule[i][0] + currentRow);
					killmove.add(killmoveRule[i][1] + currentCol);
					Killmove.add(killmove);
			}
		}
	

	 public void printl () {
		
		System.out.println("-------Regular Move--------------------");
		for ( int i = 0; i < move.size(); i++) {
				System.out.println(move.get(i).get(0)+","+ move.get(i).get(1));
		}
			
	//----------------------------------------------------
	//	killmove print
		
		System.out.println("-------KillMove--------------------");
		for ( int i = 0; i < Killmove.size(); i++) {
				System.out.println(Killmove.get(i).get(0)+","+ Killmove.get(i).get(1));
		}
	}
	 */
	

	
}
