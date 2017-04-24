// New Branch maik1
// ************************************
import java.util.Scanner;

public class InputOutput {
	private String welcomeMsg = "Welcome to CCParseAndCode";
	private String startAutoCCCode = "AutoCCCode starten?";
	private String yesNo = "[J/N]";
	public InputOutput()  {
		
	}
	
	public String inputWithMsg(String msg, int crs)  {
		Scanner scn = new Scanner(System.in);
		System.out.println(msg);
		for (int i = 0; i <= crs; i++)  {
			System.out.print("\n");
		}
		return scn.nextLine();
	}

	

	public boolean inputYes(String yesno)  {
		boolean yes;
		if (yesno.equals("J"))  {
			yes = true;
		}  else  {
			yes = false;
		}
		return yes;
	}
	
	public String getWelcomeMsg() {
		return welcomeMsg;
	}


	public void setWelcomeMsg(String welcomeMsg) {
		this.welcomeMsg = welcomeMsg;
	}
	
	public String getStartAutoCCCode() {
		return startAutoCCCode;
	}

	public void setStartAutoCCCode(String startAutoCCCode) {
		this.startAutoCCCode = startAutoCCCode;
	}

}
