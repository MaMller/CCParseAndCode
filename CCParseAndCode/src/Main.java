import gui.GuiElements;
import gui.MainFrame;
import logging.MyLogger;

public class Main {
	private static String currentWindowsUser = System.getProperty("user.name");
	private static String date = "2017-04-22";
	private static FindWindowRect windowFinder;
	private boolean debug = true;

	/*
	 * args[0] -> Username
	 * 
	 */
	public FindWindowRect getWindowFinder() {
		return windowFinder;
	}

	public static void main(String[] args) {
		MyLogger.logIt(1, "CCParseAndCode gestartet");
		MainFrame mf = new MainFrame();

		GuiElements.setStatus("Status Test");

		System.out.println("Aktueller Windows User: " + currentWindowsUser);
		windowFinder = new FindWindowRect();
		// CC Log Parser starten
		CCLogParser ccLogParser = new CCLogParser();
		// InputOutput io = new InputOutput();

		// if (io.inputYes(io.inputWithMsg(io.getStartAutoCCCode(), 1))) {
		windowFinder.start();
		/*
		 * } else { System.out.println("... Programm beendet"); }
		 */

	}
}
