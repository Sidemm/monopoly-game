package view;

import controller.GameViewController;
import domain.Game;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartGameSettingDialogScreen extends JPanel {

	private static final long serialVersionUID = 1L;
	JLabel label;
	JFrame frame;
	String gameSettingsText = "Game Settings:";
	String playerSettingsText = "Player Settings:";
	String buttonText = "Show Options";

	/** Creates the GUI shown inside the frame's content pane. */
	public StartGameSettingDialogScreen(JFrame frame) {
		super(new BorderLayout());
		this.frame = frame;

		//Create the components.
		JPanel gameSettingsPanel = createGameSettingBox();
		JButton startGameButton = new JButton("Start Game");
		startGameButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!Game.requirementsAreReady())
				{
					setLabel("You should first specify the settings" );
					System.out.println(Game.getNumberOfPlayers());
				}
				else
				{
					System.out.println(Game.getNumberOfPlayers());
					System.out.println("Hello darkness my old friend");
					GameViewController.createBoardInstance();
				}
			}
		});
		JButton startFromFileButton = new JButton("Start From File");
		startFromFileButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GameViewController.updatePlayers();
				if(!Game.requirementsAreReady())
					setLabel("You should first specify the settings" );
			}
		});
		label = new JLabel("Click the \"Show Options\" button"
				+ " to see the settings",
				JLabel.CENTER);

		//Lay them out.
		Border padding = BorderFactory.createEmptyBorder(20,20,5,20);
		gameSettingsPanel.setBorder(padding);

		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Game Settings", null,
				gameSettingsPanel,
				gameSettingsText); 

		add(tabbedPane, BorderLayout.CENTER);
		add(label, BorderLayout.AFTER_LINE_ENDS);
		add(startGameButton, BorderLayout.PAGE_END);
		add(startFromFileButton, BorderLayout.PAGE_START);
		label.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
	}

	/** Sets the text displayed at the bottom of the frame. */
	public void setLabel(String newText) {
		label.setText(newText);
	}

	/** Creates the panel shown by the first tab. */
	private JPanel createGameSettingBox() {
		final int numButtons = 1;
		JRadioButton[] radioButtons = new JRadioButton[numButtons];
		final ButtonGroup group = new ButtonGroup();

		JButton showItButton = null;

		final String numberofplayersCommand = "numberofplayers";

		radioButtons[0] = new JRadioButton("Number of Players");
		radioButtons[0].setActionCommand(numberofplayersCommand);

		for (int i = 0; i < numButtons; i++) {
			group.add(radioButtons[i]);
		}
		radioButtons[0].setSelected(true);

		showItButton = new JButton(buttonText);
		showItButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String command = group.getSelection().getActionCommand();

				//Number of players command
				if (command == numberofplayersCommand) {            	
					String s = (String)JOptionPane.showInputDialog(
							frame,
							"Select the number of players (1-8)",
							"Customized Dialog",
							JOptionPane.PLAIN_MESSAGE,
							null,
							null,
							"# Players");

					//If a string was returned, say so.
					if ((s != null) && (s.length() > 0)) {
						try {
							int numPlayers = Integer.parseInt(s);
							if(numPlayers >= 2 && numPlayers <=8)
							{
								GameViewController.updatePlayers(numPlayers);
								setLabel("A Game for "+s+" players is ready" );
								createAndShowGUI();
							}
							else
							{
								setLabel("You should select a number between 2-8" );
							}

						} catch (NumberFormatException n)
						{
							setLabel("You should specify an integer" );
						}
						return;
					}

					//If you're here, the return value was null/empty.
					setLabel("You should select from the menu!");

					//yes/no dialog
				}
				return;
			}
		});

		return createPane(gameSettingsText,
				radioButtons,
				showItButton);
	}

	/**
	 * Used by createSimpleDialogBox and createFeatureDialogBox
	 * to create a pane containing a description, a single column
	 * of radio buttons, and the Show it! button.
	 */
	private JPanel createPane(String description,
			JRadioButton[] radioButtons,
			JButton showButton) {

		int numChoices = radioButtons.length;
		JPanel box = new JPanel();
		JLabel label = new JLabel(description);

		box.setLayout(new BoxLayout(box, BoxLayout.PAGE_AXIS));
		box.add(label);

		for (int i = 0; i < numChoices; i++) {
			box.add(radioButtons[i]);
		}

		JPanel pane = new JPanel(new BorderLayout());
		pane.add(box, BorderLayout.PAGE_START);
		pane.add(showButton, BorderLayout.PAGE_END);
		return pane;
	}

	/**
	 * Create the GUI and show it.  For thread safety,
	 * this method should be invoked from the
	 * event-dispatching thread.
	 */
	private static void createAndShowGUI() {
		//Create and set up the window.
		JFrame frame = new JFrame("Settings");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Create and set up the content pane.
		StartGameSettingDialogScreen newContentPane = new StartGameSettingDialogScreen(frame);
		newContentPane.setOpaque(true); //content panes must be opaque
		frame.setContentPane(newContentPane);

		//Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	public static void newInstance() {
		//Schedule a job for the event-dispatching thread:
		//creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

}

