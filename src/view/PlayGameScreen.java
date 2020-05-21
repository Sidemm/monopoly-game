package view;

import controller.GameViewController;
import domain.Game;
import domain.Location;
import domain.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayGameScreen {
	private static JFrame frame;
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;
	private static JTextField textField_3;
	public JPanel tokenArray[];
	private static JTextField dice1;
	private static JTextField dice2;
	private static JTextField dice3;

	static JLabel LogLabel;
	static JButton yesButton;
	static JButton noButton;
	static JButton rollButton;
	static JButton nextButton;

	private JTextField p1;
	private JTextField p2;
	private JTextField p3;
	private JTextField p4;
	private JTextField p5;
	private JTextField p6;
	private JTextField p7;
	private JTextField p8;
	private JTextField p9;
	private JTextField p10;
	private JTextField p11;
	private JTextField p12;
	private JTextField p21;
	private JTextField p22;
	private JTextField p23;
	private JTextField p24;
	private JTextField p25;
	private JTextField p26;
	private JTextField p27;
	private JTextField p28;
	private JTextField p29;
	private JTextField p210;
	private JTextField p211;
	private JTextField p212;
	private JTextField p31;
	private JTextField p32;
	private JTextField p33;
	private JTextField p34;
	private JTextField p35;
	private JTextField p36;
	private JTextField p37;
	private JTextField p38;
	private JTextField p39;
	private JTextField p310;
	private JTextField p311;
	private JTextField p312;
	private JTextField p41;
	private JTextField p42;
	private JTextField p43;
	private JTextField p44;
	private JTextField p45;
	private JTextField p46;
	private JTextField p47;
	private JTextField p48;
	private JTextField p49;
	private JTextField p410;
	private JTextField p411;
	private JTextField p412;
	
	public PlayGameScreen() {
		initialize();
	}

	public static void createAndShowGUI() {
		PlayGameScreen window = new PlayGameScreen();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setUndecorated(true);
		window.frame.setVisible(true);
		GameViewController.signalPlay();
	}

	public static void newInstance()
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					createAndShowGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 * @param monopolyBoard 
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.WHITE);
		frame.setForeground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon image = new ImageIcon("image/myboard.png");
		int iwidth=image.getIconWidth();
		int iheight=image.getIconHeight();
		JLabel lblNewLabel = new JLabel("",image,JLabel.CENTER);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		lblNewLabel.setBounds(width/2-iwidth/2, 0, 1060, 1060);
		JPanel panel=new JPanel();
		panel.setLayout(null);
		frame.getContentPane().add(panel);
		tokenArray=new JPanel[20];

		JComboBox<Location> comboBox = new JComboBox<Location>();
		comboBox.setBounds(1600, 450, 250, 30);
		comboBox.addItem(null);
		panel.add(comboBox);

		nextButton = new JButton("Next Player");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				GameViewController.turnFinished();
				rollButton.setVisible(true);
				comboBox.removeAllItems();
				for(int i = 0; i<Game.currentPlayer.getPlayerAssets().size(); i++){
					comboBox.addItem(Game.getCurrentPlayer().getPlayerAssets().get(i));
				}

			}

		});


		nextButton.setForeground(Color.WHITE);
		nextButton.setBackground(Color.BLUE);
		nextButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		nextButton.setBounds(1615, 955, 210, 47);
		panel.add(nextButton);

		JPanel boxpanel10 = new JPanel();
		boxpanel10.setLocation(width/2-iwidth/2-32,277);
		boxpanel10.setSize(32, 130);
		boxpanel10.setBorder(null);
		boxpanel10.setLayout(null);
		panel.add(boxpanel10,BorderLayout.PAGE_START);
		tokenArray[9]=boxpanel10;


		Label label_76 = new Label("");
		label_76.setBackground(Color.RED);
		label_76.setBounds(0, 3, 32, 30);
		boxpanel10.add(label_76);

		Label label_77 = new Label("");
		label_77.setBackground(Color.BLUE);
		label_77.setBounds(0, 35, 32, 30);
		boxpanel10.add(label_77);

		Label label_78 = new Label("");
		label_78.setBackground(Color.GREEN);
		label_78.setBounds(0, 67, 32, 30);
		boxpanel10.add(label_78);

		Label label_79 = new Label("");
		label_79.setBackground(Color.MAGENTA);
		label_79.setBounds(0, 99, 32, 30);
		boxpanel10.add(label_79);

		JPanel boxpanel9 = new JPanel();
		boxpanel9.setLocation(width/2-iwidth/2-32,402);
		boxpanel9.setSize(32, 130);
		boxpanel9.setBorder(null);
		boxpanel9.setLayout(null);
		panel.add(boxpanel9,BorderLayout.PAGE_START);
		tokenArray[8]=boxpanel9;


		Label label_72 = new Label("");
		label_72.setBackground(Color.RED);
		label_72.setBounds(0, 3, 32, 30);
		boxpanel9.add(label_72);

		Label label_73 = new Label("");
		label_73.setBackground(Color.BLUE);
		label_73.setBounds(0, 35, 32, 30);
		boxpanel9.add(label_73);

		Label label_74 = new Label("");
		label_74.setBackground(Color.GREEN);
		label_74.setBounds(0, 67, 32, 30);
		boxpanel9.add(label_74);

		Label label_75 = new Label("");
		label_75.setBackground(Color.MAGENTA);
		label_75.setBounds(0, 99, 32, 30);
		boxpanel9.add(label_75);

		JPanel boxpanel8 = new JPanel();
		boxpanel8.setLocation(width/2-iwidth/2-32,530);
		boxpanel8.setSize(32, 130);
		boxpanel8.setBorder(null);
		boxpanel8.setLayout(null);
		panel.add(boxpanel8,BorderLayout.PAGE_START);
		tokenArray[7]=boxpanel8;


		Label label_68 = new Label("");
		label_68.setBackground(Color.RED);
		label_68.setBounds(0, 3, 32, 30);
		boxpanel8.add(label_68);

		Label label_69 = new Label("");
		label_69.setBackground(Color.BLUE);
		label_69.setBounds(0, 35, 32, 30);
		boxpanel8.add(label_69);

		Label label_70 = new Label("");
		label_70.setBackground(Color.GREEN);
		label_70.setBounds(0, 67, 32, 30);
		boxpanel8.add(label_70);

		Label label_71 = new Label("");
		label_71.setBackground(Color.MAGENTA);
		label_71.setBounds(0, 99, 32, 30);
		boxpanel8.add(label_71);

		JPanel boxpanel7 = new JPanel();
		boxpanel7.setLocation(width/2-iwidth/2-32,650);
		boxpanel7.setSize(32, 130);
		boxpanel7.setBorder(null);
		boxpanel7.setLayout(null);
		panel.add(boxpanel7,BorderLayout.PAGE_START);
		tokenArray[6]=boxpanel7;


		Label label_64 = new Label("");
		label_64.setBackground(Color.RED);
		label_64.setBounds(0, 3, 32, 30);
		boxpanel7.add(label_64);

		Label label_65 = new Label("");
		label_65.setBackground(Color.BLUE);
		label_65.setBounds(0, 35, 32, 30);
		boxpanel7.add(label_65);

		Label label_66 = new Label("");
		label_66.setBackground(Color.GREEN);
		label_66.setBounds(0, 67, 32, 30);
		boxpanel7.add(label_66);

		Label label_67 = new Label("");
		label_67.setBackground(Color.MAGENTA);
		label_67.setBounds(0, 99, 32, 30);
		boxpanel7.add(label_67);

		JPanel boxpanel6 = new JPanel();
		boxpanel6.setLocation(width/2-iwidth/2, iheight+32);
		boxpanel6.setSize(134, 32);
		boxpanel6.setBorder(null);
		boxpanel6.setLayout(null);
		panel.add(boxpanel6,BorderLayout.PAGE_START);
		tokenArray[5]=boxpanel6;


		Label label_60 = new Label("");
		label_60.setBackground(Color.RED);
		label_60.setBounds(0, 0, 32, 30);
		boxpanel6.add(label_60);

		Label label_61 = new Label("");
		label_61.setBackground(Color.BLUE);
		label_61.setBounds(33, 0, 32, 30);
		boxpanel6.add(label_61);

		Label label_62 = new Label("");
		label_62.setBackground(Color.GREEN);
		label_62.setBounds(66, 0, 32, 30);
		boxpanel6.add(label_62);

		Label label_63 = new Label("");
		label_63.setBackground(Color.MAGENTA);
		label_63.setBounds(99, 0, 32, 30);
		boxpanel6.add(label_63);

		JPanel boxpanel5 = new JPanel();
		boxpanel5.setLocation(width/2-iwidth/2+268, iheight+32);
		boxpanel5.setSize(134, 32);
		boxpanel5.setBorder(null);
		boxpanel5.setLayout(null);
		panel.add(boxpanel5,BorderLayout.PAGE_START);
		tokenArray[4]=boxpanel5;


		Label label_56 = new Label("");
		label_56.setBackground(Color.RED);
		label_56.setBounds(0, 0, 32, 30);
		boxpanel5.add(label_56);

		Label label_57 = new Label("");
		label_57.setBackground(Color.BLUE);
		label_57.setBounds(33, 0, 32, 30);
		boxpanel5.add(label_57);

		Label label_58 = new Label("");
		label_58.setBackground(Color.GREEN);
		label_58.setBounds(66, 0, 32, 30);
		boxpanel5.add(label_58);

		Label label_59 = new Label("");
		label_59.setBackground(Color.MAGENTA);
		label_59.setBounds(99, 0, 32, 30);
		boxpanel5.add(label_59);

		JPanel boxpanel4 = new JPanel();
		boxpanel4.setLocation(width/2-iwidth/2+402, iheight+32);
		boxpanel4.setSize(134, 32);
		boxpanel4.setBorder(null);
		boxpanel4.setLayout(null);
		panel.add(boxpanel4,BorderLayout.PAGE_START);
		tokenArray[3]=boxpanel4;


		Label label_52 = new Label("");
		label_52.setBackground(Color.RED);
		label_52.setBounds(0, 0, 32, 30);
		boxpanel4.add(label_52);

		Label label_53 = new Label("");
		label_53.setBackground(Color.BLUE);
		label_53.setBounds(33, 0, 32, 30);
		boxpanel4.add(label_53);

		Label label_54 = new Label("");
		label_54.setBackground(Color.GREEN);
		label_54.setBounds(66, 0, 32, 30);
		boxpanel4.add(label_54);

		Label label_55 = new Label("");
		label_55.setBackground(Color.MAGENTA);
		label_55.setBounds(99, 0, 32, 30);
		boxpanel4.add(label_55);

		JPanel boxpanel3 = new JPanel();
		boxpanel3.setLocation(width/2-iwidth/2+536, iheight+32);
		boxpanel3.setSize(134, 32);
		boxpanel3.setBorder(null);
		boxpanel3.setLayout(null);
		panel.add(boxpanel3,BorderLayout.PAGE_START);
		tokenArray[2]=boxpanel3;


		Label label_48 = new Label("");
		label_48.setBackground(Color.RED);
		label_48.setBounds(0, 0, 32, 30);
		boxpanel3.add(label_48);

		Label label_49 = new Label("");
		label_49.setBackground(Color.BLUE);
		label_49.setBounds(33, 0, 32, 30);
		boxpanel3.add(label_49);

		Label label_50 = new Label("");
		label_50.setBackground(Color.GREEN);
		label_50.setBounds(66, 0, 32, 30);
		boxpanel3.add(label_50);

		Label label_51 = new Label("");
		label_51.setBackground(Color.MAGENTA);
		label_51.setBounds(99, 0, 32, 30);
		boxpanel3.add(label_51);

		JPanel boxpanel2 = new JPanel();
		boxpanel2.setLocation(width/2-iwidth/2+670, iheight+32);
		boxpanel2.setSize(134, 32);
		boxpanel2.setBorder(null);
		boxpanel2.setLayout(null);
		panel.add(boxpanel2,BorderLayout.PAGE_START);
		tokenArray[1]=boxpanel2;



		Label label_44 = new Label("");
		label_44.setBackground(Color.RED);
		label_44.setBounds(0, 0, 32, 30);
		boxpanel2.add(label_44);

		Label label_45 = new Label("");
		label_45.setBackground(Color.BLUE);
		label_45.setBounds(33, 0, 32, 30);
		boxpanel2.add(label_45);

		Label label_46 = new Label("");
		label_46.setBackground(Color.GREEN);
		label_46.setBounds(66, 0, 32, 30);
		boxpanel2.add(label_46);

		Label label_47 = new Label("");
		label_47.setBackground(Color.MAGENTA);
		label_47.setBounds(99, 0, 32, 30);
		boxpanel2.add(label_47);

		JPanel boxpanel1 = new JPanel();
		boxpanel1.setLocation(width/2-iwidth/2+804, iheight+32);
		boxpanel1.setSize(134, 32);
		boxpanel1.setBorder(null);
		boxpanel1.setLayout(null);
		panel.add(boxpanel1,BorderLayout.PAGE_START);
		tokenArray[0]=boxpanel1;


		Label label_40 = new Label("");
		label_40.setBackground(Color.RED);
		label_40.setBounds(0, 0, 32, 30);
		boxpanel1.add(label_40);

		Label label_41 = new Label("");
		label_41.setBackground(Color.BLUE);
		label_41.setBounds(33, 0, 32, 30);
		boxpanel1.add(label_41);

		Label label_42 = new Label("");
		label_42.setBackground(Color.GREEN);
		label_42.setBounds(66, 0, 32, 30);
		boxpanel1.add(label_42);

		Label label_43 = new Label("");
		label_43.setBackground(Color.MAGENTA);
		label_43.setBounds(99, 0, 32, 30);
		boxpanel1.add(label_43);

		JPanel boxpanel20 = new JPanel();
		boxpanel20.setLocation(width/2+iwidth/2,650);
		boxpanel20.setSize(32, 130);
		boxpanel20.setBorder(null);
		boxpanel20.setLayout(null);
		panel.add(boxpanel20,BorderLayout.PAGE_START);
		tokenArray[19]=boxpanel20;

		Label label_36 = new Label("");
		label_36.setBackground(Color.RED);
		label_36.setBounds(0, 3, 32, 30);
		boxpanel20.add(label_36);

		Label label_37 = new Label("");
		label_37.setBackground(Color.BLUE);
		label_37.setBounds(0, 35, 32, 30);
		boxpanel20.add(label_37);

		Label label_38 = new Label("");
		label_38.setBackground(Color.GREEN);
		label_38.setBounds(0, 67, 32, 30);
		boxpanel20.add(label_38);

		Label label_39 = new Label("");
		label_39.setBackground(Color.MAGENTA);
		label_39.setBounds(0, 99, 32, 30);
		boxpanel20.add(label_39);

		JPanel boxpanel19 = new JPanel();
		boxpanel19.setLocation(width/2+iwidth/2,530);
		boxpanel19.setSize(32, 130);
		boxpanel19.setBorder(null);
		boxpanel19.setLayout(null);
		panel.add(boxpanel19,BorderLayout.PAGE_START);
		tokenArray[18]=boxpanel19;

		Label label_24 = new Label("");
		label_24.setBackground(Color.RED);
		label_24.setBounds(0, 3, 32, 30);
		boxpanel19.add(label_24);

		Label label_25 = new Label("");
		label_25.setBackground(Color.BLUE);
		label_25.setBounds(0, 35, 32, 30);
		boxpanel19.add(label_25);

		Label label_26 = new Label("");
		label_26.setBackground(Color.GREEN);
		label_26.setBounds(0, 67, 32, 30);
		boxpanel19.add(label_26);

		Label label_27 = new Label("");
		label_27.setBackground(Color.MAGENTA);
		label_27.setBounds(0, 99, 32, 30);
		boxpanel19.add(label_27);

		JPanel boxpanel18 = new JPanel();
		boxpanel18.setLocation(width/2+iwidth/2,402);
		boxpanel18.setSize(32, 130);
		boxpanel18.setBorder(null);
		boxpanel18.setLayout(null);
		panel.add(boxpanel18,BorderLayout.PAGE_START);
		tokenArray[17]=boxpanel18;

		Label label_32 = new Label("");
		label_32.setBackground(Color.RED);
		label_32.setBounds(0, 3, 32, 30);
		boxpanel18.add(label_32);

		Label label_33 = new Label("");
		label_33.setBackground(Color.BLUE);
		label_33.setBounds(0, 35, 32, 30);
		boxpanel18.add(label_33);

		Label label_34 = new Label("");
		label_34.setBackground(Color.GREEN);
		label_34.setBounds(0, 67, 32, 30);
		boxpanel18.add(label_34);

		Label label_35 = new Label("");
		label_35.setBackground(Color.MAGENTA);
		label_35.setBounds(0, 99, 32, 30);
		boxpanel18.add(label_35);

		JPanel boxpanel17 = new JPanel();
		boxpanel17.setLocation(width/2+iwidth/2,277);
		boxpanel17.setSize(32, 130);
		boxpanel17.setBorder(null);
		boxpanel17.setLayout(null);
		panel.add(boxpanel17,BorderLayout.PAGE_START);	
		tokenArray[16]=boxpanel17;

		Label label_28 = new Label("");
		label_28.setBackground(Color.RED);
		label_28.setBounds(0, 3, 32, 30);
		boxpanel17.add(label_28);

		Label label_29 = new Label("");
		label_29.setBackground(Color.BLUE);
		label_29.setBounds(0, 35, 32, 30);
		boxpanel17.add(label_29);

		Label label_30 = new Label("");
		label_30.setBackground(Color.GREEN);
		label_30.setBounds(0, 67, 32, 30);
		boxpanel17.add(label_30);

		Label label_31 = new Label("");
		label_31.setBackground(Color.MAGENTA);
		label_31.setBounds(0, 99, 32, 30);
		boxpanel17.add(label_31);


		JPanel boxpanel16 = new JPanel();
		boxpanel16.setLocation(width/2-iwidth/2+804, 0);
		boxpanel16.setSize(134, 32);
		boxpanel16.setBorder(null);
		boxpanel16.setLayout(null);
		panel.add(boxpanel16,BorderLayout.PAGE_START);
		tokenArray[15]=boxpanel16;

		Label label_20 = new Label("");
		label_20.setBackground(Color.RED);
		label_20.setBounds(0, 0, 32, 30);
		boxpanel16.add(label_20);

		Label label_21 = new Label("");
		label_21.setBackground(Color.BLUE);
		label_21.setBounds(33, 0, 32, 30);
		boxpanel16.add(label_21);

		Label label_22 = new Label("");
		label_22.setBackground(Color.GREEN);
		label_22.setBounds(66, 0, 32, 30);
		boxpanel16.add(label_22);

		Label label_23 = new Label("");
		label_23.setBackground(Color.MAGENTA);
		label_23.setBounds(99, 0, 32, 30);
		boxpanel16.add(label_23);

		JPanel boxpanel14 = new JPanel();
		boxpanel14.setLocation(width/2-iwidth/2+536, 0);
		boxpanel14.setSize(134, 32);
		boxpanel14.setBorder(null);
		boxpanel14.setLayout(null);
		panel.add(boxpanel14,BorderLayout.PAGE_START);
		tokenArray[13]=boxpanel14;

		Label label_12 = new Label("");
		label_12.setBackground(Color.RED);
		label_12.setBounds(0, 0, 32, 30);
		boxpanel14.add(label_12);

		Label label_13 = new Label("");
		label_13.setBackground(Color.BLUE);
		label_13.setBounds(33, 0, 32, 30);
		boxpanel14.add(label_13);

		Label label_14 = new Label("");
		label_14.setBackground(Color.GREEN);
		label_14.setBounds(66, 0, 32, 30);
		boxpanel14.add(label_14);

		Label label_15 = new Label("");
		label_15.setBackground(Color.MAGENTA);
		label_15.setBounds(99, 0, 32, 30);
		boxpanel14.add(label_15);

		JPanel boxpanel13 = new JPanel();
		boxpanel13.setLocation(width/2-iwidth/2+402, 0);
		boxpanel13.setSize(134, 32);
		boxpanel13.setBorder(null);
		boxpanel13.setLayout(null);
		panel.add(boxpanel13,BorderLayout.PAGE_START);
		tokenArray[12]=boxpanel13;

		Label label_8 = new Label("");
		label_8.setBackground(Color.RED);
		label_8.setBounds(0, 0, 32, 30);
		boxpanel13.add(label_8);

		Label label_9 = new Label("");
		label_9.setBackground(Color.BLUE);
		label_9.setBounds(33, 0, 32, 30);
		boxpanel13.add(label_9);

		Label label_10 = new Label("");
		label_10.setBackground(Color.GREEN);
		label_10.setBounds(66, 0, 32, 30);
		boxpanel13.add(label_10);

		Label label_11 = new Label("");
		label_11.setBackground(Color.MAGENTA);
		label_11.setBounds(99, 0, 32, 30);
		boxpanel13.add(label_11);

		JPanel boxpanel15 = new JPanel();
		boxpanel15.setLocation(width/2-iwidth/2+670, 0);
		boxpanel15.setSize(134, 32);
		boxpanel15.setBorder(null);
		boxpanel15.setLayout(null);
		panel.add(boxpanel15,BorderLayout.PAGE_START);
		tokenArray[14]=boxpanel15;

		Label label_16 = new Label("");
		label_16.setBackground(Color.RED);
		label_16.setBounds(0, 0, 32, 30);
		boxpanel15.add(label_16);

		Label label_17 = new Label("");
		label_17.setBackground(Color.BLUE);
		label_17.setBounds(33, 0, 32, 30);
		boxpanel15.add(label_17);

		Label label_18 = new Label("");
		label_18.setBackground(Color.GREEN);
		label_18.setBounds(66, 0, 32, 30);
		boxpanel15.add(label_18);

		Label label_19 = new Label("");
		label_19.setBackground(Color.MAGENTA);
		label_19.setBounds(99, 0, 32, 30);
		boxpanel15.add(label_19);

		JPanel boxpanel12 = new JPanel();
		boxpanel12.setLocation(width/2-iwidth/2+268, 0);
		boxpanel12.setSize(134, 32);
		boxpanel12.setBorder(null);
		boxpanel12.setLayout(null);
		panel.add(boxpanel12,BorderLayout.PAGE_START);
		tokenArray[11]=boxpanel12;

		Label label_4 = new Label("");
		label_4.setBackground(Color.RED);
		label_4.setBounds(0, 0, 32, 30);
		boxpanel12.add(label_4);

		Label label_5 = new Label("");
		label_5.setBackground(Color.BLUE);
		label_5.setBounds(33, 0, 32, 30);
		boxpanel12.add(label_5);

		Label label_6 = new Label("");
		label_6.setBackground(Color.GREEN);
		label_6.setBounds(66, 0, 32, 30);
		boxpanel12.add(label_6);

		Label label_7 = new Label("");
		label_7.setBackground(Color.MAGENTA);
		label_7.setBounds(99, 0, 32, 30);
		boxpanel12.add(label_7);

		JPanel boxpanel11=new JPanel();
		boxpanel11.setLocation(width/2-iwidth/2, 0);
		boxpanel11.setSize(134, 32);
		boxpanel11.setBorder(null);
		boxpanel11.setLayout(null);
		panel.add(boxpanel11,BorderLayout.PAGE_START);
		tokenArray[10]=boxpanel11;

		Label label = new Label("");
		label.setBackground(Color.RED);
		label.setBounds(0, 0, 32, 30);
		boxpanel11.add(label);

		Label label_1 = new Label("");
		label_1.setBackground(Color.BLUE);
		label_1.setBounds(33, 0, 32, 30);
		boxpanel11.add(label_1);

		Label label_2 = new Label("");
		label_2.setBackground(Color.GREEN);
		label_2.setBounds(66, 0, 32, 30);
		boxpanel11.add(label_2);

		Label label_3 = new Label("");
		label_3.setBackground(Color.MAGENTA);
		label_3.setBounds(99, 0, 32, 30);
		boxpanel11.add(label_3);
		panel.add(lblNewLabel,BorderLayout.PAGE_START);


		for(int i=1;i<20;i++) {
			for(int j=0;j<4;j++) {
				tokenArray[i].getComponent(j).setVisible(false);
			}
		}
		if(Game.numberOfPlayers==3)
			tokenArray[0].getComponent(3).setVisible(false);

		if(Game.numberOfPlayers==2) {
			tokenArray[0].getComponent(3).setVisible(false);
			tokenArray[0].getComponent(2).setVisible(false);

		}

		textField = new JTextField();
		textField.setBackground(new Color(255, 255, 102));
		textField.setEditable(false);
		textField.setForeground(new Color(128, 128, 128));
		textField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField.setText("3200");
		textField.setBounds(127, 270, 76, 26);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblPlayer_1 = new JLabel(" Player 2   $");
		lblPlayer_1.setForeground(new Color(0, 153, 204));
		lblPlayer_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPlayer_1.setBackground(new Color(224, 255, 255));
		lblPlayer_1.setBounds(207, 258, 147, 47);
		panel.add(lblPlayer_1);

		textField_1 = new JTextField();
		textField_1.setBackground(new Color(255, 255, 102));
		textField_1.setText("3200");
		textField_1.setForeground(new Color(128, 128, 128));
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(332, 270, 76, 26);
		panel.add(textField_1);


		JLabel lblPlayer_3 = new JLabel("   Player 3   $");
		lblPlayer_3.setForeground(new Color(0, 153, 204));
		lblPlayer_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPlayer_3.setBackground(Color.WHITE);
		lblPlayer_3.setBounds(1510, 258, 147, 47);
		if(!(Game.numberOfPlayers>=3))
			lblPlayer_3.setVisible(false);
		panel.add(lblPlayer_3);

		textField_3 = new JTextField();
		textField_3.setText("3200");
		textField_3.setForeground(new Color(128, 128, 128));
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBackground(new Color(255, 255, 102));
		textField_3.setBounds(1646, 270, 76, 26);
		if(!(Game.numberOfPlayers>=3))
			textField_3.setVisible(false);
		panel.add(textField_3);


		JLabel lblPlayer_2 = new JLabel("   Player 4   $");
		lblPlayer_2.setForeground(new Color(0, 153, 204));
		lblPlayer_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPlayer_2.setBackground(Color.WHITE);
		lblPlayer_2.setBounds(1706, 258, 147, 47);
		if(!(Game.numberOfPlayers==4))
			lblPlayer_2.setVisible(false);
		panel.add(lblPlayer_2);

		textField_2 = new JTextField();
		textField_2.setText("3200");
		textField_2.setForeground(new Color(128, 128, 128));
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBackground(new Color(255, 255, 102));
		textField_2.setBounds(1845, 270, 76, 26);
		if(!(Game.numberOfPlayers==4))
			textField_2.setVisible(false);
		panel.add(textField_2);

		rollButton = new JButton("Roll Dice!");
		rollButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					GameViewController.startTimer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int[] faceValue =GameViewController.updateDice();

				dice1.setText(" "+Integer.toString(faceValue[0]));
				dice2.setText(" "+Integer.toString(faceValue[1]));
				dice3.setText(" "+Integer.toString(faceValue[2]));
				rollButton.setVisible(false);
				int sumFaceValue=faceValue[0]+faceValue[1];
				if(faceValue[2]<=4) sumFaceValue+=faceValue[2]; 

				refreshToken(sumFaceValue);
				GameViewController.keepPlaying();


			}

			private void refreshToken(int sumfaceValue) {
				Player currentPlayer=GameViewController.getCurrentPlayers();

				tokenArray[currentPlayer.getPlayerPosition()].getComponent(currentPlayer.getPlayerID()).setVisible(false);
				tokenArray[(currentPlayer.getPlayerPosition()+sumfaceValue)%20].getComponent(currentPlayer.getPlayerID()).setVisible(true);

				//Add $200 at every pass at GO square 

				/*	if(currentPlayer.getPlayerPosition()+faceValue[0]+faceValue[1]>=20) {

					currentPlayer.setPlayerBalance(currentPlayer.getPlayerBalance()+200);

					switch(currentPlayer.getPlayerID()) {
					case 0:
						PlayGameScreen.setTextField(Integer.toString(currentPlayer.getPlayerBalance())); break;
					case 1:
						PlayGameScreen.setTextField_1(Integer.toString(currentPlayer.getPlayerBalance())); break;
					case 2:
						PlayGameScreen.setTextField_2(Integer.toString(currentPlayer.getPlayerBalance())); break;
					case 3:
						PlayGameScreen.setTextField_3(Integer.toString(currentPlayer.getPlayerBalance())); break;
					}
				}
				 */	
			}
		});


		rollButton.setForeground(Color.BLACK);
		rollButton.setBackground(Color.WHITE);
		rollButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		rollButton.setBounds(50, 116, 160, 62);
		panel.add(rollButton);

		dice1 = new JTextField();
		dice1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 25));
		dice1.setBounds(225, 140, 32, 26);
		panel.add(dice1);
		dice1.setColumns(10);

		dice2 = new JTextField();
		dice2.setFont(new Font("Tempus Sans ITC", Font.BOLD, 25));
		dice2.setColumns(10);
		dice2.setBounds(256, 140, 32, 26);
		panel.add(dice2);

		dice3 = new JTextField();
		dice3.setFont(new Font("Tempus Sans ITC", Font.BOLD, 25));
		dice3.setColumns(10);
		dice3.setBounds(287, 140, 32, 26);
		panel.add(dice3);

		LogLabel = new JLabel("");
		LogLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
		LogLabel.setBounds(lblNewLabel.getX()+iwidth+5, 97, 450, 118);
		panel.add(LogLabel);

		yesButton = new JButton("Yes");
		yesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Location loc=GameViewController.purchaseConfirmed();
				Player currentPlayer=GameViewController.getCurrentPlayers();


				switch(currentPlayer.getPlayerID()) {

				case 0: 
					textField.setText(Integer.toString(Integer.parseInt(textField.getText())-loc.getLocationPrice())); 
					for (Component jc : panel.getComponents()) {
						if ( jc instanceof JTextField && jc.getX()==10) {
							JTextField temp= (JTextField) jc;
							if(temp.getText().equals(loc.getName())) {
								temp.setVisible(true);
							}
						}

					}
					break;

				case 1:
					textField_1.setText(Integer.toString(Integer.parseInt(textField_1.getText())-loc.getLocationPrice())); 
					for (Component jc : panel.getComponents()) {
						if ( jc instanceof JTextField && jc.getX()==217) {
							JTextField temp= (JTextField) jc;
							if(temp.getText().equals(loc.getName())) {
								temp.setVisible(true);
							}
						}

					}
					break;
				case 2:
					textField_2.setText(Integer.toString(Integer.parseInt(textField_2.getText())-loc.getLocationPrice())); 
					for (Component jc : panel.getComponents()) {
						if ( jc instanceof JTextField && jc.getX()==1530) {
							JTextField temp= (JTextField) jc;
							if(temp.getText().equals(loc.getName())) {
								temp.setVisible(true);
							}
						}

					}
					break;
				case 3:
					textField_3.setText(Integer.toString(Integer.parseInt(textField_3.getText())-loc.getLocationPrice())); 
					for (Component jc : panel.getComponents()) {
						if ( jc instanceof JTextField && jc.getX()==1738) {
							JTextField temp= (JTextField) jc;
							if(temp.getText().equals(loc.getName())) {
								temp.setVisible(true);
							}
						}

					}
					break;
				}

				LogLabel.setText("");
				yesButton.setVisible(false);
				noButton.setVisible(false);

			}
		}); 


		yesButton.setBounds(lblNewLabel.getX()+iwidth+55, 201, 115, 29);
		panel.add(yesButton);
		yesButton.setVisible(false);



		noButton = new JButton("No");
		noButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogLabel.setText("");
				yesButton.setVisible(false);
				noButton.setVisible(false);
			}
		});


		noButton.setBounds(yesButton.getX()+yesButton.getWidth()+60, 201, 115, 29);
		panel.add(noButton);
		noButton.setVisible(false);


		JLabel lblPlayer = new JLabel(" Player 1   $");
		lblPlayer.setForeground(new Color(0, 153, 204));
		lblPlayer.setBackground(new Color(224, 255, 255));
		lblPlayer.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPlayer.setBounds(0, 258, 147, 47);
		panel.add(lblPlayer);

		p2 = new JTextField();
		p2.setVisible(false);

		p1 = new JTextField();
		p1.setVisible(false);
		p1.setFont(new Font("Verdana", Font.PLAIN, 16));
		p1.setEditable(false);
		p1.setText("Oriental Avenue");
		p1.setBackground(new Color(153, 153, 255));
		p1.setBounds(10, 321, 193, 26);
		panel.add(p1);
		p1.setColumns(10);
		p2.setText("Vermont Avenue");
		p2.setFont(new Font("Verdana", Font.PLAIN, 16));
		p2.setEditable(false);
		p2.setColumns(10);
		p2.setBackground(new Color(153, 153, 255));
		p2.setBounds(10, 363, 193, 26);
		panel.add(p2);

		p3 = new JTextField();
		p3.setVisible(false);
		p3.setText("Connecticut Avenue");
		p3.setFont(new Font("Verdana", Font.PLAIN, 16));
		p3.setEditable(false);
		p3.setColumns(10);
		p3.setBackground(new Color(153, 153, 255));
		p3.setBounds(10, 408, 193, 26);
		panel.add(p3);

		p4 = new JTextField();
		p4.setVisible(false);
		p4.setText("St. Charles Place");
		p4.setFont(new Font("Verdana", Font.PLAIN, 16));
		p4.setEditable(false);
		p4.setColumns(10);
		p4.setBackground(new Color(255, 51, 102));
		p4.setBounds(10, 451, 193, 26);
		panel.add(p4);

		p5 = new JTextField();
		p5.setVisible(false);
		p5.setText("States Avenue");
		p5.setFont(new Font("Verdana", Font.PLAIN, 16));
		p5.setEditable(false);
		p5.setColumns(10);
		p5.setBackground(new Color(255, 51, 102));
		p5.setBounds(10, 493, 193, 26);
		panel.add(p5);

		p6 = new JTextField();
		p6.setVisible(false);
		p6.setText("Virginia Avenue");
		p6.setFont(new Font("Verdana", Font.PLAIN, 16));
		p6.setEditable(false);
		p6.setColumns(10);
		p6.setBackground(new Color(255, 51, 102));
		p6.setBounds(10, 534, 193, 26);
		panel.add(p6);

		p7 = new JTextField();
		p7.setVisible(false);
		p7.setText("St. James Place");
		p7.setFont(new Font("Verdana", Font.PLAIN, 16));
		p7.setEditable(false);
		p7.setColumns(10);
		p7.setBackground(new Color(255, 153, 0));
		p7.setBounds(10, 576, 193, 26);
		panel.add(p7);

		p8 = new JTextField();
		p8.setVisible(false);
		p8.setText("Tenessee Avenue");
		p8.setFont(new Font("Verdana", Font.PLAIN, 16));
		p8.setEditable(false);
		p8.setColumns(10);
		p8.setBackground(new Color(255, 153, 0));
		p8.setBounds(10, 618, 193, 26);
		panel.add(p8);

		p9 = new JTextField();
		p9.setVisible(false);
		p9.setText("New York Avenue");
		p9.setFont(new Font("Verdana", Font.PLAIN, 16));
		p9.setEditable(false);
		p9.setColumns(10);
		p9.setBackground(new Color(255, 153, 0));
		p9.setBounds(10, 660, 193, 26);
		panel.add(p9);

		p10 = new JTextField();
		p10.setVisible(false);
		p10.setText("Pacific Avenue");
		p10.setFont(new Font("Verdana", Font.PLAIN, 16));
		p10.setEditable(false);
		p10.setColumns(10);
		p10.setBackground(new Color(51, 153, 51));
		p10.setBounds(10, 702, 193, 26);
		panel.add(p10);

		p11 = new JTextField();
		p11.setVisible(false);
		p11.setText("North Carolina Avenue");
		p11.setFont(new Font("Verdana", Font.PLAIN, 16));
		p11.setEditable(false);
		p11.setColumns(10);
		p11.setBackground(new Color(51, 153, 51));
		p11.setBounds(10, 744, 193, 26);
		panel.add(p11);

		p12 = new JTextField();
		p12.setVisible(false);
		p12.setText("Pennsylvania Avenue");
		p12.setFont(new Font("Verdana", Font.PLAIN, 16));
		p12.setEditable(false);
		p12.setColumns(10);
		p12.setBackground(new Color(51, 153, 51));
		p12.setBounds(10, 786, 193, 26);
		panel.add(p12);

		p21 = new JTextField();
		p21.setVisible(false);
		p21.setText("Oriental Avenue");
		p21.setFont(new Font("Verdana", Font.PLAIN, 16));
		p21.setEditable(false);
		p21.setColumns(10);
		p21.setBackground(new Color(153, 153, 255));
		p21.setBounds(217, 321, 193, 26);
		panel.add(p21);

		p22 = new JTextField();
		p22.setVisible(false);
		p22.setText("Vermont Avenue");
		p22.setFont(new Font("Verdana", Font.PLAIN, 16));
		p22.setEditable(false);
		p22.setColumns(10);
		p22.setBackground(new Color(153, 153, 255));
		p22.setBounds(217, 363, 193, 26);
		panel.add(p22);

		p23 = new JTextField();
		p23.setVisible(false);
		p23.setText("Connecticut Avenue");
		p23.setFont(new Font("Verdana", Font.PLAIN, 16));
		p23.setEditable(false);
		p23.setColumns(10);
		p23.setBackground(new Color(153, 153, 255));
		p23.setBounds(217, 408, 193, 26);
		panel.add(p23);

		p24 = new JTextField();
		p24.setVisible(false);
		p24.setText("St. Charles Place");
		p24.setFont(new Font("Verdana", Font.PLAIN, 16));
		p24.setEditable(false);
		p24.setColumns(10);
		p24.setBackground(new Color(255, 51, 102));
		p24.setBounds(217, 451, 193, 26);
		panel.add(p24);

		p25 = new JTextField();
		p25.setVisible(false);
		p25.setText("States Avenue");
		p25.setFont(new Font("Verdana", Font.PLAIN, 16));
		p25.setEditable(false);
		p25.setColumns(10);
		p25.setBackground(new Color(255, 51, 102));
		p25.setBounds(217, 493, 193, 26);
		panel.add(p25);

		p26 = new JTextField();
		p26.setVisible(false);
		p26.setText("Virginia Avenue");
		p26.setFont(new Font("Verdana", Font.PLAIN, 16));
		p26.setEditable(false);
		p26.setColumns(10);
		p26.setBackground(new Color(255, 51, 102));
		p26.setBounds(217, 534, 193, 26);
		panel.add(p26);

		p27 = new JTextField();
		p27.setVisible(false);
		p27.setText("St. James Place");
		p27.setFont(new Font("Verdana", Font.PLAIN, 16));
		p27.setEditable(false);
		p27.setColumns(10);
		p27.setBackground(new Color(255, 153, 0));
		p27.setBounds(217, 576, 193, 26);
		panel.add(p27);

		p28 = new JTextField();
		p28.setVisible(false);
		p28.setText("Tenessee Avenue");
		p28.setFont(new Font("Verdana", Font.PLAIN, 16));
		p28.setEditable(false);
		p28.setColumns(10);
		p28.setBackground(new Color(255, 153, 0));
		p28.setBounds(217, 618, 193, 26);
		panel.add(p28);

		p29 = new JTextField();
		p29.setVisible(false);
		p29.setText("New York Avenue");
		p29.setFont(new Font("Verdana", Font.PLAIN, 16));
		p29.setEditable(false);
		p29.setColumns(10);
		p29.setBackground(new Color(255, 153, 0));
		p29.setBounds(217, 660, 193, 26);
		panel.add(p29);

		p210 = new JTextField();
		p210.setVisible(false);
		p210.setText("Pacific Avenue");
		p210.setFont(new Font("Verdana", Font.PLAIN, 16));
		p210.setEditable(false);
		p210.setColumns(10);
		p210.setBackground(new Color(51, 153, 51));
		p210.setBounds(217, 702, 193, 26);
		panel.add(p210);

		p211 = new JTextField();
		p211.setVisible(false);
		p211.setText("North Carolina Avenue");
		p211.setFont(new Font("Verdana", Font.PLAIN, 16));
		p211.setEditable(false);
		p211.setColumns(10);
		p211.setBackground(new Color(51, 153, 51));
		p211.setBounds(217, 744, 193, 26);
		panel.add(p211);

		p212 = new JTextField();
		p212.setVisible(false);
		p212.setText("Pennsylvania Avenue");
		p212.setFont(new Font("Verdana", Font.PLAIN, 16));
		p212.setEditable(false);
		p212.setColumns(10);
		p212.setBackground(new Color(51, 153, 51));
		p212.setBounds(217, 786, 193, 26);
		panel.add(p212);

		p31 = new JTextField();
		p31.setVisible(false);
		p31.setText("Oriental Avenue");
		p31.setFont(new Font("Verdana", Font.PLAIN, 16));
		p31.setEditable(false);
		p31.setColumns(10);
		p31.setBackground(new Color(153, 153, 255));
		p31.setBounds(1530, 321, 193, 26);
		panel.add(p31);

		p32 = new JTextField();
		p32.setVisible(false);
		p32.setText("Vermont Avenue");
		p32.setFont(new Font("Verdana", Font.PLAIN, 16));
		p32.setEditable(false);
		p32.setColumns(10);
		p32.setBackground(new Color(153, 153, 255));
		p32.setBounds(1530, 363, 193, 26);
		panel.add(p32);

		p33 = new JTextField();
		p33.setVisible(false);
		p33.setText("Connecticut Avenue");
		p33.setFont(new Font("Verdana", Font.PLAIN, 16));
		p33.setEditable(false);
		p33.setColumns(10);
		p33.setBackground(new Color(153, 153, 255));
		p33.setBounds(1530, 408, 193, 26);
		panel.add(p33);

		p34 = new JTextField();
		p34.setVisible(false);
		p34.setText("St. Charles Place");
		p34.setFont(new Font("Verdana", Font.PLAIN, 16));
		p34.setEditable(false);
		p34.setColumns(10);
		p34.setBackground(new Color(255, 51, 102));
		p34.setBounds(1530, 451, 193, 26);
		panel.add(p34);

		p35 = new JTextField();
		p35.setVisible(false);
		p35.setText("States Avenue");
		p35.setFont(new Font("Verdana", Font.PLAIN, 16));
		p35.setEditable(false);
		p35.setColumns(10);
		p35.setBackground(new Color(255, 51, 102));
		p35.setBounds(1530, 493, 193, 26);
		panel.add(p35);

		p36 = new JTextField();
		p36.setVisible(false);
		p36.setText("Virginia Avenue");
		p36.setFont(new Font("Verdana", Font.PLAIN, 16));
		p36.setEditable(false);
		p36.setColumns(10);
		p36.setBackground(new Color(255, 51, 102));
		p36.setBounds(1530, 534, 193, 26);
		panel.add(p36);

		p37 = new JTextField();
		p37.setVisible(false);
		p37.setText("St. James Place");
		p37.setFont(new Font("Verdana", Font.PLAIN, 16));
		p37.setEditable(false);
		p37.setColumns(10);
		p37.setBackground(new Color(255, 153, 0));
		p37.setBounds(1530, 576, 193, 26);
		panel.add(p37);

		p38 = new JTextField();
		p38.setVisible(false);
		p38.setText("Tenessee Avenue");
		p38.setFont(new Font("Verdana", Font.PLAIN, 16));
		p38.setEditable(false);
		p38.setColumns(10);
		p38.setBackground(new Color(255, 153, 0));
		p38.setBounds(1530, 618, 193, 26);
		panel.add(p38);

		p39 = new JTextField();
		p39.setVisible(false);
		p39.setText("New York Avenue");
		p39.setFont(new Font("Verdana", Font.PLAIN, 16));
		p39.setEditable(false);
		p39.setColumns(10);
		p39.setBackground(new Color(255, 153, 0));
		p39.setBounds(1530, 660, 193, 26);
		panel.add(p39);

		p310 = new JTextField();
		p310.setVisible(false);
		p310.setText("Pacific Avenue");
		p310.setFont(new Font("Verdana", Font.PLAIN, 16));
		p310.setEditable(false);
		p310.setColumns(10);
		p310.setBackground(new Color(51, 153, 51));
		p310.setBounds(1530, 702, 193, 26);
		panel.add(p310);

		p311 = new JTextField();
		p311.setVisible(false);
		p311.setText("North Carolina Avenue");
		p311.setFont(new Font("Verdana", Font.PLAIN, 16));
		p311.setEditable(false);
		p311.setColumns(10);
		p311.setBackground(new Color(51, 153, 51));
		p311.setBounds(1530, 744, 193, 26);
		panel.add(p311);

		p312 = new JTextField();
		p312.setVisible(false);
		p312.setText("Pennsylvania Avenue");
		p312.setFont(new Font("Verdana", Font.PLAIN, 16));
		p312.setEditable(false);
		p312.setColumns(10);
		p312.setBackground(new Color(51, 153, 51));
		p312.setBounds(1530, 786, 193, 26);
		panel.add(p312);

		p41 = new JTextField();
		p41.setVisible(false);
		p41.setText("Oriental Avenue");
		p41.setFont(new Font("Verdana", Font.PLAIN, 16));
		p41.setEditable(false);
		p41.setColumns(10);
		p41.setBackground(new Color(153, 153, 255));
		p41.setBounds(1738, 321, 193, 26);
		panel.add(p41);

		p42 = new JTextField();
		p42.setVisible(false);
		p42.setText("Vermont Avenue");
		p42.setFont(new Font("Verdana", Font.PLAIN, 16));
		p42.setEditable(false);
		p42.setColumns(10);
		p42.setBackground(new Color(153, 153, 255));
		p42.setBounds(1738, 363, 193, 26);
		panel.add(p42);

		p43 = new JTextField();
		p43.setVisible(false);
		p43.setText("Connecticut Avenue");
		p43.setFont(new Font("Verdana", Font.PLAIN, 16));
		p43.setEditable(false);
		p43.setColumns(10);
		p43.setBackground(new Color(153, 153, 255));
		p43.setBounds(1738, 408, 193, 26);
		panel.add(p43);

		p44 = new JTextField();
		p44.setVisible(false);
		p44.setText("St. Charles Place");
		p44.setFont(new Font("Verdana", Font.PLAIN, 16));
		p44.setEditable(false);
		p44.setColumns(10);
		p44.setBackground(new Color(255, 51, 102));
		p44.setBounds(1738, 451, 193, 26);
		panel.add(p44);

		p45 = new JTextField();
		p45.setVisible(false);
		p45.setText("States Avenue");
		p45.setFont(new Font("Verdana", Font.PLAIN, 16));
		p45.setEditable(false);
		p45.setColumns(10);
		p45.setBackground(new Color(255, 51, 102));
		p45.setBounds(1738, 493, 193, 26);
		panel.add(p45);

		p46 = new JTextField();
		p46.setVisible(false);
		p46.setText("Virginia Avenue");
		p46.setFont(new Font("Verdana", Font.PLAIN, 16));
		p46.setEditable(false);
		p46.setColumns(10);
		p46.setBackground(new Color(255, 51, 102));
		p46.setBounds(1738, 534, 193, 26);
		panel.add(p46);

		p47 = new JTextField();
		p47.setVisible(false);
		p47.setText("St. James Place");
		p47.setFont(new Font("Verdana", Font.PLAIN, 16));
		p47.setEditable(false);
		p47.setColumns(10);
		p47.setBackground(new Color(255, 153, 0));
		p47.setBounds(1738, 576, 193, 26);
		panel.add(p47);

		p48 = new JTextField();
		p48.setVisible(false);
		p48.setText("Tenessee Avenue");
		p48.setFont(new Font("Verdana", Font.PLAIN, 16));
		p48.setEditable(false);
		p48.setColumns(10);
		p48.setBackground(new Color(255, 153, 0));
		p48.setBounds(1738, 618, 193, 26);
		panel.add(p48);

		p49 = new JTextField();
		p49.setVisible(false);
		p49.setText("New York Avenue");
		p49.setFont(new Font("Verdana", Font.PLAIN, 16));
		p49.setEditable(false);
		p49.setColumns(10);
		p49.setBackground(new Color(255, 153, 0));
		p49.setBounds(1738, 660, 193, 26);
		panel.add(p49);

		p410 = new JTextField();
		p410.setVisible(false);
		p410.setText("Pacific Avenue");
		p410.setFont(new Font("Verdana", Font.PLAIN, 16));
		p410.setEditable(false);
		p410.setColumns(10);
		p410.setBackground(new Color(51, 153, 51));
		p410.setBounds(1738, 702, 193, 26);
		panel.add(p410);

		p411 = new JTextField();
		p411.setVisible(false);
		p411.setText("North Carolina Avenue");
		p411.setFont(new Font("Verdana", Font.PLAIN, 16));
		p411.setEditable(false);
		p411.setColumns(10);
		p411.setBackground(new Color(51, 153, 51));
		p411.setBounds(1738, 744, 193, 26);
		panel.add(p411);

		p412 = new JTextField();
		p412.setVisible(false);
		p412.setText("Pennsylvania Avenue");
		p412.setFont(new Font("Verdana", Font.PLAIN, 16));
		p412.setEditable(false);
		p412.setColumns(10);
		p412.setBackground(new Color(51, 153, 51));
		p412.setBounds(1738, 786, 193, 26);
		panel.add(p412);

		JRadioButton houseButton = new JRadioButton("House");
		houseButton.setBounds(1600, 550, 127, 25);
		panel.add(houseButton);
		houseButton.setSelected(true);

		JRadioButton hotelButton = new JRadioButton("Hotel");
		hotelButton.setBounds(1600, 600, 127, 25);
		panel.add(hotelButton);

		JRadioButton skyscraperButton = new JRadioButton("Skyscraper");
		skyscraperButton.setBounds(1600, 650, 127, 25);
		panel.add(skyscraperButton);

		ButtonGroup group = new ButtonGroup();
		group.add(houseButton);
		group.add(hotelButton);
		group.add(skyscraperButton);

		JButton buildButton = new JButton("Build");
		buildButton.setBounds(1750, 500, 97, 25);
		panel.add(buildButton);
		buildButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Location loc = comboBox.getItemAt(comboBox.getSelectedIndex());
				String type = "";
				if(houseButton.isSelected()){
					type = "House";
				}else if(hotelButton.isSelected()){
					type = "Hotel";
				}else{
					type = "Skyscraper";
				}
				Player currentPlayer = GameViewController.getCurrentPlayers();
				currentPlayer.build(type, loc);
				switch(currentPlayer.getPlayerID()){
				case 0: textField.setText(Integer.toString(currentPlayer.getPlayerBalance()));
				break;
				case 1: textField_1.setText(Integer.toString(currentPlayer.getPlayerBalance()));
				break;
				}

			}

		});


		//	noButton.setVisible(false);


	}
	public static void InvisibleRollButton(){
		rollButton.setVisible(false);
	}

	public static void VisibleButton() {
		yesButton.setVisible(true);
		noButton.setVisible(true);

	}

	public static void setLog(String s) {
		LogLabel.setText(s);
	}

	public static void setTextField(String text) {
		textField.setText(text);
	}


	public static void setTextField_1(String text) {
		textField_1.setText(text);
	}


	public static void setTextField_2(String text) {
		textField_2.setText(text);
	}



	public static void setTextField_3(String text) {
		textField_3.setText(text);
	}

	public static void showDecisionFrame() {
		PlayGameScreen.InvisibleRollButton();
		PlayGameScreen.setLog("Do you want to buy this property?");
		PlayGameScreen.VisibleButton();	

	}
}
