package domain;

import components.GameLogger;
import components.LogReader;
import controller.GameViewController;

import java.awt.*;
import java.util.ArrayList;

public class Game {

    public static Player currentPlayer;
    public static int numberOfPlayers = 0;
    public static int initialAmountMoney = 3400;
    public static ArrayList<Player> players = new ArrayList<Player>();
    int[][] playerDiceHistory = new int[3][2];
    int diceHistory = 0; //doubled dice history
    int count = 0; // count of how many time player rolled on its turn.
    public static Die firstDie;
    public static Die secondDie;
    public static Die speedDie;
    public static Board monopolyBoard;


    public static void main(String[] args) {
        startGame();
    }

    public static void startGame() {
        GameLogger.openLogger();
        GameLogger.log("Welcome to Ultimate Monopoly Game");
        GameViewController.newInstance();
        ObamaBot.newInstance();
        createInstances();

    }

    public static void playGame() {
        currentPlayer.move();
    }


    public static void endTurn() {
        currentPlayer = players.get((currentPlayer.getPlayerID() + 1) % numberOfPlayers);
        playGame();

    }

    public static boolean requirementsAreReady() {
        if (numberOfPlayers >= 2 && numberOfPlayers <= 8)
            return true;
        else
            return false;
    }

    public static void createInstances() {
        firstDie = new Die();
        secondDie = new Die();
        speedDie = new Die();
        monopolyBoard = new Board();

    }

    public static void setInitialPlayers(int numberOfPlayers) {
        Game.players = new ArrayList<Player>();
        setNumberOfPlayers(numberOfPlayers);
        Color[] colors = {Color.RED, Color.PINK, Color.GREEN, Color.YELLOW, Color.ORANGE,
                new Color(156, 39, 176), new Color(63, 81, 181), new Color(0, 188, 212)};
        for (int i = 0; i < numberOfPlayers; i++) {
            Game.players.add(Player.newInstance(i, colors[i]));
            System.out.println("Player " + i + " is added to game with default values");
        }

        currentPlayer = players.get(0);

    }


    public static void startFromFile() {
        int numPlayers = LogReader.returnNumberOfPlayers();
        Game.players = new ArrayList<Player>();
        setNumberOfPlayers(numPlayers);
        Color[] colors = {Color.RED, Color.PINK, Color.GREEN, Color.YELLOW, Color.ORANGE,
                new Color(156, 39, 176), new Color(63, 81, 181), new Color(0, 188, 212)};
        for (int i = 0; i < numberOfPlayers; i++) {
            Player p = Player.newInstance(i, colors[i]);
            p.setPlayerBalance(LogReader.returnPlayerMoney(i));
            p.setPlayerPosition(LogReader.returnPlayerPosition(i));
            Game.players.add(p);
            System.out.println("Player " + i + " is added to game with default values");
        }
    }

    public static Player getCurrentPlayer() {
        return currentPlayer;
    }

    public static void setcurrentPlayer(Player currentPlayer) {
        Game.currentPlayer = currentPlayer;
    }

    public static int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public static void setNumberOfPlayers(int numberOfPlayers) {
        Game.numberOfPlayers = numberOfPlayers;
    }


    public void checkDouble(int faceValue1, int faceValue2) {
        if (faceValue1 == faceValue2 && count == 1) {
            diceHistory++;
            //playerDiceHistory[0][0]=faceValue1;
            //playerDiceHistory[0][1]=faceValue2;
        } else if (faceValue1 == faceValue2 && count == 2) {
            diceHistory++;
            //playerDiceHistory[1][0]=faceValue1;
            //playerDiceHistory[1][1]=faceValue2;

        } else if (faceValue1 == faceValue2 && count == 3) {
            System.out.println("You rolled double third time! Go to Jail!");
            diceHistory = 0;
        } else {
            diceHistory = 0;
            //initializeDiceHistory();
            count = 0;
        }
    }

}