import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

public class EnterCode {
	
	public void enterTheCode(String code)  {
		Util util = new Util();
		String[] pathArray = util.codeStringToPathArray(code);
		Screen screen = new Screen();
		
			try {
				for (int i = 0;i < pathArray.length;i++)  {
				screen.click(pathArray[i]);
				}
				screen.click(util.getSendButtonPath());
			} catch (FindFailed e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


