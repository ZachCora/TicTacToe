import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class GUI extends Canvas {

	private Game game;
	
	public GUI(Game g) {
		this.game = g;
	}
	
	int xOffset = 0;
	int yOffset = 0;
	
	public void paint(Graphics g) {
		g.setColor(Color.black);
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setStroke(new BasicStroke(6, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		g2d.drawLine(300, 50, 300, 350);
		g2d.drawLine(400, 50, 400, 350);
		g2d.drawLine(200, 150, 500, 150);
		g2d.drawLine(200, 250, 500, 250);
		g.setColor(Color.RED);
	
		g.setFont(new Font("Font", Font.PLAIN, 35));
		
		g.setColor(Color.black);
		String n1 = game.getPlayers()[0].getName();
		g.drawString(n1, 9, 41);
		g.drawString(n1, 9, 39);
		g.drawString(n1, 11, 41);
		g.drawString(n1, 11, 39);
		g.setColor(Color.red);		
		g.drawString(n1, 10, 40);
		
		g.setColor(Color.black);
		String n2 = game.getPlayers()[1].getName();
		g.drawString(n2, 509, 41);
		g.drawString(n2, 509, 39);
		g.drawString(n2, 511, 41);
		g.drawString(n2, 511, 39);
		g.setColor(Color.blue);			
		g.drawString(n2, 510, 40);
		
		g.setColor(Color.black);
		g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		g.drawString("Wins", 60, 100);		
		g2d.drawLine(60, 105, 140, 105);
		g.drawString("Wins", 560, 100);		
		g2d.drawLine(560, 105, 640, 105);
		g.setFont(new Font("Font", Font.PLAIN, 50));
		String xWins = String.valueOf(game.getWinsX());
		String t = new String(new char[3-xWins.length()]).replace("\0", "0");
		g.drawString(t + xWins, 60, 150);
		String oWins = String.valueOf(game.getWinsO());
		t = new String(new char[3-oWins.length()]).replace("\0", "0");
		g.drawString(t + oWins, 560, 150);
		
		drawBoard(g);
		
		drawToken(g, String.valueOf(game.getPlayers()[game.getTurn()].getToken()), 4, 2);
		
		int status = game.getStatus();
		if(status==1) {
			g.setColor(Color.black);
			g.setFont(new Font("Font", Font.PLAIN, 60));
			String s = game.getPlayers()[0].getName() + " Wins!";
			g.drawString(s, 199, 519);
			g.drawString(s, 199, 521);
			g.drawString(s, 201, 519);
			g.drawString(s, 201, 521);
			g.setColor(Color.red);		
			g.drawString(s, 200, 520);
		}else if(status==2) {
			g.setColor(Color.black);
			g.setFont(new Font("Font", Font.PLAIN, 60));
			String s = game.getPlayers()[1].getName() + " Wins!";
			g.drawString(s, 199, 519);
			g.drawString(s, 199, 521);
			g.drawString(s, 201, 519);
			g.drawString(s, 201, 521);
			g.setColor(Color.blue);		
			g.drawString(s, 200, 520);
		}else if(status==3) {
			g.setColor(Color.black);
			g.setFont(new Font("Font", Font.PLAIN, 60));
			String s = "Tie Game!";		
			g.drawString(s, 200, 520);
		}
		
	}
	
	public void drawToken(Graphics g, String c, int row, int col) {
		int x = 200 + (100 * (col-1));
		int y = 135 + (100 * (row-1));
		if(c.equals("X")) {
			g.setColor(Color.RED);
			g.drawString(c, x+16, y);
		}else if(c.equals("O")) {
			g.setColor(Color.BLUE);
			g.drawString(c, x+11, y);
		}
	}
	
	public void drawBoard(Graphics g) {
		g.setFont(new Font("Font", Font.PLAIN, 100));
		for(int row = 1;row < 4;row++) {
			for(int col = 1;col<4;col++) {
				drawToken(g, String.valueOf(game.getBoard().getValue(row, col)), row, col);
			}
		}
	}	
}