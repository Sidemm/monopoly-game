package components;

public class LogFileTest {

  public static void main(String[] args) throws Exception {
	  GameLogger.init();
	  System.out.println(LogReader.obj);
	  LogReader.savePlayerPosition(3, 14);
	  System.out.println(LogReader.returnPlayerPosition(2));
	  System.out.println(LogReader.returnPlayerAssetsArray(2));
	  System.out.println(LogReader.obj);
	  GameLogger.updateFile();
  }
}
