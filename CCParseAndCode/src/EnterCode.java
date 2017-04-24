import org.sikuli.script.FindFailed;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

public class EnterCode {
	
	public void enterTheCode(String code, Region region)  {
		ImgPathes imgPathes = new ImgPathes();
		String[] pathArray = imgPathes.codeStringToPathArray(code);
		
			try {
				for (int i = 0;i < pathArray.length;i++)  {
				region.click(pathArray[i]);
				}
				region.click(imgPathes.getSendButtonPath());
			} catch (FindFailed e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


