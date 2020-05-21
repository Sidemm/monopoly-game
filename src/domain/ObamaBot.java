package domain;

import controller.GameViewController;
//import jdk.nashorn.internal.objects.annotations.Constructor;

/**
 * @author Alpay Sabuncuoglu
 * @version 1.0
 */

/**
 * ObamaBot is an observer who has different behaviors based on certain scenarios during game flow.
 * It uses Obama facial expression to tell its state.
 */
public class ObamaBot implements Runnable {
    // OVERVIEW: Creates a new thread that uses Obama pictures

    public class PlayerObserver extends Observer {
        // EFFECTS: Creates an Observer that observes the Player's current state

        public PlayerObserver() {
            // EFFECTS: Add the current observer to the Player's observer list
            Player.attach(this);
        }

        @Override
        public void update() {
            // EFFECTS: Updates the ViewController according to state change of the Player
            GameViewController.updateObamaBot(Player.getState());
        }
    }

    @Override
    public void run() {
        // EFFECTS: After the thread creation, messages to ViewController to create the Bot Screen and initiates observer
        GameViewController.createBotScreen();
        new PlayerObserver();
    }


    public static void newInstance() {
        // EFFECTS: Creates ObamaBot instance
        (new Thread(new ObamaBot())).start();
    }

    @Override
    public String toString() {
        String obama_quote = " Obama's best quote: Why cant I just eat my waffle?";
        return super.toString()+obama_quote;
    }
}
