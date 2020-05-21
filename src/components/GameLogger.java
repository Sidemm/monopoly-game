package components;

import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GameLogger {

	public static File file;

	public static boolean loggerIsActive = false;

	public static void init() throws Exception
	{
		openLogger();
		Path path = Paths.get("game_saved_state.json");
		URI puri = path.toUri();
		file = new File(puri);
		String JSONtext = LogReader.createRootText(file);
		LogReader.createRootObject(JSONtext);
	}

	public static File getFile() {
		return file;
	}

	public static void openLogger()
	{
		loggerIsActive = true;
	}

	public static void closeLogger()
	{
		loggerIsActive = false;
	}

	public static void log(String text)
	{
		if(loggerIsActive)
		{	
			System.out.println(text);
		}
	}
	
	public static void updateFile()
	{
		JSONObject obj = LogReader.getObj();
		BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(file));
            writer.write(obj.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the writer regardless of what happens...
                writer.close();
            } catch (Exception e) {
            }
        }
		
	}

}

