package view;

import javax.swing.*;
import java.awt.*;

public class ObamaBotScreen {

    public static JFrame frame;
    public static JPanel mainPanel;

    public static void newInstance()
    {
            mainPanel = new JPanel(new BorderLayout());
            frame = new JFrame();
            frame.setBackground(Color.WHITE);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ImageIcon image = new ImageIcon("image/obama/obama1.png");
            JLabel lblimage = new JLabel(image);
            mainPanel.add(lblimage);
            // add more components here
            frame.add(mainPanel);
            frame.setVisible(true);
    }


    public static void updateEmojiPanel(int state)
    {
        mainPanel.removeAll();
        ImageIcon image = null;
        switch(state)
        {
            case 0:
                image = new ImageIcon("image/obama/obama1.png");
            case 1:
                image = new ImageIcon("image/obama/obama2.png");
            case 2:
                image = new ImageIcon("image/obama/obama3.png");
            case 3:
                image = new ImageIcon("image/obama/obama4.png");
            case 4:
                image = new ImageIcon("image/obama/obama5.png");
            case 5:
                image = new ImageIcon("image/obama/obama6.png");
        }

        JLabel lblimage = new JLabel(image);
        mainPanel.add(lblimage);
        frame.add(mainPanel);
        frame.setVisible(true);
    }

}
