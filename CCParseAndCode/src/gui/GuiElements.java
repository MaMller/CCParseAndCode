package gui;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.TextArea;

public class GuiElements {
	
	private static Frame window = null;
	private static TextArea logOutput = null;
	
	public GuiElements(Frame window){
		GuiElements.window = window;
		GuiElements.logOutput = logOutputInit();
	}
	
	private static TextArea logOutputInit(){
		TextArea txtArea = new TextArea(null,0,0, TextArea.SCROLLBARS_NONE);
		txtArea.setEditable(false);
		txtArea.setBackground(java.awt.Color.WHITE);
		window.add(txtArea,BorderLayout.EAST);
		return txtArea;
	}
	
	public static void setLogOutput(String log){
		logOutput.setText(log);
	}
}
