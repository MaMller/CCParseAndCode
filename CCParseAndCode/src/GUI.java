//Comment out the following package statement to compile separately.


/**
 * Example01 illustrates some basics of Java 2D.
 * This version is compliant with Java 1.2 Beta 3, Jun 1998.
 * Please refer to: <BR>
 * http://www.javaworld.com/javaworld/jw-07-1998/jw-07-media.html
 * <P>
 * @author Bill Day <bill.day@javaworld.com>
 * @version 1.0
 * @see java.awt.Graphics2D
**/

import java.awt.*;
import java.awt.event.*;

public class GUI extends Frame {
	private static final String windowTitle = "CCParseAndCode";
	private String text = "Text";
	private String anwesenheitsKontrolleActive = "Noch kein String";
  
  public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
		this.update(getGraphics());
	}

/**
   * Our Example01 constructor sets the frame's size, adds the
   * visual components, and then makes them visible to the user.
   * It uses an adapter class to deal with the user closing
   * the frame.
   **/
  public GUI() {
    //Title our frame.
    super(windowTitle);

    //Set the size for the frame.
    setSize(400,300); 

    //We need to turn on the visibility of our frame
    //by setting the Visible parameter to true.
    setVisible(true);

    //Now, we want to be sure we properly dispose of resources 
    //this frame is using when the window is closed.  We use 
    //an anonymous inner class adapter for this.
    addWindowListener(new WindowAdapter() 
      {public void windowClosing(WindowEvent e) 
         {dispose(); System.exit(0);}  
      }
    );
  }

  /**
   * The paint method provides the real magic.  Here we
   * cast the Graphics object to Graphics2D to illustrate
   * that we may use the same old graphics capabilities with
   * Graphics2D that we are used to using with Graphics.
   **/
  public void paint(Graphics g) {
    
    g.setColor(Color.red);
    // g.drawRect(50,50,200,200);
    g.drawString(text, 50, 50);
    g.drawString(anwesenheitsKontrolleActive, 50, 70);
  }

public String getAnwesenheitsKontrolleActive() {
	return anwesenheitsKontrolleActive;
}

public void setAnwesenheitsKontrolleActive(String anwesenheitsKontrolleActive) {
	this.anwesenheitsKontrolleActive = anwesenheitsKontrolleActive;
	this.update(getGraphics());
}
}