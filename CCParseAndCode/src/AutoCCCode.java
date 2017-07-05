import org.sikuli.basics.Settings;
import org.sikuli.script.Region;

public class AutoCCCode {
	private Region region;

	public AutoCCCode() {
	}

	public boolean startAutoCCCode(int[] regionInt) {
		int x = regionInt[0];
		int y = regionInt[1];
		int width = regionInt[2] - regionInt[0];
		int height = regionInt[3] - regionInt[1];
		this.region = new Region(x, y, width, height);
		Settings.OcrTextSearch = true;
		Settings.OcrTextRead = true;
		EnterCode enterCode = new EnterCode();
		
		String code = getTheCode(region);
		return enterCode.enterTheCode(code,this.region);
	}

	public String getTheCode(Region region) {
		// Region region = new Region(500,245,100,150);

		String text = region.text();
		String lines[] = text.split("\\r?\\n");
		for (int i = 0; i < lines.length; i++) {
			if (lines[i].trim().length() == 4) {
				try {
					Integer.parseInt(lines[i].trim());
					text = lines[i];
					break;
				} catch (NumberFormatException e) {
					System.out.println(lines[i] + " ist kein Code");
				}
			}
		}
		System.out.println("Kontroll Code:" + text.trim() );//+ "Ende");
		return text.trim();
	}
}
