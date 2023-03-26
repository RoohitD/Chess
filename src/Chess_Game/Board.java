package Chess_Game;

import java.util.ArrayList;
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
		
	Spot[][] boardSpots;

	ArrayList<Spot> killedWSpots = new ArrayList<Spot>();
	ArrayList<Spot> killedBSpots = new ArrayList<Spot>();

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
				boardSpots[6][i] = new Spot(6, i, new Pawn(true));
			}
			boardSpots[7][0] = new Spot(7, 0, new Rook(true));
        	boardSpots[7][1] = new Spot(7, 1, new Knight(true));
        	boardSpots[7][2] = new Spot(7, 2, new Bishop(true));
			boardSpots[7][3] = new Spot(7, 3, new Queen(true));
			boardSpots[7][4] = new Spot(7, 4, new King(true));
			boardSpots[7][5] = new Spot(7, 5, new Bishop(true));
			boardSpots[7][6] = new Spot(7, 6, new Knight(true));
			boardSpots[7][7] = new Spot(7, 7, new Rook(true));
			
	}
	
	// Method to draw the Chess board
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
	
	public void setPosition(int startX, int startY, int endX, int endY, String upgrade, boolean boolturn){
		if(boardSpots[startX][startY].getPiece() instanceof King && ((King) boardSpots[startX][startY].getPiece()).hasMoved() == false){
			castle(startX, startY, endX, endY);
			System.out.println("");
			draw();
		} else if (boardSpots[startX][startY].getPiece() instanceof Pawn && boardSpots[startX][startY].getPiece().isWhite() == boolturn && endY == 7 || endY == 0) {
			promotePawn(boardSpots[startX][startY], boardSpots[endX][endY], upgrade);
		} else {
			movePiece(startX, startY, endX, endY);
		}
			
	}

	public boolean isInCheck(boolean isWhite, Spot[][] board) {
		// Find the position of the king
		int kingX = -1, kingY = -1;
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				ChessPieces piece = board[i][j].getPiece();
				if(piece != null && piece instanceof King && piece.isWhite() == isWhite) {
					kingX = i;
					kingY = j;
					break;
				}
			}
		}
		if(kingX == -1 || kingY == -1) {
			// The king is not on the board
			return false;
		}
		// Check if any opposing piece is attacking the king
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				ChessPieces piece = board[i][j].getPiece();
				if(piece != null && piece.isWhite() != isWhite && piece.canMove(board[i][j], board[kingX][kingY], board)) {
					return true;
				}
			}
		}
		// The king is not in check
		return false;
	}
	
	public void movePiece(int startX, int startY, int endX, int endY){
			boardSpots[endX][endY].setPiece(boardSpots[startX][startY].getPiece());
			boardSpots[startX][startY].setPiece(null);
			System.out.println("");
			draw();
	}


	public boolean isCheckmate(boolean isWhite) {
		// Check if the King is in check
		if (!isInCheck(isWhite, boardSpots)) {
			return false;
		}
	
		// Look for any possible moves that would get the King out of check
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Spot startSpot = boardSpots[i][j];
				ChessPieces piece = startSpot.getPiece();
	
				// Check if the piece belongs to the player whose King is in check
				if (piece != null && piece.isWhite() == isWhite) {
					// Check all possible moves for this piece
					for (int x = 0; x < 8; x++) {
						for (int y = 0; y < 8; y++) {
							Spot endSpot = boardSpots[x][y];
	
							// Check if the move is legal
							if (piece.canMove(startSpot, endSpot, boardSpots)) {
								// Try making the move
								ChessPieces capturedPiece = endSpot.getPiece();
								endSpot.setPiece(piece);
								startSpot.setPiece(null);
	
								// Check if the King is still in check after the move
								boolean kingInCheck = isInCheck(isWhite, boardSpots);
	
								// Undo the move
								startSpot.setPiece(piece);
								endSpot.setPiece(capturedPiece);
	
								// If the King is no longer in check, the player is not in checkmate
								if (!kingInCheck) {
									return false;
								}
							}
						}
					}
				}
			}
		}
	
		// If no move can get the King out of check, the player is in checkmate
		return true;
	}

	public void promotePawn(Spot startSpot, Spot endSpot, String promotionPieceType){
			// Create the new piece based on the promotion piece type
			ChessPieces newPiece;
			switch(promotionPieceType) {
				case "Q":
					newPiece = new Queen(startSpot.getPiece().isWhite());
					break;
				case "B":
					newPiece = new Bishop(startSpot.getPiece().isWhite());
					break;
				case "N":
					newPiece = new Knight(startSpot.getPiece().isWhite());
					break;
				case "R":
					newPiece = new Rook(startSpot.getPiece().isWhite());
					break;
				default:
                throw new IllegalArgumentException("Invalid promotion piece type");
			}
			// Replace the pawn with the new piece at the end spot
			endSpot.setPiece(newPiece);
			startSpot.setPiece(null);
		}

	

	


	public void castle(int startX, int startY, int endX, int endY){
			boardSpots[endX][endY].setPiece(boardSpots[startX][startY].getPiece());
			boardSpots[startX][startY].setPiece(null);
			// Move the rook
			Spot rookStartSpot, rookEndSpot;
			if (endY == 2) {
				// Queenside castle
				rookStartSpot = getSpot(startX, 0);
				rookEndSpot = getSpot(startX, 3);
			} else {
				// Kingside castle
				rookStartSpot = getSpot(startX, 7);
				rookEndSpot = getSpot(startX, 5);
			}
			boardSpots[rookEndSpot.getX()][rookEndSpot.getY()].setPiece(boardSpots[rookStartSpot.getX()][rookStartSpot.getY()].getPiece());
			boardSpots[rookStartSpot.getX()][rookStartSpot.getY()].setPiece(null);
	}

}