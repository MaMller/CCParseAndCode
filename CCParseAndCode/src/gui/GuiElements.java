package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class GuiElements {
	
	private static Frame window = null;
	private static TextArea logOutput = null;
	private static TextArea statusOutput = null;
	private static TextArea timeNow = null;
	private static TextArea windowStatus = null;
	private static TextArea lastCode = null;
	
	public GuiElements(JFrame window){
		// Elemente die Referenz benötigen initiieren
		GuiElements.statusOutput = statusInit();
		GuiElements.logOutput = logOutputInit();
		GuiElements.timeNow = timeNow();
		GuiElements.windowStatus = windowStatus();
		GuiElements.lastCode = lastCode();
		
		Container c = window.getContentPane();
		c.setLayout(new BorderLayout());
		// c.add(log);
		// Menu
		JPanel jPanel = new JPanel();
		JMenuBar mbar = new JMenuBar();
		mbar.add(new JMenu("Datei"));
		JMenu helpMenu = new JMenu("Hilfe");
		mbar.add(helpMenu);
		// mbar.setHelpMenu(helpMenu);
		
		window.setJMenuBar(mbar);	
		
		
		// jPanel.add(mbar);
		
		
		// c.add(jPanel,BorderLayout.NORTH);
		c.add(GuiElements.logOutput,BorderLayout.EAST );
	    Container c2 = new Container();
	    c2.setLayout(new GridLayout(4, 1));
	    c2.add(GuiElements.timeNow);
	    c2.add(GuiElements.windowStatus);
	    c2.add(GuiElements.lastCode);
	    //c2.add(new JButton("Test4"));
	    
	    c.add(c2, BorderLayout.WEST);
	    
		// c.add(GuiElements.statusOutput,BorderLayout.WEST);
		//GuiElements.window = window;
		
	}
	
	
	
	private static TextArea lastCode()  {
		TextArea txtArea = new TextArea(null,0,0,TextArea.SCROLLBARS_NONE);
		txtArea.setEditable(false);
		txtArea.setBackground(java.awt.Color.WHITE);
		return txtArea;
	}
	
	private static TextArea windowStatus()  {
		TextArea txtArea = new TextArea(null,0,0,TextArea.SCROLLBARS_NONE);
		txtArea.setEditable(false);
		txtArea.setBackground(java.awt.Color.WHITE);
		return txtArea;
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
		TextArea txtArea = new TextArea(null,0,0, TextArea.SCROLLBARS_VERTICAL_ONLY);
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
	
	public static void setWindowStatus(String status)  {
		windowStatus.setText(status);
	}
	
	public static void setLastCode(String code)  {
		lastCode.setText(code);
	}
}
