package Chess_Game;

import java.util.Arrays;
import java.util.Scanner;

import Pieces.Bishop;
import Pieces.ChessPieces;
import Pieces.King;
import Pieces.Knight;
import Pieces.Pawn;
import Pieces.Queen;
import Pieces.Rook;

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

			//Create Black Pieces
			 

				boardSpots[0][0] = new Spot (0, 0, new Rook(false));
				boardSpots[0][1] = new Spot (0, 1, new Knight(false));
				boardSpots[0][2] = new Spot (0, 2, new Bishop(false));
				boardSpots[0][3] = new Spot (0, 3, new Queen(false));
				boardSpots[0][4] = new Spot(0, 4, new King(false));
				boardSpots[0][5] = new Spot (0, 5, new Bishop(false));
				boardSpots[0][6] = new Spot (0, 6, new Knight(false));
				boardSpots[0][7] = new Spot (0, 7, new Rook(false));

				for (int i = 0; i < 8; i++) {
					boardSpots[1][i] = new Spot(1, i, new Pawn(false));
				}

			// Create Blank Spaces for No Pieces
			for (int i = 2; i < 6; i++) {
				for (int j = 0; j < 8; j++) {
					boardSpots[i][j] = new Spot(i, j, null);
				}
			}
						

			// Create White Pieces
			for (int i = 0; i < 8; i++) {
				boardSpots[6][i] = new Spot(7, i, new Pawn(false));
			}
			boardSpots[7][0] = new Spot(7, 0, new Rook(true));
        	boardSpots[7][1] = new Spot(7, 1, new Knight(true));
        	boardSpots[7][2] = new Spot(7, 2, new Bishop(true));
			boardSpots[7][3] = new Spot(7, 2, new Queen(true));
			boardSpots[7][4] = new Spot(7, 4, new King(true));
			boardSpots[7][5] = new Spot(7, 5, new Bishop(true));
			boardSpots[7][6] = new Spot(7, 6, new Knight(true));
			boardSpots[7][7] = new Spot(7, 7, new Rook(true));



	}
	
	
	public void draw(){
		int z = 8;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if(boardSpots[i][j].getPiece() == null){
					if ((i + j) % 2 == 0) { // alternate between "  " and "##"
						System.out.print("   ");
					} else {
						System.out.print("## ");
            }
				} else {
					System.out.print(boardSpots[i][j].getPiece() + " ");
				}
			}
			System.out.print(z + "\n");
			z--;
		}
		System.out.println(" a  b  c  d  e  f  g  h");
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
