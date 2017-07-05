package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GuiElements {
	
	private static Frame window = null;
	private static TextArea logOutput = null;
	private static TextArea statusOutput = null;
	private static TextArea timeNow = null;
	
	public GuiElements(JFrame window){
		GuiElements.statusOutput = statusInit();
		GuiElements.logOutput = logOutputInit();
		GuiElements.timeNow = timeNow();
		
		Container c = window.getContentPane();
		c.setLayout(new BorderLayout());
		// c.add(log);
		
		c.add(GuiElements.panel(),BorderLayout.NORTH);
		c.add(GuiElements.logOutput,BorderLayout.EAST );
	    Container c2 = new Container();
	    c2.setLayout(new GridLayout(4, 1));
	    c2.add(GuiElements.timeNow);
	    c2.add(new JButton("Test2"));
	    c2.add(new JButton("Test3"));
	    c2.add(new JButton("Test4"));
	    
	    c.add(c2, BorderLayout.WEST);
	    
		// c.add(GuiElements.statusOutput,BorderLayout.WEST);
		//GuiElements.window = window;
		
	}
	
	private static JPanel panel()  {
		JPanel panel = new JPanel();
		return panel;
	}
	
	private static TextArea timeNow()  {
		TextArea txtArea = new TextArea(null,0,0,TextArea.SCROLLBARS_NONE);
		txtArea.setEditable(false);
		txtArea.setBackground(java.awt.Color.WHITE);
		return txtArea;
	}
	
	private static TextArea statusInit(){
		TextArea txtArea = new TextArea(null,0,0, TextArea.SCROLLBARS_NONE);
		txtArea.setEditable(false);
		txtArea.setBackground(java.awt.Color.WHITE);
		// window.add(txtArea,BorderLayout.EAST);
		return txtArea;
	}
	
	private static TextArea logOutputInit(){
		TextArea txtArea = new TextArea(null,0,0, TextArea.SCROLLBARS_NONE);
		txtArea.setEditable(false);
		txtArea.setBackground(java.awt.Color.WHITE);
		// window.add(txtArea,BorderLayout.EAST);
		return txtArea;
	}
	
	public static void setLogOutput(String log){
		logOutput.setText(log);
	}
	
	public static void addToLogOutput(String log)  {
		logOutput.setText(logOutput.getText() + "\n" + log);
	}
	
	public static void setStatus(String status)  {
		statusOutput.setText(status);
	}
	
	public static void setTimeNow(String time)  {
		timeNow.setText(time);
	}
}
