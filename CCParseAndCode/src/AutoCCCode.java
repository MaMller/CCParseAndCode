import org.sikuli.basics.Settings;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

public class AutoCCCode {

	public static void main(String[] args) {
		Settings.OcrTextSearch = true;
		Settings.OcrTextRead = true;
		EnterCode enterCode = new EnterCode();
		Screen screen = new Screen();
		try {
			screen.click("img/minimize.png");
			
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
		Util util = new Util();
		String code = util.getTheCode();
		enterCode.enterTheCode(code);
	}
}
