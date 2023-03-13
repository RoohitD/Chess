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
	
		//Check for the Pawn's First Move
		if(newY == 2 && newX == 0 && !hasMoved && board[endSpot.getX()][endSpot.getY() + direction] != null){
			return true;
		}

		//Check for the Pawn's Move After First
		if(newY != direction && (newY == direction || !hasMoved || endSpot.getX() != 1 && endSpot.getX() != 6)){
			return true;
		}

		return true;
		
	}

	@Override
	public char getSymbol() {
		if(isWhite == true){
			return 'P';
		} else {
			return 'p';
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
