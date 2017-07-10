package gui;

import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import locker.AppLock;
import locker.CrossLock;
import logging.MyLogger;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4714864527745266449L;

	public MainFrame() {
		JFrame frame = new JFrame("CC Log Parse - Auto Code 0.1a");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Image icon = Toolkit.getDefaultToolkit().getImage("img/cc-1.png");
		frame.setIconImage(icon);
		frame.setSize(860, 420);
		frame.addWindowListener(new WindowAdapter() {
			// Fensterstatus -> WIRD geschlossen
			public void windowClosing(WindowEvent ev) {
				// MyLogger.logIt(1, "CCParseAndcode Fenster geschlossen");
				frame.dispose();
			}

			// Fensterstatus -> IST geschlossen, da einziges fenster automatisch
			// awt exit
			public void windowClosed(WindowEvent ev) {
				System.exit(0);
			}
		});

		new GuiElements(frame);

		frame.setVisible(true);
	}

	public static void main(String[] args) {
		String lockString = "lockThisAppRightNow";
		CrossLock lockInstance = new CrossLock(lockString);
		if (lockInstance.lock()) {
			new MainFrame();
		} else {
			System.out.println("Only Single Instance allowed!");
		}

	}

}
