package logging;

import static java.nio.file.StandardOpenOption.READ;
import static java.nio.file.StandardOpenOption.WRITE;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.jmx.snmp.Timestamp;

public abstract class MyLogger {
	private static Path path;
	
	public static void logIt(int errorCode,String errorDescription)  {
		System.out.println("writeToLog" + timeNow());
		errorDescription = timeNow() + " -> [" + String.valueOf(errorCode) + "] " + errorDescription + System.getProperty("line.separator");
		
		System.out.println(errorDescription);
		writeToFile(errorDescription);
	}
	
	private static void writeToFile(String errorDescription)  {
		path = Paths.get(System.getProperty("user.dir") + File.separator + "Log" + File.separator + "CCParseAndCode.log");
		System.out.println(path);
		
		byte data[];
		
		data = errorDescription.getBytes();

		if (!Files.exists(path)) {
			try {
				Files.createDirectories(path.getParent());
				Files.createFile(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		}
		
		try (FileChannel fc = FileChannel.open(path, StandardOpenOption.APPEND)) {
			ByteBuffer dst = ByteBuffer.wrap(data);
			
			while (dst.hasRemaining())
				
				fc.write(dst);
			dst.rewind();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	private static String timeNow()  {
		Date date = new Date(); 
		String humanTime = null;
		SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd HH:mm");
		humanTime = formatter.format(date);
		// humanTime = String.valueOf((time / 1000) / 60);
		return humanTime;
	}

}
