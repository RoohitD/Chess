package Chess_Game;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

import Pieces.ChessPieces;
import Pieces.King;
import Pieces.Pawn;

public class Game {
	//white king locatio 
	int wKingX=5;
	int wKingY=1;

	// blac king location
	int bKingX=5;
	int bKingY=8;

	//----------------------------------
	//initialize 
	Scanner scan = new Scanner(System.in);
	Board board = new Board();
	
	//---------------------------------------
	// global variable
	
	String input;
	String turn= "white";
	boolean run= true;
	boolean boolturn = true;
	

	public Game(){
		board.draw();
		startGame();
	}
	
	private void DecodeInput(String s){

		String[] inputs = s.split(" ");
		String start ;
		String end ;

		if(inputs.length == 3){
			if (inputs[2].equalsIgnoreCase("resign")){
				run= false;
				System.out.print( turn + " loose");
			}else if (inputs[2].equalsIgnoreCase("Draw?")){
				run = false ; 
				System.out.print("Draw");
			}else {
				System.out.println("do you meant Draw? or resign");
				DecodeInput(scan.nextLine());
			}

		}else if ( inputs.length == 2){
			
			// setting the values
			 start = inputs[0];
			 end = inputs[1];

			// check if the input is valid
		
			// System.out.println(start.length());
			// if (start.length() >2 || start.length() <2 || end.length() >2 || end.length() <2){
			// 	System.out.println("Invalid input try agian");
			// 	DecodeInput(scan.nextLine());
			// }

			if(start.length() != 2 || end.length() !=2){
				System.out.println("Invalid input");
				while(run){
					DecodeInput(scan.nextLine());
				}
			}

			// Convert the starting square (e4) into coordinates (4, 3)
			int startY = start.charAt(0) - 'a';
			int startX = 8 - Integer.parseInt(start.substring(1));

			// Convert the ending square (e7) into coordinates (4, 6)
			int endY = end.charAt(0) - 'a';
			int endX = 8 - Integer.parseInt(end.substring(1));



			try {
				if(board.getSpot(startX,startY).getPiece().canMove(board.getSpot(startX, startY), board.getSpot(endX, endY), board.boardSpots)){
					if ( board.getSpot(startX,startY).getPiece().isWhite()== boolturn){
						board.setPosition(startX, startY, endX, endY, turn);
						boolturn = !boolturn;

					}else{
						System.out.println("invalid move. it's "+ turn + " turn");
						DecodeInput(scan.nextLine());
					}
					//board.setPosition(startX, startY, endX, endY, turn);
				} else {
					System.out.println("Invalid move");
					DecodeInput(scan.nextLine());
				}
			} catch (Exception e) {
				System.out.println("No Chess pieces found, try again ");
				DecodeInput(scan.nextLine());
			}
			
		}else {
			System.out.println("Invalid input, try again");
			DecodeInput(scan.nextLine());
		}
	}

	//-------------------------------------------------------
	// start game 
	public void startGame() {

		while(run){
			
			if (turn.equals("white")) {
				System.out.println("White's move: ");
				DecodeInput(scan.nextLine());
				turn ="Black";
				
			} else {
				System.out.println("Black's move: ");
				DecodeInput(scan.nextLine());
				turn = "white";
			}
		};


		while (scan.next() == "resign") {
			System.out.println("White's Move");
			scan.next();
			System.out.println("Black's move: ");
		}
		System.out.println("Game end");
	}
}
	
	