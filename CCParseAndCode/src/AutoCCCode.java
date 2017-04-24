import org.sikuli.basics.Settings;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import codefinder.findWindowRect;

public class AutoCCCode {
	
	
	private findWindowRect windowFinder;
	
	public AutoCCCode()  {
		this.windowFinder = new findWindowRect();
	}
	
	public void startAutoCCCode() {
		windowFinder.start();
		Settings.OcrTextSearch = true;
		Settings.OcrTextRead = true;
		EnterCode enterCode = new EnterCode();
		/*
		Screen screen = new Screen();
		try {
			screen.click("img/minimize2.png");
			
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		*/
		ImgPathes imgPathes = new ImgPathes();
		String code = imgPathes.getTheCode();
		enterCode.enterTheCode("9574");
	}
}
