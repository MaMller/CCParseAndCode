

import java.util.Arrays;

import org.sikuli.script.Region;

import com.sun.jna.*;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.win32.*;





public class FindWindowRect extends Thread {

	private static int[] regionInt;
	private static final String windowTitle = "Anwesenheitskontrolle";
	private static boolean running = true;

	public FindWindowRect() {
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
			regionInt = getRect(windowTitle);
			if (regionInt == null) {
				System.out.print("Fenster :\"" + windowTitle + "\" nicht aktiv\n");
			}else{
				// Debug ausgabe, austauschen mit enterTheCode();
				System.out.print(Arrays.toString(regionInt));
				
				AutoCCCode accc = new AutoCCCode();
				accc.startAutoCCCode(regionInt);
				return;
			}
			
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// Hier kann ruhig nen System.exit() hin
			}
		}
	}
	
	
}
