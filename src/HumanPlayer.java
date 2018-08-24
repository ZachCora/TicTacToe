import java.util.*;


public class HumanPlayer extends Player {
	
	public HumanPlayer(char t) {
		this.setToken(t);
		this.setName("" + t);
	}
	
	public HumanPlayer(char t, String s) {
		this.setToken(t);
		this.setName(s);
	}

	@Override
	public int[] getMove(Board b) {
		int[] move = new int[2];
		Scanner scan = new Scanner(System.in);
		while(move[0]==0) {
			int[] temp = new int[2];
			System.out.println("Please enter row and column of your move, (either one at a time, or separated by spaces):");
			try {
				temp[0] = scan.nextInt();
				temp[1] = scan.nextInt();
			}catch(Exception e) {
				System.out.println("Invalid Input: not an integer. Please try again.");
				return getMove(b);
			}
			//System.out.printf("Move: %d %d%n", temp[0], temp[1]);
			if(temp[0]<1||temp[0]>3||temp[1]<1||temp[1]>3) {
				System.out.println("Invalid row and/or column. Numbers must range from 1 to 3.");
				continue;
			}else if(b.getValue(temp[0], temp[1])!=' ') {
				System.out.println("That spot is already taken!");
				continue;
			}else {
				move = temp;
			}			
		}
		return move;		
	}
}