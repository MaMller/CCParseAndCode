package gui;

import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import locker.AppLock;
import locker.CrossLock;

public class MainFrame extends Frame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4714864527745266449L;

	public MainFrame() {
		Frame frame = new Frame("CC Log Parse - Auto Code 0.1a");

		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("./cc-1.png"));
		frame.setIconImage(icon);
		frame.setSize(860, 420);
		frame.addWindowListener(new WindowAdapter() {
			// Fensterstatus -> WIRD geschlossen
			public void windowClosing(WindowEvent ev) {
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
