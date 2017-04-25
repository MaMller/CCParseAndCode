import java.applet.Applet;

public class Main extends Applet {
	private static String currentWindowsUser = System.getProperty("user.name"); 
	private static String date = "2017-04-22";
	private static FindWindowRect windowFinder;
	private boolean debug = true;
	/*
	 * args[0] -> Username
	 * 
	 */
	
	public static void main(String[] args)  {
		MainCanvas m = new MainCanvas();
		// m.setText("neuer Text");
		// m.repaint();
		
		System.out.println("Aktueller Windows User: " + currentWindowsUser) ;
		windowFinder = new FindWindowRect();
		// CC Log Parser starten
		CCLogParser ccLogParser = new CCLogParser();
		InputOutput io = new InputOutput();
		
		if (io.inputYes(io.inputWithMsg(io.getStartAutoCCCode(), 1)))  {
			windowFinder.start();
			
		}  else  {
			System.out.println("... Programm beendet");
		}
		
		
	}
}
