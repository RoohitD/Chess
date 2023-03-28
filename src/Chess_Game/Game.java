package Chess_Game;


import java.util.Scanner;
import Pieces.ChessPieces;
import Pieces.Pawn;

/**
 * this is where game really start. user puts the input and it gets converted and move pieces accordingly
 * @author Rohit and Basu 
 * @method 
 * <ul> startGame 
 * <li> convertInput
 * <li> win
 * 
 * 
 */
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


	/**
	 * This method craetes a Game constructor that draws the board and starts the game
	 */
	public Game(){
		board.draw();
		//upgradePawn();
		startGame();
	}
	
	//-------------------------------------------------------
	// start game 
	/**
	 * this is where the game start. it will be callled after the game start.
	 */
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
		System.out.println("Game end");
	}

	
	/**
	 * This method prints the winner of the match
	 * @param isWhiteTurn
	 * @return String
	 */
	public String win(boolean isWhiteTurn){
		if (isWhiteTurn){
			return "Black";
		} else{
			return "White";
		}
	}

/**
 * convet the user input into the number and move the pieces accordingly in the array list
 * @param s user inputs 
 */
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

	
	