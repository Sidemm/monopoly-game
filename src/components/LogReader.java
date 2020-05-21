package components;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;


public class LogReader {
	
	public static JSONObject obj ;
	
	public static JSONObject getObj() {
		return obj;
	}
	
	public static String convertStreamToString(InputStream is) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        reader.close();
        return sb.toString();
    }
	
	public static String createRootText (File fl) throws Exception {
        FileInputStream fin = new FileInputStream(fl);
        String JSONtext = convertStreamToString(fin);
        //Make sure you close all streams.
        fin.close();
        return JSONtext;
    }
	
	public static void createRootObject(String JSONtext)
	{
		obj = new JSONObject(JSONtext);
	}
	
	public static int returnNumberOfPlayers()
	{
		return obj.getJSONObject("Game").getJSONArray("Players").length();
	}
	
	public static void savePlayerPosition(int playerID, int position)
	{
		obj.getJSONObject("Game").getJSONArray("Players").getJSONObject(playerID).remove("position");
		obj.getJSONObject("Game").getJSONArray("Players").getJSONObject(playerID).put("position", position);
	}

	public static int returnPlayerPosition(int playerID)
	{
		return obj.getJSONObject("Game").getJSONArray("Players").getJSONObject(playerID).getInt("position");

	}
	
	public static void savePlayerMoney(int playerID, int money)
	{
		obj.getJSONObject("Game").getJSONArray("Players").getJSONObject(playerID).remove("money");
		obj.getJSONObject("Game").getJSONArray("Players").getJSONObject(playerID).put("money", money);
	}
	
	public static int returnPlayerMoney(int playerID)
	{
		return obj.getJSONObject("Game").getJSONArray("Players").getJSONObject(playerID).getInt("money");
	}
	
	public static void savePlayerAssetsArray(int playerID, JSONArray assetArr)
	{
		obj.getJSONObject("Game").getJSONArray("Players").getJSONObject(playerID).remove("buildings");
		obj.getJSONObject("Game").getJSONArray("Players").getJSONObject(playerID).put("buildings", assetArr);
	}
	
	public static JSONArray returnPlayerAssetsArray(int playerID)
	{
		return obj.getJSONObject("Game").getJSONArray("Players").getJSONObject(playerID).getJSONArray("buildings");
	}
	
	public static void savePlayerDiceHistoryArray(int playerID, JSONArray diceHist)
	{
		obj.getJSONObject("Game").getJSONArray("Players").getJSONObject(playerID).remove("diceHistory");
		obj.getJSONObject("Game").getJSONArray("Players").getJSONObject(playerID).put("diceHistory", diceHist);
	}
	
	public static JSONArray returnPlayerDiceHistoryArray(int playerID)
	{
		return obj.getJSONObject("Game").getJSONArray("Players").getJSONObject(playerID).getJSONArray("diceHistory");
	}
	
	public static void saveLastPlayer(int lastPlayerID)
	{
		obj.getJSONObject("Game").remove("LastPlayerID");
		obj.getJSONObject("Game").put("LastPlayerID",lastPlayerID);
	}
	
	public static int returnLastPlayer()
	{
		return obj.getJSONObject("Game").getInt("LastPlayerID");
	}
	
	public static void saveBankFinalStatus(int bankFinalStatus)
	{
		obj.getJSONObject("Game").remove("BankFinalStatus");
		obj.getJSONObject("Game").put("BankFinalStatus",bankFinalStatus);
	}
	
	public static int returnBankFinalStatus()
	{
		return obj.getJSONObject("Game").getInt("BankFinalStatus");
	}
	
	public static void saveLastDiceArray(JSONArray diceValues)
	{
		obj.getJSONObject("Game").remove("LastDiceValues");
		obj.getJSONObject("Game").put("LastDiceValues",diceValues);
	}
	
	public static JSONArray returnLastDiceArray()
	{
		return obj.getJSONObject("Game").getJSONArray("LastDiceValues");
	}
	
	public static void saveBankruptedPlayers(JSONArray players)
	{
		obj.getJSONObject("Game").remove("BankruptedPlayers");
		obj.getJSONObject("Game").put("BankruptedPlayers",players);
	}
	
	public static JSONArray returnBankruptedPlayersArray()
	{
		return obj.getJSONObject("Game").getJSONArray("BankruptedPlayers");
	}
	

}
