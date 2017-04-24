import org.sikuli.script.Region;

public class ImgPathes {
	private String sendButtonPath = "img/send.png";
	private String[] imgPathes = new String[10];
	public ImgPathes()  {
		for (int i = 0; i <= 9;i++)  {
			String imgPath = "img/" + i + ".png";
			this.imgPathes[i] = imgPath;
		}
		
	}
	
	

	public String[] codeStringToPathArray(String code)  {
		String[] pathArray = new String[code.length()];
		int[] intArray = new int[code.length()];
 		for (int i = 0;i < code.length();i++)  {
			intArray[i] = Integer.parseInt(code.substring(i,i+1));
			
		}
		for (int i = 0;i < intArray.length; i++)  {
			pathArray[i] = imgPathes[intArray[i]];
			
		}
		return pathArray;
		
	}
	
	public String getTheCode()  {
		Region region = new Region(500,245,100,150);
		String text = region.text();
		System.out.println("Anfang:"+text.trim()+"Ende");
		return text.trim();
		}
	
	public String getSendButtonPath() {
		return sendButtonPath;
	}

	public void setSendButtonPath(String sendButtonPath) {
		this.sendButtonPath = sendButtonPath;
	}
}
