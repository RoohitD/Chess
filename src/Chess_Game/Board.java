package Chess_Game;

import java.util.Arrays;
import java.util.Scanner;

import Pieces.ChessPieces;
import Pieces.King;
import Pieces.Pawn;

//import java.lang.reflect.Array;

public class Board {
		
	private Spot[][] boardSpots;

	public Board(){
		this.boardSpots = new Spot[8][8];
		resetBoard();
	}

	public Spot getSpot(int x, int y){
		return boardSpots[x][y];
	}

	private void resetBoard() {
			boardSpots[0][0] = new Spot(0, 4, new King(false));
			
			for (int i = 0; i < 8; i++) {
				boardSpots[1][i] = new Spot(1, i, new Pawn(false));
			}
			
	}
	
	
	
	
	
	
/*
 //printing the chess board
	public void draw( ChessPieces[][] chess) {
			
		for( int i = 0 ; i < 8 ; i++) {
			if ( i == 0) {
				System.out.println("---------------------------------------------------------------------------------");
			}else {
				System.out.println( "|---------+---------+---------+---------+---------+---------+---------+---------|  " );
			}	
			for ( int j = 0; j < 9 ; j++) {	
				if ( j ==8) {
					System.out.println("|  " + (i+1));	
				}else {
					//System.out.print(i);
					//System.out.print(j);
					//-------------------------------------------------------
					// check for null
						if ( chess[i][j] == null) {
							System.out.print("|    "+ " " +"    ");
						}else {
							System.out.print("|   "+ chess[i][j].type +"    ");
						}
					//----------------------------------------------------------		
					//	System.out.print("|    "+ chess[i][j].type +"    ");
				}
			}
		}
			
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println( "    a          b         c        d          e         f          g         h   " );
		}
	
 */
	
//	public void draw(ChessPieces[][] chess ) {
//		
//		for( int i = 0 ; i < 8 ; i++) {
//			if ( i == 0) {
//				System.out.println("---------------------------------------------------------------------------------");
//			}else {
//				System.out.println( "|---------+---------+---------+---------+---------+---------+---------+---------|  " + i );
//			}	
//			for ( int j = 0; j < 9 ; j++) {	
//				if ( j ==8) {
//					System.out.println("|  " );	
//				}else {
//					//System.out.print(i);
//					//-------------------------------------------------------
//					// check for null
//						if ( chess[i][j] == null) {
//							System.out.print("|    "+ " " +"    ");
//						}else {
//							System.out.print("|    "+ chess[i][j].type +"    ");
//						}
//					//----------------------------------------------------------		
//					//	System.out.print("|    "+ chess[i][j].type +"    ");
//				}
//			}
//		}
//			
//		System.out.println("---------------------------------------------------------------------------------");
//		System.out.println( "    a          b         c        d          e         f          g         h   " );
//		}
	
	
}
