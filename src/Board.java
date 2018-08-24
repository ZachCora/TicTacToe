import java.util.HashMap;

public class Board {
	
	private char[][] board;
	private HashMap<Character, Integer> map = new HashMap<>();
	
	public Board() {
		this.board = new char[3][3];
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				this.board[i][j] = ' ';
			}
		}
		map.put('X',  1);
		map.put('O',  2);
	}
	
	public void resetBoard() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				this.board[i][j] = ' ';
			}
		}
	}
	
	protected char getValue(int x, int y) {
		return this.board[x-1][y-1];
	}
	
	protected void setValue(int x, int y, char c) {
		this.board[x-1][y-1] = c;
	}
	
	public void printBoard() {
		System.out.printf(" %c | %c | %c %n---+---+---%n %c | %c | %c %n---+---+---%n %c | %c | %c %n",
				board[0][0],
				board[0][1],
				board[0][2],
				board[1][0],
				board[1][1],
				board[1][2],
				board[2][0],
				board[2][1],
				board[2][2]);
	}
	
	public boolean isFull() {
		for(char[] row : board) {
			for(char c: row) {
				if(c == ' ') {
					return false;
				}
			}
		}
		return true;
	}
	
	public int findWinner() {
		if(board[0][0]==board[0][1]&&board[0][1]==board[0][2]&&board[0][0]!=' ') {
			return map.get(board[0][0]);
		}
		if(board[1][0]==board[1][1]&&board[1][1]==board[1][2]&&board[1][0]!=' ') {
			return map.get(board[1][0]);
		}
		if(board[2][0]==board[2][1]&&board[2][1]==board[2][2]&&board[2][0]!=' ') {
			return map.get(board[2][0]);
		}
		if(board[0][0]==board[1][0]&&board[1][0]==board[2][0]&&board[0][0]!=' ') {
			return map.get(board[0][0]);
		}
		if(board[0][1]==board[1][1]&&board[1][1]==board[2][1]&&board[0][1]!=' ') {
			return map.get(board[0][1]);
		}
		if(board[0][2]==board[1][2]&&board[1][2]==board[2][2]&&board[0][2]!=' ') {
			return map.get(board[0][2]);
		}
		if(board[0][0]==board[1][1]&&board[1][1]==board[2][2]&&board[0][0]!=' ') {
			return map.get(board[0][0]);
		}
		if(board[0][2]==board[1][1]&&board[1][1]==board[2][0]&&board[0][2]!=' ') {
			return map.get(board[0][2]);
		}
		else return 0;
	}
}
