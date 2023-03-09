package chess;

import java.util.Arrays;
import java.util.Scanner;

//import java.lang.reflect.Array;

public class Board {

	//printing the chess board
	public void draw( ChessPieces[][] chess) {
		
		int Control=1;
		
		for( int i = 0 ; i < 8 ; i++) {
			Control += 1;
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
							
							 if ( (j+1+Control)% 2 == 0) {
								 System.out.print("|    "+ "##" +"   ");
							 } else {
								 System.out.print("|    "+ " " +"    "); 
							 }
							
							//System.out.print("|    "+ " " +"    ");
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
