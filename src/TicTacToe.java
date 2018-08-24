import java.awt.Canvas;
import java.awt.Color;
import java.util.Scanner;

import javax.swing.JFrame;

public class TicTacToe {
	
	public static String getName(Scanner scan, String p) {
		System.out.printf("Please enter name of Player %s (Limit 8 chars):%n", p);
		String input = scan.next().trim();
		if(input.length()>8) {
			System.out.println("Name too long.");
			return getName(scan, p);
		}else if(input.length()==0) {
			System.out.println("Please enter a name.");
			return getName(scan, p);
		}else {
			return input;
		}
	}

	public static void main(String[] args) {
		System.out.println("Welcome to TicTacToe!");
		System.out.println();
		Board board = new Board();
		Player[] players = new Player[2];
		Scanner scan = new Scanner(System.in);
		String input = getName(scan, "One");
		players[0] = new HumanPlayer('X', input);
		input = getName(scan, "Two");
		players[1] = new HumanPlayer('O', input);
		
		Game game = new Game(board, players);
		
		JFrame frame = new JFrame("Game Board");
		frame.setAlwaysOnTop(true);
        Canvas canvas = new GUI(game);
        canvas.setSize(700, 600);
        canvas.setBackground(Color.white);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
        
		game.setCanvas(canvas);		
		game.PlayGame();
			
		while(true) {
			System.out.println("Would you like to play again? (yes or no)");
			String entry = scan.nextLine().trim().toLowerCase();
			if(entry.equals("yes")) {
				board.resetBoard();
				game.PlayGame();
			}else if(!entry.equals("no")) {
				System.out.println("Please enter yes or no.");
			}else {
				break;
			}
		}
		scan.close();
		System.out.println("Thank you for playing TicTacToe!");		
	}
}