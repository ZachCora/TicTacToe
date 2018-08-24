import java.awt.Canvas;

public class Game {
	
	private Board board;
	private Player[] players = new Player[2];
	private Canvas canvas;
	private int turn = 0;
	private int status = 0;
	private int xWins = 0;
	private int oWins = 0;
	
	public Game(Board b, Player[] p) {
		this.board = b;
		this.players=p;
	}
	
	public Board getBoard() {
		return this.board;
	}	
	public Player[] getPlayers() {
		return this.players;
	}
	public int getTurn() {
		return this.turn;
	}
	public int getStatus() {
		return this.status;
	}
	public int getWinsX() {
		return this.xWins;
	}
	public int getWinsO() {
		return this.oWins;
	}
	
	public void setCanvas(Canvas c) {
		this.canvas = c;
	}
	
	public void PlayGame() {			
		turn = 0;
		status = 0;
		while(true) {
			//board.printBoard();
			canvas.repaint();
			int gameWon = board.findWinner();
			if(gameWon==1) {
				//System.out.printf("%s Wins!%n", players[0].getName());
				status = 1;
				xWins += 1;
				break;
			}else if(gameWon==2) {
				//System.out.printf("%s Wins!%n", players[1].getName());
				status = 2;
				oWins += 1;
				break;
			}else if(board.isFull()){
				//System.out.println("Tie Game!");
				status = 3;
				break;
			}else {
				//System.out.printf("It is now %s's turn.%n", players[turn].getName());
				int[] move = players[turn].getMove(board);
				board.setValue(move[0], move[1], players[turn].getToken());
				turn = 1-turn;
			}			
		}		
	}
}