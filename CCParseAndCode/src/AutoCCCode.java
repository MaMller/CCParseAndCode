import org.sikuli.basics.Settings;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

import codefinder.FindWindowRect;

public class AutoCCCode {
	
	
	
	
	public AutoCCCode()  {
		
	}
	
	public void startAutoCCCode(Region region) {
		
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
		getTheCode(region);
		enterCode.enterTheCode("9574");
	}
	
	public String getTheCode(Region region)  {
		// Region region = new Region(500,245,100,150);
		String text = region.text();
		System.out.println("Anfang:"+text.trim()+"Ende");
		return text.trim();
	}
}
