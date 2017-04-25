import java.applet.Applet;
import java.awt.Canvas;
import java.awt.Graphics;

public class MainCanvas extends Applet {
	Graphics g;
	private String text = "Test"; 
	
	public void paint(Graphics g)  {
		g.drawString(text, 20, 20);
		this.g = g;
	}
	
	public void setText(String text)  {
		this.text = text;
	}
	
	public void repaint()  {
		g.notify();
	}
	
	

}
