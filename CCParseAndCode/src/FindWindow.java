import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIOptions;



public class FindWindow extends Thread {
	
	private static int[] regionInt;
	private static final String windowTitle = "CC Launcher 2.5";
	private static boolean running = true;
	private GUI gui;
	private Date date;
	private SimpleDateFormat sdf;

	public FindWindow() {
		this.gui = Main.getGui();
		gui.setText("Neuer Text aus\n Find Window Rect");
		sdf = new SimpleDateFormat("HH:MM:ss");
	}

	public interface User32 extends StdCallLibrary {
		User32 INSTANCE = (User32) Native.loadLibrary("user32", User32.class, W32APIOptions.DEFAULT_OPTIONS);

		HWND FindWindow(String lpClassName, String lpWindowName);

		int GetWindowRect(HWND handle, int[] rect);
	}

	public static int[] getRect(String windowTitle) {
		HWND hwnd = User32.INSTANCE.FindWindow(null, windowTitle);

		if (hwnd == null) {
			regionInt = null;
		} else {
			regionInt = new int[] { 0, 0, 0, 0 };
			int result = User32.INSTANCE.GetWindowRect(hwnd, regionInt);
			if (result == 0) {
				regionInt = null;
			}
		}
		return regionInt;
	}

	public void run() {
		while (running) {
			this.date = new Date();
			
			
			regionInt = getRect(windowTitle);
			if (regionInt == null) {
				
				System.out.print(sdf.format(date.getTime()) + " Fenster :\"" + windowTitle + "\" nicht aktiv\n");
				gui.setLauncherActive(sdf.format(date.getTime()) + " Fenster :\"" + windowTitle + "\" nicht aktiv\n");
			}else{
				// Debug ausgabe, austauschen mit enterTheCode();
				System.out.print(sdf.format(date.getTime()) + " " + Arrays.toString(regionInt));
				gui.setAnwesenheitsKontrolleActive(sdf.format(date.getTime()) + " Launcher Aktiv an rect: " + Arrays.toString(regionInt));
				
				
				
			}
			
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// Hier kann ruhig nen System.exit() hin
			}
		}
	}

}
