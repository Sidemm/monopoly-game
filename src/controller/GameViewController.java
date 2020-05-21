package controller;

import components.GameLogger;
import domain.Game;
import domain.Location;
import domain.Player;
import view.ObamaBotScreen;
import view.PlayGameScreen;
import view.StartGameSettingDialogScreen;


public class GameViewController {

    public static void newInstance() {
        // TODO Auto-generated method stub
        StartGameSettingDialogScreen.newInstance();
    }

    public static void updatePlayers(int numPlayers) {
        Game.setNumberOfPlayers(numPlayers);
        Game.setInitialPlayers(numPlayers);
        GameLogger.log("A game is initiated with " + numPlayers + " players.");
    }

    public static void createBoardInstance() {
        PlayGameScreen.newInstance();
    }

    public static void createBotScreen() {
        ObamaBotScreen.newInstance();
    }

    public static void updateObamaBot(int state) {
        ObamaBotScreen.updateEmojiPanel(state);
    }

    public static void updatePlayers() {
        Game.startFromFile();
    }

    public static void advancetoUnownedLoc(Location location) {
        PlayGameScreen.showDecisionFrame();
    }

    public static void updateToken(Player player) {

    }

    public static int[] updateDice() {

        return new int[]{Game.firstDie.getDieFaceValue(), Game.secondDie.getDieFaceValue(), Game.speedDie.getDieFaceValue()};

    }

    /*	public static void setRolled() {
            Game.diceAreRolled=true;

        }
    */
    public static void signalPlay() {
        Game.playGame();

    }

    public static Player getCurrentPlayers() {
        return Game.getCurrentPlayer();
    }

    public static void keepPlaying() {
        int position = Game.getCurrentPlayer().getPlayerPosition() + Game.firstDie.getDieFaceValue() + Game.secondDie.getDieFaceValue();
        if (Game.speedDie.getDieFaceValue() <= 4) position += Game.speedDie.getDieFaceValue();

        Game.getCurrentPlayer().advanceToSquare(position % 20);

    }

    public static Location purchaseConfirmed() {
        Game.getCurrentPlayer().buyProperty((Location) Game.monopolyBoard.getSquare(Game.getCurrentPlayer().getPlayerPosition()));
        return (Location) Game.monopolyBoard.getSquare(Game.getCurrentPlayer().getPlayerPosition());
    }

    public static void turnFinished() {
        Game.endTurn();

    }

    public static void startTimer() throws InterruptedException {
        Player.start30secondsTimer();
    }


}

