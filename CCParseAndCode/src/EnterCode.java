import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

public class EnterCode {
	
	public void enterTheCode(String code)  {
		ImgPathes imgPathes = new ImgPathes();
		String[] pathArray = imgPathes.codeStringToPathArray(code);
		Screen screen = new Screen();
		
			try {
				for (int i = 0;i < pathArray.length;i++)  {
				screen.click(pathArray[i]);
				}
				screen.click(imgPathes.getSendButtonPath());

			} catch (FindFailed e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


