package saved;

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
			
			//System.out.println(scan.nextLine());
			
			analized(scan.nextLine());
			//makeChanges(mfRow,  mfCol,  mtRow,  mtCol);
			//board.draw(chess);
		};
		
		System.out.println("Game end");
		
	}
	
	
	
	
	//----------------------------------------------------------------------------------------------
	// chess pieces object
	
	
	// white pieces
	
	ChessPieces wking = new king ("white", "a4","wK");
	ChessPieces pawn1 = new pawn("white", "a7","wP");
	ChessPieces pawn2 = new pawn("white", "b7","wP");
	ChessPieces pawn3 = new pawn("white", "c7","wP");
	ChessPieces pawn4 = new pawn("white", "d7","wP");
	ChessPieces pawn5 = new pawn("white", "e7","wP");
	ChessPieces pawn6 = new pawn("white", "f7","wP");
	ChessPieces pawn7 = new pawn("white", "g7","wP");
	ChessPieces pawn8 = new pawn("white", "h7","wP");
	
	
	// Black Pieces
	
	ChessPieces Bking = new king ("black", "a4", "bK");
	
	
	
	//--------------------------------------------------------------------------------
	// array list to hold all the chess pieces in place like a chessboard 
	
	ChessPieces[][] chess = {
			{Bking, null, null, null, null, null, null,null },
			{null, null, null, null, null, null, null,null },
			{null, null, null, null, null, null, null,null },
			{null, null, null, null, null, null, null,null },
			{null, null, null, null, null, null, null,null },
			{null, null, null, null, null, null, null,null },
			{pawn1, pawn2, pawn3, pawn4, pawn5,pawn6, pawn7,pawn8 },
			{null, null, null, null, null, null, null,null }
	};
	
	
	
	//-------------------------------------------------------------------------------------
	// analizing the player input so that we can move the object around the arraylist
	
	public void analized( String s) {
			
			
			if ( s.equalsIgnoreCase("draw")) {
				run = false;
				System.out.println(s);
				
			}else {
				
				//System.out.println(s);
				
				
				//char c = s.charAt(1);
				//system.out.println( s.charAt(1))
				try{
					
					
					 mfRow = Character.getNumericValue(s.charAt(1));
					 mfCol = mfColMap(s,0);
					
					 mtRow =(Character.getNumericValue(s.charAt(4)));
					 mtCol = mfColMap(s,3);
					
					 
					 
					 checkmovingitem(mfRow, mfCol);
					
				}catch(Exception e) {
					System.out.println("Please type the valid input");
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
				
//				for ( int i = 0; i < p.move.size(); i++) {
//					for( int j = 0;j < p.move.get(i).size()) {
//						System.out.println(p.move.get(i));
//					}
//				}
				
				
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
