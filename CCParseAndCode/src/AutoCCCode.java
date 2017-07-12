import org.sikuli.basics.Settings;
import org.sikuli.script.Region;

import gui.GuiElements;
import logging.MyLogger;

public class AutoCCCode {
	private Region region;
	private int tryCount = 5;

	public AutoCCCode() {
	}

	public boolean startAutoCCCode(int[] regionInt) {
		String code = "-1";
		int count = 0;
		int x = regionInt[0];
		int y = regionInt[1];
		int width = regionInt[2] - regionInt[0];
		int height = regionInt[3] - regionInt[1];
		this.region = new Region(x, y, width, height);
		Settings.OcrTextSearch = true;
		Settings.OcrTextRead = true;
		EnterCode enterCode = new EnterCode();
		for (count = 0;count <= tryCount;count++)  {
		  code = getTheCode(region);
		  if (code != "-1")
			  return enterCode.enterTheCode(code, this.region);
		  }
		return false;
		
	}

	public String getTheCode(Region region) {
		// Region region = new Region(500,245,100,150);

		String text = region.text();
		String lines[] = text.split("\\r?\\n");
		for (int i = 0; i < lines.length; i++) {
			if (lines[i].trim().length() == 4) {
				try {
					Integer.parseInt(lines[i].trim());
					if (lines[i].trim().length() == 4) {
						text = lines[i];
						GuiElements.setLastCode("Kontroll Code:" + text.trim());
						System.out.println("Kontroll Code:" + text.trim());// + "Ende");
						MyLogger.logIt(1, "Kontroll Code:" + text.trim());
						return text.trim();
					}
				} catch (NumberFormatException e) {
					GuiElements.setLastCode(lines[i] + " ist kein Code");
					System.out.println(lines[i] + " ist kein Code");
				}
			}
		}
		return "-1";
		
	}
}
