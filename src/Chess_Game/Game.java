package Chess_Game;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

import Pieces.ChessPieces;
import Pieces.King;
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
	boolean boolturn = true;
	String upgrade;
	

	public Game(){
		board.draw();
		//upgradePawn();
		startGame();
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


	private void DecodeInput(String s){

		String[] inputs = s.split(" ");
		String start ;
		String end ;


		if(inputs.length == 3){
			start = inputs[0];
			end = inputs[1];


			if (inputs[2].equalsIgnoreCase("resign")){
				run= false;
				System.out.print(  win()+ " win");
			}else if (inputs[2].equalsIgnoreCase("Draw?")){
				run = false ; 
				System.out.print("Draw");
			}
			//else if (inputs[2].equalsIgnoreCase("B")){
			// 	upgrade ="B";
				
			// 	DecodeInput(start+" "+end);
			// } else if (inputs[2].equalsIgnoreCase("Q")){
			// 	upgrade = "Q";
			// 	start = inputs[0];
			//  	end = inputs[1];
			// 	DecodeInput(start+" "+end);
			// }else if ( inputs[2].equalsIgnoreCase("R")){
			// 	upgrade = "R";
			// 	start = inputs[0];
			//  	end = inputs[1];
			// 	DecodeInput(start+" "+end);
			// }else if ( inputs[2].equalsIgnoreCase("N")){
			// 	upgrade= "N";
			// 	start = inputs[0];
			//  	end = inputs[1];
			// 	DecodeInput(start+" "+end);
			// }

			else {

			// 	// Convert the starting square (e4) into coordinates (4, 3)
			// int startY = start.charAt(0) - 'a';
			 int startX = 8 - Integer.parseInt(start.substring(1));

			// // Convert the ending square (e7) into coordinates (4, 6)
			// int endY = end.charAt(0) - 'a';
			// int endX = 8 - Integer.parseInt(end.substring(1));

			// 	System.out.println(startX);
			// 	System.out.println(startY);
			// 	System.out.println(endX);
			// 	System.out.println(endY);
				
				
				if (( boolturn) && (startX== 6)){

					if (inputs[2].equalsIgnoreCase("B")){
							upgrade ="B";
							System.out.println(upgrade + " upgraded");
							

						} else if (inputs[2].equalsIgnoreCase("Q")){
							upgrade = "Q";
							System.out.println(upgrade + " upgraded");

						}else if ( inputs[2].equalsIgnoreCase("R")){
							upgrade = "R";
							System.out.println(upgrade + " upgraded");

						}else if ( inputs[2].equalsIgnoreCase("N")){
							upgrade= "N";
							System.out.println(upgrade + " upgraded");
						}

				}else if (( boolturn ) && (startX== 6) ){

					if (inputs[2].equalsIgnoreCase("B")){
							upgrade ="B";
							System.out.println(upgrade + " upgraded");
						} else if (inputs[2].equalsIgnoreCase("Q")){
							upgrade = "Q";
							System.out.println(upgrade + " upgraded");
						}else if ( inputs[2].equalsIgnoreCase("R")){
							upgrade = "R";
							System.out.println(upgrade + " upgraded");
						}else if ( inputs[2].equalsIgnoreCase("N")){
							upgrade= "N";
							System.out.println(upgrade + " upgraded");
						}
				}else {
					System.out.println("do you meant Draw?, resign ");
					DecodeInput(scan.nextLine());
				}

				//System.out.println("do you meant Draw?, resign ");
				//DecodeInput(scan.nextLine());
			}


		}else if ( inputs.length == 2){
			
			// setting the values
			 start = inputs[0];
			 end = inputs[1];

			// check if the input is valid

			if(start.length() != 2 || end.length() !=2){
				System.out.println("Invalid input");
				startGame();
				// while(run){
				// 	DecodeInput(scan.nextLine());
				// }
			}

			// Convert the starting square (e4) into coordinates (4, 3)
			int startY = start.charAt(0) - 'a';
			int startX = 8 - Integer.parseInt(start.substring(1));

			// Convert the ending square (e7) into coordinates (4, 6)
			int endY = end.charAt(0) - 'a';
			int endX = 8 - Integer.parseInt(end.substring(1));


			if (( boolturn) && (startX== 6)){
				System.out.println("please type the promotion as well");
				DecodeInput(scan.nextLine());
			}else if ( (boolturn == false) && ( startX == 1)){
				System.out.println("please type the promotion as well");
				DecodeInput(scan.nextLine());
			}

			try {
				if(board.getSpot(startX,startY).getPiece().canMove(board.getSpot(startX, startY), board.getSpot(endX, endY), board.boardSpots)){

					if (board.getSpot(startX,startY).getPiece().isWhite()== boolturn){
						board.setPosition(startX, startY, endX, endY, upgrade, boolturn);
						

						if (board.isInCheck(!boolturn, board.boardSpots)) {
							System.out.println("Check!");
						}
						if(board.isCheckmate(!boolturn)){
							System.out.println("Checkmate!");
							System.out.print("Game over");
							System.out.println( win() + " win");
							run= false; 
						}
						boolturn = !boolturn;
					}
					else{
						System.out.println("invalid move. it's "+ turn + " turn");
						DecodeInput(scan.nextLine());
					}
					
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


	
	public String  win(){
		if ( turn == "white"){
		return "black";
		}else{
		return "white";
		}
	}

/*	
 

	public void upgradePawn(){
		
		System.out.println("please upgrade the pawn");
		System.out.println("Give location of the pawn and type: \n N for Knight \n Q for Queen \n B for Bishop \n R for Rook ");
		String s = scan.nextLine();
		String[] inputs = s.split(" ");
		String start ;
		String end ;
		char upgrade= 'a';

		if(inputs.length == 3){

			start = inputs[0];
			end = inputs[1];
			if (inputs[2].equalsIgnoreCase("B")){
				upgrade ='B';
			}else if (inputs[2].equalsIgnoreCase("Q")){
				upgrade = 'Q';
			}else if ( inputs[2].equalsIgnoreCase("R")){
				upgrade = 'R';
			}else if ( inputs[2].equalsIgnoreCase("N")){
				upgrade= 'N';
			}else {
				System.out.println(" invalid input, try agian");
				upgradePawn();
			}

			// Convert the starting square (e4) into coordinates (4, 3)
			int startY = start.charAt(0) - 'a';
			int startX = 8 - Integer.parseInt(start.substring(1));

			// Convert the ending square (e7) into coordinates (4, 6)
			int endY = end.charAt(0) - 'a';
			int endX = 8 - Integer.parseInt(end.substring(1));
			
			System.out.println("Startx " + startX + " StartY " + startY +"\n");
			System.out.println("endx "+ endX + " endY " + endY +"\n");
			System.out.println(upgrade);
		}else {
			System.out.println("invalid input try agian");
			upgradePawn();
		}
	
	}
	
 */
}
	
	