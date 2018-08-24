
public abstract class Player {
	
	private String name;
	private char token;
	
	abstract public int[] getMove(Board b);
	
	protected char getToken() {
		return this.token;
	}	
	protected void setToken(char c) {
		this.token = c;
	}
	
	protected String getName() {
		return this.name;
	}
	protected void setName(String s) {
		this.name = s;
	}
}
