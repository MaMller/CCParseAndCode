import org.sikuli.script.FindFailed;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

import logging.MyLogger;

public class EnterCode {

	public boolean enterTheCode(String code, Region region) {
		ImgPathes imgPathes = new ImgPathes();
		String[] pathArray = imgPathes.codeStringToPathArray(code);

		try {
			for (int i = 0; i < pathArray.length; i++) {
				region.click(pathArray[i]);
			}
			int x = region.click(imgPathes.getSendButtonPath());
			MyLogger.logIt(1, "click: " + String.valueOf(x));
			return true;
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Code nicht erkannt, starte neu!");
			FindWindowRect windowFinder = new FindWindowRect();
			windowFinder.start();
			return false;
		}
	}
}
