package Chess_Game;


import java.util.Scanner;
import Pieces.ChessPieces;
import Pieces.Pawn;

public class Game {

	//----------------------------------
	//initialize 
	Scanner scan = new Scanner(System.in);
	Board board = new Board();
	
	//---------------------------------------
	// global variable
	
	String input;
	String turn= "white";
	boolean run= true;
	boolean isWhiteTurn = true;


	public Game(){
		board.draw();
		//upgradePawn();
		startGame();
	}
	
	//-------------------------------------------------------
	// start game 
	public void startGame() {

		while(run){
			
			if (isWhiteTurn) {
				System.out.println("White's move: ");
				//DecodeInput(scan.nextLine());
				convertInput(scan.nextLine());
				turn ="Black";
				
			} else {
				System.out.println("Black's move: ");
				//DecodeInput(scan.nextLine());
				convertInput(scan.nextLine());
				turn = "White";
			}
		};
/* 
		while (scan.next() == "resign") {
			System.out.print("White's Move");
			scan.next();
			System.out.print("Black's move: ");
		}*/
		System.out.println("Game end");
	}


	private void DecodeInput(String s){

		String[] inputs = s.split(" ");
		String start = inputs[0];
		String end = inputs[1];
		

		// Convert the starting square (e4) into coordinates (4, 3)
		int startY = start.charAt(0) - 'a';
		int startX = 8 - Integer.parseInt(start.substring(1));

		// Convert the ending square (e7) into coordinates (4, 6)
		int endY = end.charAt(0) - 'a';
		int endX = 8 - Integer.parseInt(end.substring(1));
			   

		if(inputs.length == 3){
			
			String upgrade;
			if (inputs[2].equalsIgnoreCase("resign")){
				run= false;
				//System.out.print(  win()+ " win");
			}else if (inputs[2].equalsIgnoreCase("Draw?")){
				run = false ; 
				System.out.print("Draw");
			}
			else if (inputs[2].equalsIgnoreCase("B")){
			 	upgrade ="B";
			 	//DecodeInput(start+" "+end);
			 } else if (inputs[2].equalsIgnoreCase("Q")){
			 	upgrade = "Q";
			 	//DecodeInput(start+" "+end);
			 }else if ( inputs[2].equalsIgnoreCase("R")){
			 	upgrade = "R";

			 	//DecodeInput(start+" "+end);
			 }else if ( inputs[2].equalsIgnoreCase("N")){
			 	upgrade= "N";
			 	//DecodeInput(start+" "+end);
			 }
			 

			else {
	
			
				try {
					if(board.getSpot(startX,startY).getPiece().canMove(board.getSpot(startX, startY), board.getSpot(endX, endY), board)){
						if (board.getSpot(startX,startY).getPiece().isWhite()== isWhiteTurn){
							board.setPosition(startX, startY, endX, endY, isWhiteTurn);
							if (board.isInCheck(!isWhiteTurn, board.boardSpots)) {
								System.out.println("Check!");
							}
							if(board.isCheckmate(!isWhiteTurn)){
								System.out.println("Checkmate!");
								System.out.print("Game over");
								//System.out.println( win() + " win");
								run= false; 
							}
							isWhiteTurn = !isWhiteTurn;
						}
						else{
							System.out.println("invalid move. it's "+ turn + " turn");
							DecodeInput(scan.nextLine());
						}
						System.out.println("It reaches here.");
				} else {
						System.out.println("Invalid move");
						DecodeInput(scan.nextLine());
				}
				
						
			} catch (Exception e) {
				System.out.println("No Chess pieces found, try again ");
				DecodeInput(scan.nextLine());
			}
		} 	
			} else {
			System.out.println("Invalid input, try again");
			DecodeInput(scan.nextLine());
			}
		}
	
	public String win(boolean isWhiteTurn){
		if (isWhiteTurn){
			return "Black";
		} else{
			return "White";
		}
	}


	private void convertInput(String s){
		String input = s.trim();
		String start;
		String end;
		String promote;
		String[] parts;
 
		parts = input.split(" ");
		start = parts[0];
		end = parts[1];
		promote = "";
		if(parts.length == 3){
			promote = parts[2];
		}
		// Convert the starting square (e4) into coordinates (4, 3)
		//System.out.println("This is input: start-" + start + " end-" + end + " promotion-" + promotion + ".");
		int startY = start.charAt(0) - 'a';
		int startX = 8 - Integer.parseInt(start.substring(1));
			
		// Convert the ending square (e7) into coordinates (4, 6)
		int endY = end.charAt(0) - 'a';
		int endX = 8 - Integer.parseInt(end.substring(1));
					
		ChessPieces piece = board.getSpot(startX, endY).getPiece();

		if(promote.toLowerCase().compareTo("resign") == 0){
			run = false;
		} else if(promote.toLowerCase().compareTo("draw?") == 0){
			if(board.getSpot(startX,startY).getPiece().canMove(board.getSpot(startX,startY), board.getSpot(endX,endY), board)){
				run = false;
				System.out.println("Draw");
			} else {
				System.out.println("Invalid Input. Try Again");
				convertInput(scan.next());
			}
		} else if(parts.length == 3 && board.getSpot(startX, startY).getPiece() instanceof Pawn && endX == (piece.isWhite() ? 0 : 7) && (parts[2].equals("N") || (parts[2].equals("B") || parts[2].equals("R") || parts[2].equals("Q")))){
			board.promotePawn(board.getSpot(startX, startY), board.getSpot(endX, endY), promote);
		} else if(parts.length == 2){
				try {
					System.out.println("startX, startY " + startX + ", " + startY);
					if (board.getSpot(startX, startY).getPiece() instanceof Pawn && endX == (piece.isWhite() ? 0 : 7)) {
						board.promotePawn(board.getSpot(startX, startY), board.getSpot(endX, endY), promote);
						board.draw();
						isWhiteTurn = !isWhiteTurn;
					} else {
						board.setPosition(startX, startY, endX, endY, isWhiteTurn);
						if(board.isCheckmate(!isWhiteTurn)){
							run = false;
							System.out.println( win(!isWhiteTurn) + " win");
						}
						isWhiteTurn = !isWhiteTurn;
					}					
					} catch (IllegalArgumentException e) {
						System.out.println("Invalid Move. Try Again.");
						convertInput(scan.nextLine());
					} catch (NullPointerException e) {
						System.out.println("No Piece in that Spot. Try Again");
						convertInput(scan.nextLine());
					} 
			} else {
					System.out.print("Invalid Input. Try Again: ");
					convertInput(scan.nextLine());
			}
		}		
} 

	
	