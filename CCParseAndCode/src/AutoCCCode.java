import org.sikuli.basics.Settings;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

public class AutoCCCode {

	public AutoCCCode() {

	}

	public void startAutoCCCode(int[] regionInt) {
		int x = regionInt[0];
		int y = regionInt[1];
		int width = regionInt[2] - regionInt[0];
		int height = regionInt[3] - regionInt[1];
		Region region = new Region(x, y, width, height);
		Settings.OcrTextSearch = true;
		Settings.OcrTextRead = true;
		EnterCode enterCode = new EnterCode();
		/*
		 * Screen screen = new Screen(); try {
		 * screen.click("img/minimize2.png");
		 * 
		 * } catch (FindFailed e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } try { Thread.sleep(3000); } catch
		 * (InterruptedException e1) { // TODO Auto-generated catch block
		 * e1.printStackTrace(); }
		 */
		String code = getTheCode(region);
		enterCode.enterTheCode(code);
	}

	public String getTheCode(Region region) {
		// Region region = new Region(500,245,100,150);

		String text = region.text();
		String lines[] = text.split("\\r?\\n");
		for (int i = 0; i < lines.length; i++) {
			if (lines[i].length() == 4) {
				try {
					Integer.parseInt(lines[i]);
					text = lines[i];
				} catch (NumberFormatException e) {
					System.out.println("Kein Code");
				}
			}
		}
		System.out.println("Anfang:" + text.trim() + "Ende");
		return text.trim();
	}
}
