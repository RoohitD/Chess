package chess;

import java.util.ArrayList;

public class pawn extends ChessPieces{
	
	
	// gloval varables
	int currentRow ; 
	int currentCol; 
	
	
	//---------------------------------------------------------------------
	// array list to store the movable array position
	
	ArrayList<ArrayList<Integer>> move = new ArrayList<ArrayList<Integer>>();
	ArrayList<ArrayList<Integer>> Killmove = new ArrayList<ArrayList<Integer>>();
	
	
	
	
	 //------------------------------------------------------------------------
	// constructor 
	
	public pawn(String color, String location, String type) {
		super(color, location, type);
		
		
	}

	public pawn (int row, int col) {
		super();
		this.currentRow = row; 
		this.currentCol = col ;
		buildMoveablelist();
	}
	
	
	
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
	
	
	
	//--------------------------------------------------------------------------------------
	//testing perpose printing the data
	
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

}
