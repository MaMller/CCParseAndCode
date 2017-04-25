import java.applet.Applet;

public class Main  {
	private static String currentWindowsUser = System.getProperty("user.name"); 
	private static String date = "2017-04-22";
	private static FindWindowRect windowFinder;
	private static boolean debug = true;
	private static GUI gui = new GUI();
	/*
	 * args[0] -> Username
	 * 
	 */
	
	public static final GUI getGui()  {
		return gui;
	}
	
	public static void main(String[] args)  {
		Main m = new Main();
		
		
		
		// m.setText("neuer Text");
		// m.repaint();
		
		System.out.println("Aktueller Windows User: " + currentWindowsUser) ;
		windowFinder = new FindWindowRect();
		// CC Log Parser starten
		CCLogParser ccLogParser = new CCLogParser();
		InputOutput io = new InputOutput();
		
		if (debug || io.inputYes(io.inputWithMsg(io.getStartAutoCCCode(), 1)))  {
			windowFinder.start();
			
		}  else  {
			System.out.println("... Programm beendet");
		}
		
		
	}
}
