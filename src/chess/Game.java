package chess;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Game {
	
	//----------------------------------
	//initialize 
	Scanner scan = new Scanner(System.in);
	Board board = new Board();
	
	//---------------------------------------
	// global varable
	
	String input;
	String turn= "white";
	boolean run= true;
	int mfRow;
	int mfCol; 
	int mtRow ; 
	int mtCol ;
	

	
	//----------------------------------------------------------------------------------------------
		// chess pieces object
		
		
		// white pieces
		
		ChessPieces wking = new king ("white", "a4","wK");
		ChessPieces wpawn1 = new pawn("white", "a7","wP");
		ChessPieces wpawn2 = new pawn("white", "b7","wP");
		ChessPieces wpawn3 = new pawn("white", "c7","wP");
		ChessPieces wpawn4 = new pawn("white", "d7","wP");
		ChessPieces wpawn5 = new pawn("white", "e7","wP");
		ChessPieces wpawn6 = new pawn("white", "f7","wP");
		ChessPieces wpawn7 = new pawn("white", "g7","wP");
		ChessPieces wpawn8 = new pawn("white", "h7","wP");
		
		
		// Black Pieces
		
		ChessPieces bking = new king ("black", "a4", "bK");
		ChessPieces bpawn1 = new pawn("black", "a7","bP");
		ChessPieces bpawn2 = new pawn("black", "b7","bP");
		ChessPieces bpawn3 = new pawn("black", "c7","bP");
		ChessPieces bpawn4 = new pawn("black", "d7","bP");
		ChessPieces bpawn5 = new pawn("black", "e7","bP");
		ChessPieces bpawn6 = new pawn("black", "f7","bP");
		ChessPieces bpawn7 = new pawn("black", "g7","bP");
		ChessPieces bpawn8 = new pawn("black", "h7","bP");
		
	
		//---------------------------------------------------------------------
		// constructor
		
		Game(){
			board.draw(chess);
			startGame();
		}
	
	
	
	//-------------------------------------------------------
	// start game 
	public void startGame() {
		
		while(run){
			
			if (turn.equals("white")) {
				System.out.println("white turn pleas make a move");
			} else {
				System.out.println("black turn please make a move");
			}
			
			analized(scan.nextLine());
			
			
			//makeChanges(mfRow,  mfCol,  mtRow,  mtCol);
			//board.draw(chess);
		};
		
		System.out.println("Game end");
		
	}
	
	
	//--------------------------------------------------------------------------------
	// array list to hold all the chess pieces in place like a chessboard 
	
	ChessPieces[][] chess = {
			{null, null, null, null, bking, null, null,null },
			{bpawn1, bpawn2, null, bpawn4, bpawn5, bpawn6,bpawn7,bpawn8 },
			{null, null, null, null, null, null, null,null },
			{null, null, null, null, null, null, null,null },
			{null, null, null, null, null, null, null,null },
			{null, null, null, bpawn3, null, null, null,null },
			{wpawn1, wpawn2, wpawn3, wpawn4, wpawn5,wpawn6, wpawn7,wpawn8 },
			{null, null, null, null, null, null, null,null }
	};
	
	
	
	//-------------------------------------------------------------------------------------
	// analizing the player input so that we can move the object around the arraylist
	
	public void analized( String s) {
			
			
			if ( s.equalsIgnoreCase("draw")) {
				run = false;
				System.out.println(s);
				
			}else {
				//System.out.println(s)
				//char c = s.charAt(1);
				//system.out.println( s.charAt(1))
				try{		
					 mfRow = Character.getNumericValue(s.charAt(1));
					 mfCol = mfColMap(s,0);
					
					 mtRow =(Character.getNumericValue(s.charAt(4)));
					 mtCol = mfColMap(s,3);
					
					 checkmovingitem(mfRow, mfCol);
					
				}catch(Exception e) {
					System.out.println("Invalid input");
				}
				//System.out.println("Move From ( " + mfRow + ","+ mfCol +" )");
				//System.out.println("Move To ( "+ mtRow +","+mtCol +" )");			
			}	
		}

		public int mfColMap( String s, int index) {
			int ret = 0;
			
			if (s.charAt(index)== 'a' ) {
				ret= 1;
			} else if (s.charAt(index)== 'b') {
				ret= 2;
			} else if (s.charAt(index)== 'c') {
				ret= 3;
			} else if (s.charAt(index)== 'd') {
				ret= 4;
			} else if (s.charAt(index)== 'e') {
				ret= 5;
			} else if (s.charAt(index)== 'f') {
				ret= 6;
			} else if (s.charAt(index)== 'g') {
				ret= 7;
			} else if (s.charAt(index)== 'h') {
				ret= 8;
			}
			
			return ret;	
		}
		
		
		
		private void checkmovingitem(int row, int col) {
		// TODO Auto-generated method stub
			
			if( (turn.equals("white") && (chess[row-1][col-1].color.equals("white"))) ) {
					
				if (checkMoveable(mfRow,  mfCol)) {
					makeChanges(mfRow,  mfCol,  mtRow,  mtCol);
					board.draw(chess);
					turn = "black"; 
				}else {
					System.out.println("Invalid move");
				}
		
//				
//				makeChanges(mfRow,  mfCol,  mtRow,  mtCol);
//				board.draw(chess);
//				turn = "black";   
		
				
			}else if ( (turn.equals("black"))&& (chess[row-1][col-1].color.equals("black"))  )
				{
				
				makeChanges(mfRow,  mfCol,  mtRow,  mtCol);
				board.draw(chess);
				turn = "white";	
			}else {
				System.out.println("Please move " + turn +" pieces");
				analized(scan.nextLine());
			}
		
	}
		
		
		private boolean checkMoveable(int row, int col) {
			// TODO Auto-generated method stub
			boolean ret = false;
			
			if (chess[row-1][col-1].type.equals("wP")) {
				pawn p = new pawn(row, col);
				p.printl();
				
				// regular move 
				for ( int i = 0; i < p.move.size(); i++) {	
						if ((mtRow == p.move.get(i).get(0)) && (mtCol==p.move.get(i).get(1)) && (chess[mtRow+1][mtCol] == null )   ) {
							System.out.println("Valid");
							ret=true;
						}	
				}
				
				//checking for the kill moves
				for ( int i = 0; i< p.Killmove.size(); i++) {
					
//					System.out.println(mtRow);
//					System.out.println(mtCol);
//					System.out.println(p.Killmove.get(i).get(0));
//					System.out.println(p.Killmove.get(i).get(1));
//					System.out.println(chess[mtRow][mtCol].color.equals("white"));
					
					if ((mtRow == p.Killmove.get(i).get(0)) && (mtCol==p.Killmove.get(i).get(1)) 
							 && (!chess[mtRow][mtCol].type.equals("black"))) {
						System.out.println(p.Killmove.get(i).get(0)+ ","+ p.Killmove.get(i).get(1) );
						
						ret=true;
					}
				}
			}
			
			return ret;	
		}

	
		
		//-----------------------------------------------------------------
		//change the arry on the user input
		
		public void makeChanges(int mfRow, int mfCol, int mtRow, int mtCol) {
			
			//-------------------------------------------------
			// checking for the valid move 
			
			ChessPieces movepic = chess[mfRow-1][mfCol-1];	
			chess[mfRow-1][mfCol-1]= null;
			chess[mtRow-1][mtCol-1]= movepic;
			
		}
			
	 		
}
