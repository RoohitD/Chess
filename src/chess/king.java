package chess;

import java.util.Arrays;
import java.util.Comparator;

public class king extends ChessPieces implements Comparable<ChessPieces>{
	char type = 'k';
	
	

	public king(String color, String location, String type) {
		super(color, location, type);		
	}


	public void move(String s) {
		
	}


	@Override
	public int compareTo(ChessPieces o) {
		return 0;
	}


	@Override
	public void buildMoveablelist() {
		// TODO Auto-generated method stub
		
	}




}
