package saved;

//import java.lang.reflect.Array;

public class Board {

	public void draw() {
		
		for( int i = 0 ; i < 8 ; i++) {
			if ( i == 0) {
				System.out.println("-------------------------------------------------------------------------");
			}else {
				System.out.println("|--------+--------+--------+--------+--------+--------+--------+--------|");
			}
			
			for ( int j = 0; j < 9 ; j++) {
				if ( j ==8) {
					System.out.println("|        ");
				}else {
					System.out.print("|        ");
				}
	
			}
		}
		
		System.out.println("-------------------------------------------------------------------------");
	}
	
}
