package chess;

import java.util.Arrays;

public abstract class ChessPieces {
	String color; 
	String location;
	String type;
	int moveablelist[][];
	
	
	
	public ChessPieces(String color, String location, String type) {
		this.color = color;
		this.location = location;
		this.type= type;
	}
	
	public ChessPieces() {
		
	}
	
	
	public abstract void buildMoveablelist();

	
}
